// 변수선언
//자바스크립트 버전에 따라 사용하는 변수선언이 많이 달라지고 있음
// 브라우저를 대상으로 하는 ES2015 버전 이전에는 var 로 변수선언을 많이 했지만 이후부터는 Const 또는 let 변수를 많이 사용함

// var로 선언한 변수 사용예
var x = 3
console.log(x)
x = "홍길동"
console.log(x)


// 상수형 변수 선언 const
// 변수의 생성과 함께 반드시 초기값이 있어야 하며, 이후 저장된 값의 변경이 불가능합니다
const y = 3
console.log('conset y :', y)
// y = '홍길동' // conset 변수는 값을 1회만 할당하고 변경할 수 없습니다


// var 과 conset 의 또다른 차이점
// 블록스코프 : var 변수는 영역({}, 지역변수)과 상관없이 값이 접근이 가능합니다
if(true) {
  var a = 3
}
console.log('a : ', a)
// 다만 함수의 시작과 끝을 구분짓는 중괄호는 영향을 받아서 함수를 벗어나면 변수로 인식되지 못합니다

//반면 conset 변수(상수)는 블록영역에 영향을 받아 접근이 구분됩니다
if(true) {
  const b = 3
}
console.log('b : ', b) // 에러


// 값을 변경할 수 있는 변수를 사용하려면, 앞에서 사용한 var 변수나, 서버프로그래밍에서 주로 사용하는 let 변수를 사용합니다
// var let 변수의 차이는 다소 많지는 않으며, 다른점이 있지만 구분할 일이 많지는 않음

// 자바스크립트의 변수 생성은 선언, 할당, 사용 의 단게로 구분됩니다
// const 와 let 은 그 사용영역이 구분되어 사용해야하지만, var 은 그 부분의 비교적 자유롭습니다
// const 와 let 변수는 반드시 선언후 사용해야 하며, var 은 선언없이 사용될 수 있습니다
// 선언과 할당없이 사용된 모든 변수는 모두 var 변수입니다. 선언과 할당없이 사용된 var 변수의 최초값은 undefined 입니다

// const
// - 선언과 동시에 값이 초기화 되어야 함
// - 한번 선언되고 값이 초기화된 변수는 값을 변경할 수 없음
// - 하나의 스코프 안에서 중복 선언할 수 없음
// - 스코프를 벗어나면 선언된 변수는 소멸됨

// let
// - 반드시 선언해서 사용해야하지만, 초긱밧이 반드시 있어야 하는것은 아님
// - 변수값의 변경이 가능함
// - 하나의 스코프안에서 중복 선언할 수 없음
// - 스코프를 벗어나면 선언된 변수는 소멸됨

// var
// - 선언, 할당, 사용이 위치와 상관없이 자유롭습니다
// - 스코프에 상관없이 값의 접근이 가능합니다
// - 같은 스코프 안에서 중복선언도 가능합니다
// - 이때 마지막에 대힙된 값을 현재값으로 인식합니다
// - 이와 같은 특성으로 구조가 복잡한 함수내에서 현재값을 유추하는데 다소 불편함
// - 값의 변경이 자유로워 의도한 값의 저장 및 유지가 실패할 가능성이 있음
// - 함수의 영역을 벗어나는 스코프에만 영향을 받음


// 변수의 선언과 선언키워드 별 사용의 방향

// 1. 변수선언에는 기본적으로 const를 사용하고, 재할당이 필요한 경우에 한정해 let 을 사용하는 것을 권장함
// - 객체를 재할당하는 경우는 생각보다 흔하지 않으므로, 객체 변수 또한 const를 사용하는것을 권장하며, const를 사용하면
// 의도치 않은 재할당을 방지해 주기 때문에 데이터의 안전을 보장받을 수 있음
// 2. 재할당이 필요한 경우에 한정해 let 을 사용함. 이때, 변수의 스코프는 최대한 좁게 만드는것을 권장함. 재할당이 필요는
// 상수와 객체에만 const를 사용합니다





