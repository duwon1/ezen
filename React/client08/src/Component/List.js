import React, { useState, useEffect } from "react";
import axios from "axios";

// List 컴포넌트가 화면에 표시될떄 {text: Hello} 라는 자료를 서버에 axios 를 이용해서 전송할 예정
function List(props) {
  useEffect(() => {
    let message = { text: "Hello" };
    axios
      .post("/api/test", { text: message.text })
      .then((res) => {
        // res : 서버에서 응답으로 되돌아 오는 데이터
        alert('요청성공');
        console.log(res.data.text)
      })
      .catch((err) => {
        // err : 에러발생시 나오는 에러내용
        alert('요청실패');
        console.error(err);
      });
  }, []);
  return (
    <div
      style={{ display: "flex", flexDirection: "column", alignItems: "center" }}
    >
      <h1>
        {/* contentList 에 있는 단어들을 하나씩 출력 */}
        {props.contentList.map((content, index) => {
          return <div key={index}>{content}</div>;
        })}
      </h1>
    </div>
  );
}

export default List;
