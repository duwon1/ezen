import React, { useState, useEffect } from 'react';
import '../Style/board.css'
import axios from 'axios'
import { useNavigate } from 'react-router-dom';

function UpdateMember(props) {
  const navigate = useNavigate()
  const [loginUser, setLoginUser] = useState({
    userid: '',
    pwd: '',
    name: '',
    phone: '',
    email: ''
  })
  const [message, setMessage] = useState('')

  useEffect(() => {
    axios.get('/api/members/getLoginUser').then((result) => {
      setLoginUser(result.data.loginUser)
    }).catch((err) => {
      console.error(err)
    })
    
  }, [])

  const onsubmit = async (e) => {
    e.preventDefault()
    const result = await axios.post('/api/members/updateMember', { loginUser })
    props.setMessage(result.data.message)
    navigate('/main')
  }

  return (
    <div id='wrap'>
      <form id='join-form'>
        <fieldset>
          <legend>회원가입</legend>
          <div><input type='text' placeholder='userid' value={loginUser.userid} disabled /></div>
          <div><input type='password' placeholder='password' value={loginUser.pwd} onChange={(e) => {
            setLoginUser({...loginUser, pwd: e.target.value })
            console.log(loginUser)
          }} /></div>
          <div><input type='text' placeholder='name' value={loginUser.name} onChange={(e) => {
            setLoginUser({...loginUser, name: e.target.value })
            console.log(loginUser)
          }} /></div>
          <div><input type='text' placeholder='phone' value={loginUser.phone} onChange={(e) => {
            setLoginUser({...loginUser, phone: e.target.value })
            console.log(loginUser)
          }} /></div>
          <div><input type='text' placeholder='email' value={loginUser.email} onChange={(e) => {
            setLoginUser({...loginUser, email: e.target.value })
            console.log(loginUser)
          }} /></div>
          <button onClick={(e) => {
            onsubmit(e)
          }}>회원정보 수정</button>
          <div>{message}</div>
        </fieldset>
      </form>
    </div>
  )
}

export default UpdateMember