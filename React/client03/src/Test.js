import React, { useState } from "react";
import "./Test.css";

function Test() {
  const [temp, setTemp] = useState(true);
  return (
    <div>
      {temp ? <h3 className="test">Test 컴포넌트 입니다</h3> : null}
      <button
        onClick={() => {
            setTemp(!temp)
        }}>{temp ? "숨기기" : "보이기"}</button>
    </div>
  );
}

export default Test;

/*
1. 거의 모든 문법이 자바스크립트와 비슷한 문법을 사용함
2. CarmelCase 사용
3. 자바스크립트 문법이나 변수를 사용하기 위해서는 {}로 감싸서 사용합니다
4. css나 style 을 표현할때는 {{}} 로 감싸서 사용합니다
    - <h1 className="" style={{}}>
    - font-size 는 {{}} 안에서 변수의 연산식으로 인식될수 있으므로 fontSize 로 표현
    - 속성명 : "값" 으로 표현, 속성들끼리는 ',' 로 구분
5. 외부의 css 파일을 임포트하여 사용할 수 있음

6. 가정문 : if else, switch
7. 반복문 : for, map
    let Arr = [1, 2, 3]
    Arr.map( (element, index) => {
        return <p>{element}</p>
    })
8. return() 안에서 if else 가 사용이 불가능함
9. 컴포넌트에서 if 를 사용하고 싶으면 
    if() {
        return ()
    } else {
        return ()
    }
*/
