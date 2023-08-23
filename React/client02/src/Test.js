import react, { useState } from "react";
import "./Test.css";

function Test() {
  const [temp, setTemp] = useState("test");
  // state 값의 초기값은 어떤형태든 가능합니다
  const [tempArr, setTempArr] = useState([]);
  const [number, setNumber] = useState(0);

  return (
    <div className={temp}>
      <h2>({temp}) Component 입니다</h2>
      <h3>{tempArr}</h3>
      <button
        onClick={() => {
          let arr = [...tempArr]; // 기존 배열을 옮겨담기
          setNumber(number + 1);
          arr.push(number); // 요소하나를 추가
          setTempArr([...arr]);
        }}>변경하기</button>
    </div>
  );
}
// state 변수값을 변경하려면 setState 함수를 사용해야 하지만 setState 함수는 배열에 요소를 추가하는 기능은 없습니다. 값을
// 교체해버리기 때문에 [1, 2, 3] 배열이 위문자 실행후 [4] 로 변경됩니다. 그리고 요소가 하나밖에 안남은 배열은 배열로 인식되지 않아서
// push 메서드도 동작되지 않습니다. 이를 위애 위와 같은 방법을 사용함
export default Test;
