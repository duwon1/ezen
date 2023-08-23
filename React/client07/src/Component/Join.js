import React, { useState, useEffect } from "react";

function Join(props) {
  const [id, setId] = useState("");
  const [pwd, setPwd] = useState("");
  const [pwdChk, setPwdChk] = useState("");
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");

  // react 꺼내와서 내용을 채우고, 같이 넣어준 조건에 맞을때 자동으로 호출되는 함수
  /*
  useEffect(
    () => {
      alert("업로드컴포넌트가 나타났습니다");

      return () => {
        alert("컴포넌트가 사라집니다");
      }; // 컴포넌트가 사라질떄 조건
    }, [  ] // useEffect 가 실핼될 조건. 안쓰면 1번만 실행 
  );
  */

    useEffect(() => {
        console.log('Content 가 바뀌었습니다')
    }, [id, name, email, pwd, pwdChk]);


  const onSubmit = () => {
    if (pwd !== pwdChk) {
      alert(["비밀번호와 확인이 일치하지 않습니다."]);
      return false;
    }
    let temp = {
      id,
      pwd,
      name,
      email,
    };
    let tempArr = [...props.userList];
    tempArr.push(temp);
    props.setUserList([...tempArr]);
    setId("");
    setPwd("");
    setPwdChk("");
    setName("");
    setEmail("");
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
