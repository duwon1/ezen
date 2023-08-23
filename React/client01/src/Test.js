import React, { useState } from "react";
// state 변수를 사용하기 위해서는 react 에서 useState 꺼내놔야 사용할수 있음
import "./Test.css";
// COmponent 생성방식은 지금 사용하려는 함수형 방식이 있고, 옛날 방식인 class 방식이 있음
// 함수와 클래스의 형태로 다를 뿐 태그를 리턴한다는 점에서 둘의 방식은 같은 기능을 가진다

// state의 사용 목적 : state 변수의 값이 바뀔때 화면을 재렌더링 하지 않아도 바뀐값을 사용할 수 있는 변수의 사용

// react 컴포넌트안에서 tag에 class 값을 부여할때, className 이라는 속성명을 사용함
function Test() {
    // setState 함수가 실행되서 state 변수가 변경되면, 아주 자연스럽게 그 변수를 소유한 컴포넌트가 render됨
    console.log('Test 컴포넌트에서 render 됩니다')
  // 현재의 위치에서 useState 라는 함수를 이용하여 변수를 만든다
  const [temp, setTemp] = useState(0);
  // 첫번째인자 : 사용할 변수이름
  // 두번째인자 : 변수값 변경할 수 있는 함수
  // 함수 전달인수 : 변수의 초기값 및 type

  return (
    <div>
      <h1 className="test">Test Component 입니다</h1>
      <h2>Temp : {temp}</h2>
      <button onClick={() => {
          setTemp(temp + 1);
        }}>
        증가
      </button>
    </div>
  );
}
// 스크립트에서 사용하던 변수값이 태그안에서 사용될때는 { } 묶어서 사용합니다
// 1. 값을 변경하기 위해서는 반드시 setState(setTemp) 로 지정한 함수를 사용합니다
// setState 함수를 html 태그의 conClick 같은 속성에서 사용하려면 반드시 함수형식으로 사용합니다

export default Test;
// 현재파일에서 export 할 내용(컴포넌트 또는 다른 내용 등)이 두개이상이라면 중괄호로 묶어서 이름을 나열함
// default 는 export 할 내용이 하나일떄 사용
