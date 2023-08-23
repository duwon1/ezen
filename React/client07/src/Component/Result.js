import React from 'react'

function Result(props) {
    return (
        <div>
            {
                props.userList.map((user, index) => {
                    return <div key={index}>
                        <br />
                        아이디 : {user.id}<br />
                        비밀번호 : {user.pwd}<br />
                        이름 : {user.name}<br />
                        이메일 : {user.email}<br />
                    </div>
                })
            }
        </div>
    )
}

export default Result
