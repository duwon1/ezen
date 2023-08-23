import React, { useState, useEffect } from "react";
import axios from "axios";
import "../Style/main.css";
import "../Style/board.css";
import { useNavigate } from "react-router-dom";


function Main(props) {
	const [loginUser, setLoginUser] = useState({});
	const [boardList, setBoardList] = useState([]);
	const [paging, setPaging] = useState({})
	const [beginend, setBeginend] = useState([])
	const navigation = useNavigate()

	useEffect(() => {
		// 컴포넌트가 시작할때, 스크롤 이벤트 발생시
		window.addEventListener("scroll", handleScroll)

		// 컴포넌트가 끝날때 실행되는 명령 
		return () => {
			window.removeEventListener("scroll", handleScroll)
		}
	})

	const handleScroll = () => {
		// scroll 이벤트가 일어나면 실행될 함수
		const scrollHeight = document.documentElement.scrollHeight; // 스크롤이 가능한 크기
		const scrollTop = document.documentElement.scrollTop; // 현재 스크롤 위치
		const clientHeihht = document.documentElement.clientHeight; // 내용물의 크기
		console.log(scrollTop)

		// 현재위치값에 내용물크기를 더한값이 스크롤크기를 넘어선다면 -> 화면 맨 아래까지 스크롤 했다면
		if(scrollTop + clientHeihht >= scrollHeight) {
			onPageMove( Number(paging.page) + 1 )
		}

	}

	useEffect(() => {
		async function fetchData() {
			const result1 = await axios.get("/api/members/getLoginUser");
			if (result1.data.loginUser == undefined) { // 만약 로그인이 안된상태라면 로그인페이지로 이동
				navigation('/')
			}
			setLoginUser(result1.data.loginUser);

			const result2 = await axios.get("/api/boards/getBoardList/1");
			setBoardList([...result2.data.rows]);
			setPaging(result2.data.paging)

			const pageArr = []
			for (let i = result2.data.paging.beginPage; i <= result2.data.paging.endPage; i++) {
				pageArr.push(i)
			}
			setBeginend([...pageArr])
			console.log(result2.data.paging)

			if (props.message != undefined) {
				alert(props.message)
			}
		}
		fetchData();
	}, []);

	const onLogout = () => {
		axios.get('/api/members/logout').then(() => {
			navigation('/')
		}).catch((err) => {
			console.error(err);
		})
	}

	const goBoardView = (id) => {
		console.log(id)
		props.setBoardid(id)
		navigation(`/boardView`)
	}

	const onPageMove = async (p) => {
		alert(p)
		const result2 = await axios.get(`api/boards/getBoardList/${p}`)
		// 다음페이지를 읽어와서 현재게시물 아래에 추가합니다
		// 별도의 배열을 생성해서
		let boards = []
		// 현재 게시물 리스트를 담고
		boards = [...boards, ...result2.data.rows]
		// merge 가 완료된 리스트를 보드리스트에 담습니다
		setBoardList([...boardList, ...boards])
		setPaging(result2.data.paging)
		const pageArr = []
		for (let i = result2.data.paging.beginPage; i <= result2.data.paging.endPage; i++) {
			pageArr.push(i)
		}
		setBeginend([...pageArr])
		console.log(result2.data.paging)
	}

	return (
		<>
			<div id="wrap">
				<h2>{loginUser.userid}({loginUser.name})님 어서오세요</h2>
				<button onClick={() => {
					navigation('/memberEdit')
				}}>회원정보수정</button>
				<button onClick={() => {
					onLogout()
				}}>로그아웃</button>
				<button onClick={() => {
					navigation('/writeBoard')
				}}>글 작성</button>
				<table align="center">
					<thead>
						<tr>
							<th width="100">번호</th>
							<th width="400">제목</th>
							<th width="100">작성자</th>
							<th width="100">작성일</th>
							<th width="100">조회수</th>
						</tr>
					</thead>
					<tbody>
						{boardList.map((item, index) => {
							return (
								<tr key={index} style={{height: '100px'}}>
									<td id="boardnum">{item.id}</td>
									<td onClick={() => {
										goBoardView(item.id)
									}} style={{ cursor: "pointer", color: "red" }}>{item.subject}</td>
									<td id="writer">{item.writer}</td>
									<td id="created_at">{item.created_at.substring(0, 10)}</td>
									<td id="readCount">{item.readCount}</td>
								</tr>
							);
						})}
					</tbody>
				</table>
				<br />
				{/* <div style={{ textAlign: "center" }}>
					{
						(paging.prev) ? (
							<span style={{ cursor: "pointer" }} onClick={() => {
								onPageMove(paging.beginPage - 1)
							}}>&nbsp;◀&nbsp;</span>
						) : (null)
					}
					{
						beginend.map((item, index) => {
							return (
								<span style={{ cursor: "pointer" }} id={item} className="paging" key={index} onClick={() => {
									onPageMove(item)
								}}>&nbsp;{item}&nbsp;</span>

							)
						})
					}
					{
						(paging.next) ? (
							<span style={{ cursor: "pointer" }} onClick={() => {
								onPageMove(paging.endPage + 1)
							}}>&nbsp;▶&nbsp;</span>
						) : (null)
					}
				</div> */}
			</div>
		</>
	);
}

export default Main;
