import React from "react";

function Login() {
  return (
    <div>
      <form>
        아이디 : <input type="text" placeholder="아이디를 입력하세요" /><br />
        비밀번호 : <input type="text" placeholder="비밀번호를 입력하세요" /><br />
        <button type="submit">전송하기</button>
      </form>
    </div>
  );
}

export default Login;
