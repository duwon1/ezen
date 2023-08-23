import React, { useState, useEffect } from 'react'
import axios from 'axios'
import '../Style/board.css'
import { useNavigate } from 'react-router-dom'
import Reply from './Reply'


function BoardView(props) {
	const navigate = useNavigate()
	const [board, setBoard] = useState({})

	const preventClose = (e) => {
		e.preventDefault();
		e.returnValue = ""; // chrome에서는 설정이 필요해서 넣은 코드
	}

	useEffect(() => {

		(() => {
			window.addEventListener("beforeunload", preventClose);
		})();

		console.log("전송된 아이디 : ", props.boardid)

		axios.post('/api/boards/getBoard', { boardid: props.boardid }).then((result) => {
			setBoard({ ...result.data.board })
			console.log(board)
		}).catch((err) => {
			console.error(err)
		})

		return () => {
			window.removeEventListener("beforeunload", preventClose);
		};

	}, [])

	const deleteBoard = (e) => {
		e.preventDefault()
		if (window.confirm('정말 삭제하시겠습니까?')) {
			axios.post('/api/boards/deleteBoard', { boardid: props.boardid }).then((result) => {
				props.setMessage('게시물이 삭제되었습니다')
				navigate('/main')
			}).catch((err) => {
				console.error(err)
			})
		} else {
			return;
		}

	}

	return (
		<>
			<div id='wrap'>
				<h1 style={{ textAlign: "center" }}>게시글 내용</h1>
				<table>
					<thead>
						<tr>
							<th style={{ width: "150px", textAlign: "center" }}>번호</th>
							<td style={{ width: "200px", textAlign: "center" }}>
								<input type='hidden' id='boardnum' value={board.id} />
								{board.id}
							</td>
							<th style={{ width: "150px", textAlign: "center" }}>작성자</th>
							<td style={{ width: "200px", textAlign: "center" }}>{board.writer}</td>
						</tr>
						<tr>
							<th style={{ width: "150px", textAlign: "center" }}>제목</th>
							<td colSpan="3">{board.subject}</td>
						</tr>
						<tr>
							<th style={{ width: "150px", textAlign: "center" }}>내용</th>
							<td colSpan="2" style={{ height: "300px", width: "300px" }}>
								<pre>{board.content}</pre><br />
							</td>
							<td style={{ height: "300px", width: "300px" }}>
								<img src={'http://localhost:5000' + board.filename} style={{ width: "150px", margin: "0 auto", display: "block" }} />
							</td>
						</tr>
						<tr>
							<td colSpan={"4"}>
								<button onClick={() => { navigate('/updateBoard') }}>수정</button>
								<button onClick={(e) => {
									deleteBoard(e)
								}}>삭제</button>
								<button onClick={() => { navigate('/main') }}>메인으로</button>
							</td>
						</tr>
					</thead>
				</table>
			</div>
			<Reply boardid={props.boardid} setBoardid={props.setBoardid} />
		</>
	)
}

export default BoardView