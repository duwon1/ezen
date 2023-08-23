// Heading 에 member 메뉴 추가하기
// Member컴포넌트가 화면에 나타나면 실행도는 useEffect 를 이용해서 화면을 조회하고, 화면에 출력하세요
// 비동기실행 함수를 useEffect 안에서 동기실행으로 실행하려면

import React, { useState, useEffect } from "react";
import axios from "axios";

function Member() {
  const [memberList, setMemberList] = useState([]);

  useEffect(() => {
    async function fetchData() {
      try {
        const result = await axios.post("/api/members");

        setMemberList(result.data);
        console.log("전달받은 내용 :", memberList);
      } catch (err) {
        console.error(err);
      }
    }
    fetchData();
  }, []);

  return (
    <div style={{ marginTop: "30px"}}>
      <h1 style={{textAlign: "center"}}>사용자 계정정보</h1>
      <table style={{ border: "1px solid black", width: "1000px", margin: "0 auto" }}>
        <thead>
          <tr style={{backgroundColor: "red"}}>
            <th style={{ textAlign: "center", border: "1px solid black" }}>번호</th>
            <th style={{ textAlign: "center", border: "1px solid black" }}>이름</th>
            <th style={{ textAlign: "center", border: "1px solid black" }}>아이디</th>
            <th style={{ textAlign: "center", border: "1px solid black" }}>비밀번호</th>
            <th style={{ textAlign: "center", border: "1px solid black" }}>이메일</th>
            <th style={{ textAlign: "center", border: "1px solid black" }}>전화번호</th>
          </tr>
        </thead>
        {memberList.map((member, index) => {
          return (
            <tbody>
              <tr style={{backgroundColor: "blue", color: "yellow", fontWeight: "bold"}}>
                <td style={{ textAlign: "center", border: "1px solid black" }}>{index + 1}</td>
                <td style={{ textAlign: "center", border: "1px solid black" }}>{member.name}</td>
                <td style={{ textAlign: "center", border: "1px solid black" }}>{member.userid}</td>
                <td style={{ textAlign: "center", border: "1px solid black" }}>{member.pwd}</td>
                <td style={{ textAlign: "center", border: "1px solid black" }}>{member.email}</td>
                <td style={{ textAlign: "center", border: "1px solid black" }}>{member.phone}</td>
              </tr>
            </tbody>
          );
        })}
      </table>
    </div>
  );
}

export default Member;
