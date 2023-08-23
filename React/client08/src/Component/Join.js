import React, { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Join(props) {
  const [id, setId] = useState("");
  const [pwd, setPwd] = useState("");
  const [pwdChk, setPwdChk] = useState("");
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");

  const navigate = useNavigate();

  // react 꺼내와서 내용을 채우고, 같이 넣어준 조건에 맞을때 자동으로 호출되는 함수
  useEffect(() => {
    console.log("Content 가 바뀌었습니다");
  }, [id, name, email, pwd, pwdChk]);

  const onSubmit = () => {
    if (pwd !== pwdChk) {
      alert(["비밀번호와 확인이 일치하지 않습니다."]);
      return false;
    }
    
    axios
      .post('/api/join', {
        id,
        pwd,
        name,
        email,
        phone: '010-1234-1234'
      })
      .then((res) => {
        alert('성공')
        navigate('/')
      })
      .catch((err) => {
        console.error(err);
        navigate('/')
      });
  };
  return (
    <div>
      <fieldset>
        <legend>회원가입</legend>
        <input
          type="text"
          placeholder="아이디"
          value={id}
          onChange={(e) => {
            setId(e.target.value);
          }}
        />
        <br />
        <input
          type="password"
          placeholder="비밀번호"
          value={pwd}
          onChange={(e) => {
            setPwd(e.target.value);
          }}
        />
        <br />
        <input
          type="password"
          placeholder="비밀번호확인"
          value={pwdChk}
          onChange={(e) => {
            setPwdChk(e.target.value);
          }}
        />
        <br />
        <input
          type="text"
          placeholder="이름"
          value={name}
          onChange={(e) => {
            setName(e.target.value);
          }}
        />
        <br />
        <input
          type="text"
          placeholder="이메일"
          value={email}
          onChange={(e) => {
            setEmail(e.target.value);
          }}
        />
        <br />
        <button onClick={() => onSubmit()}>회원가입</button>
      </fieldset>
      <hr />
    </div>
  );
}

export default Join;
