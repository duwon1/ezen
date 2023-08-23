import React from "react";
import "./Test.css";

// input 태그로 입력만을 만들고, 입력란에 단어를 입력하고 버튼을 누르면, 입력한 단어가 배열에 추가됨
function Test() {
  const [content, setContent] = React.useState("");
  const [contentList, setContentList] = React.useState([]);
  const onsubmit = () => {
    setContentList([...contentList, content]);
    setContent("");
  }
  return (
    <div>
      <h2 className="test">Test</h2>
      <input type="text" value={content} onChange={(e) => {
          // 현재 이벤트가 일어난 자신을 가르키는 변수 e를 사용
          setContent(e.target.value);
        }} />
      <button onClick={() => {
        onsubmit();
      }}>제출</button><br />

      {
        contentList.map((con, idx) => {
          return <div key={idx}>{con}</div>
        })
      }
    </div>
  );
}
// 반복실행문이나 map 함수를 이용해서 같은 종류의 태그가 연속해서 등장한다면 각 태그들에 key 라는 속성을 부여해서 서로 다른값으로 구분되게 함

export default Test;
