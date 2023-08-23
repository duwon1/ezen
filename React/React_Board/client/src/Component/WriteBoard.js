import React, {useState, useEffect} from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

function WriteBoard() {
  const navigate = useNavigate();
  const [loginUser, setLoginUser] = useState({})
  const [img, setImg] = useState({
    src: '',
    style: {},
  })
  const [board, setBoard] = useState({
    subject: '',
    content: '',
    filename: '',
    realfilename: ''
  })

  useState(() => {
    setImg({...img, style: {display: "none"}})
  })

  useEffect(() => {
    async function fetchData() {
      const result = await axios.get('/api/members/getLoginUser')
      setLoginUser(result.data.loginUser)
    }
    fetchData()
  }, [loginUser.userid])

  const onsubmit = (e) => {
    e.preventDefault()
    if(board.subject === '' || board.content === '' || board.image === '') {
      alert('필드를 모두 채워주세요')
      return;
    } else {
      axios.post('/api/boards/writeBoard', {board}).then((result) => {
        navigate('/main')
      }).catch((err) => {
        console.error(err)
      })
    }
  }
  
  const fileUpload = (e) => {

    var formData = new FormData()
    formData.append('image', e.target.files[0])
    axios.post('/api/boards/fileUpload', formData).then((result) => {
      console.log(result.data.filename, result.data.realfilename)
      setImg({
        ...img, 
        src: `http://localhost:5000${result.data.filename}`,
        style: {display: "block"} 
      })

      setBoard({
        ...board, 
        filename: result.data.filename,
        realfilename: result.data.realfilename
      })
      
    }).catch((err) => {
      console.error(err)
    })
  }

  return (
    <div id='wrap'>
      <h2>게시글 등록</h2>
      <table id='board-list'>
        <thead>
          <tr>
            <th width="100">작성자</th>
            <td width="500">
              <input type='text' value={loginUser.userid || ''}  disabled />
            </td>
          </tr>
          <tr>
            <th width="100">제목</th>
            <td width="500"><input type='text' onChange={(e) => {setBoard({...board, subject: e.target.value});}} /></td>
          </tr>
          <tr>
            <th width="100">내용</th>
            <td width={"500"}><textarea rows={"10"} cols={"95"} onChange={(e) => {setBoard({...board, content: e.target.value})}} /></td>  
          </tr>
          <tr>
            <th width="100">이미지</th>
            <td width="500">
              <input type='file' name='image' id='image' onChange={(e) => {
                fileUpload(e)
              }} />
              <div className='img-preview'>
                <img src={img.src} style={img.style} width={"250"} />
              </div>
            </td>
          </tr>
          <tr height="80">
            <td align='center' colSpan={"2"}>
              <button onClick={(e) => {
                onsubmit(e)
              }}>작성하기</button>
              <button>메인으로</button>
            </td>
          </tr>
        </thead>
      </table>
    </div>
  )
}

export default WriteBoard