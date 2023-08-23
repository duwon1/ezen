import React, { useState, useEffect } from 'react'
import '../Style/board.css'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

function Reply(props) {
  const [reply, setReply] = useState('')
  const [loginUser, setLoginUser] = useState({})
  const [replyList, setReplyList] = useState([])
  const [num , setNum] = useState(0)

  

  useEffect(() => {
    axios.get('/api/members/getLoginUser').then((result) => {
      setLoginUser(result.data.loginUser)
    }).catch((err) => {
      console.error(err)
    })

    axios.post('/api/boards/getReplyList',{boardid: props.boardid}).then((result) => {
      setReplyList([...result.data.replyList])
      console.log('받아온 내용', result.data.replyList)
    }).catch((err) => {
      console.error(err)
    })

    


  }, [num])



    const onSubmit = (e) => {
      e.preventDefault()
      axios.post('/api/boards/reply', {reply, boardid: props.boardid, userid: loginUser.userid}).then((result) => {
        setNum(num + 1)
        setReply("")
      }).catch((err) => {
        console.error(err)
      })

  }

  const deleteReply = (e, reply) => {
    e.preventDefault()
    console.log(loginUser.userid, reply.writer, 'dasijdqwoidw')
    if(loginUser.userid != reply.writer) {
      alert('댓글은 작성자만 지울수 있습니다')
      return;
    } else {
      axios.post('/api/boards/deleteReply', {replyid: reply.id}).then((result) => {
        alert('댓글이 삭제 되었습니다')
        setNum(num - 1)
      }).catch((err) => {
        console.error(err)
      })
    }

  }


  return (
    <div id='wrap'>
      <table>
        <thead>
          <tr>
            <th width="140" align='center'>작성일</th>
            <th width="90" align='center'>작성자</th>
            <th width="400" align='center'>내용</th>
            <th width="70" align='center'>비고</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td align='center'>{`${new Date().getMonth()}월${new Date().getDate()}일 ${new Date().getHours()}:${new Date().getMinutes()}`}</td>
            <td align='center'>{loginUser.userid}</td>
            <td><input type='text' value={reply || ''} onChange={(e) => {
              setReply(e.target.value)
            }} /></td>
            <td align='center'><button onClick={(e) => {
              onSubmit(e)
            }}>작성</button></td>
          </tr>            
          {
            replyList.map((reply, index) => {
              return (
                <tr key={index}>
                  <td align='center'>
                    {
                      reply.created_at.substring(5, 7) + "/" + 
                      reply.created_at.substring(8, 10) + " " + 
                      reply.created_at.substring(11, 13) + ":" +
                      reply.created_at.substring(14, 16)
                    }
                  </td>
                  <td align='center'>{reply.writer}</td>
                  <td>{reply.content}</td>
                  <td align='center'>
                    {(loginUser.userid === reply.writer) ? <button onClick={(e) => {
                      deleteReply(e, reply)
                    }}>삭제</button> : null}
                  </td>
                </tr>
              )
            })
          }
        </tbody> 
      </table>     
    </div>
  )
}

export default Reply