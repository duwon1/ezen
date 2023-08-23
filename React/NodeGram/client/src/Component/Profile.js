import React from 'react'
import '../Style/head.css'
import '../Style/main.css'
import { useNavigate } from 'react-router-dom'

function Profile(props) {
	const navigate = useNavigate()
	return (
		<div className='container'>
			<div className='profile' style={{fontWeight: 'bold', fontFamily: 'verdana'}}>
				이메일 : {props.loginUser.email}<br />
				이&nbsp;&nbsp;&nbsp;&nbsp;름 : {props.loginUser.nick}<br />
				provider : {props.loginUser.provider}<br />
				{(props.loginUser.provider === 'kakao') ? (props.loginUser.snsid) : null}
				<button className='btn' style={{float: 'right'}} onClick={() => {
					navigate('/')
				}}>메인으로</button>
			</div>
			<hr />
			<div className='profile' style={{fontWeight: 'bold', fontFamily: 'verdana', height:'500px'}}>
				<div className='followings half'>
					<h2>팔로잉 목록</h2>
					{
						props.following.map((foll, idx) => {
							return (
								<div key={idx}>
									{foll.followingid} - {foll.nick} - {foll.followingid}
								</div>
							)
						})
					}
				</div>
				<div className='followers half'>
					<h2>팔로워 목록</h2>
					{
						props.follower.map((foll, idx) => {
							return (
								<div key={idx}>
									{foll.followingid} - {foll.nick} - {foll.followingid}
								</div>
							)
						})
					}
				</div>
			</div>
		</div>
	)
}

export default Profile