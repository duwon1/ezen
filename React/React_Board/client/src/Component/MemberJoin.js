import React, { useState } from 'react'
import '../Style/board.css'
import { useNavigate } from 'react-router-dom'
import axios from 'axios'

function MemberJoin(props) {
  const navigate = useNavigate()
  const [joinUser, setJoinUser] = useState({
    userid: '',
    pwd: '',
    name: '',
    phone: '',
    email: ''
  })
  const [message, setMessage] = useState('')

  const onsubmit = async (e) => {
    e.preventDefault()

    if(joinUser.userid === '' || joinUser.pwd === '' || joinUser.name === '' || joinUser.phone === '' || joinUser.email === ''){
      alert('빈칸을 모두 채워주세요')
    } else {
      // 입력한 내용으로 회원 가입을 하고 로그인페이지로 돌아갑니다
      const result = await axios.post('/api/members/join', {joinUser})
      if(result.data.join == 'fail') {
        setMessage(result.data.message)
      } else {
        props.setMessage(result.data.message)
        navigate('/')
      }
    }
  }

  return (
    <div id='wrap'>
      <form id='join-form'>
        <fieldset>
          <legend>회원가입</legend>
          <div><input type='text' placeholder='userid' value={joinUser.userid} onChange={(e) => {
            setJoinUser({...joinUser, userid: e.target.value })
            console.log(joinUser)
          }} /></div>
          <div><input type='password' placeholder='password' value={joinUser.pwd} onChange={(e) => {
            setJoinUser({...joinUser, pwd: e.target.value })
          }} /></div>
          <div><input type='text' placeholder='name' value={joinUser.name} onChange={(e) => {
            setJoinUser({...joinUser, name: e.target.value })
          }} /></div>
          <div><input type='text' placeholder='phone' value={joinUser.phone} onChange={(e) => {
            setJoinUser({...joinUser, phone: e.target.value })
          }} /></div>
          <div><input type='text' placeholder='email' value={joinUser.email} onChange={(e) => {
            setJoinUser({...joinUser, email: e.target.value })
          }} /></div>
          <button onClick={(e) => {
            onsubmit(e)
          }}>회원가입</button>
          <div>{message}</div>
        </fieldset>
      </form>
    </div>
  )
}

export default MemberJoin