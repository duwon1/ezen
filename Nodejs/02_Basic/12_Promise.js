// 함수와 비슷한 기능을 가지고 있는 객체
// 객체내의 익명함수의 내용을 실행하고, 결과를 보관하고 있다가, 결과가 필요할때 전달받아 사용할수 있게 해주는 구조의 객체
// 비동기식 실행

// const pm = new Promise(/* 익명함수 */)
// promise 객체의 전달인수 없는 선언문
// promise 객체는 생성자의 전달인수로 현재 promise 객체의 기능을 갖는 익명함수를 전달하여야 생성됨

// func = (resolvem, reject) => { }
// const pm = new Promise(func)
const pm1 = new Promise((resolvem, reject) => { })
// 위 명령이 실행되어 객체가 만들어지는 순간 pm1에는 익명함수의 실행결과가 저장됩니다
// 필요할때 pm1 객체에서 그 결과를 꺼내서 사용할수 있습니다

// 익명함수의 내용
let condition = true
const pm = new Promise(
  (resolve, reject) => {
    if (condition) {
      resolve('성공')
    } else {
      reject('실패')
    }
  }
)
// 익명함수에서 실행된 결과의 값이나 상태에 따라 resolve() 함수 또는 reject() 함수를 실행합니다
// 이떄 필요한 문자를 resolve 와 reject 에 전달인수로 전달하여 결가가 필요한 곳에서 그 데이터를 꺼내 쓸수 있게 합니다
// 위의 예는 '성공' 또는 '실패' 가 전달
// 함수 안에서 반드시 resolve() 또는 rejext() 가 호출 됩니다
// if 문이나 선택 실행에 적용하여 둘중 하나만 실행하여도 되고, 무조건 resolve()나 reject() 하나만 실행하기도 합니다

// pm1 에 resolve()의 결과 또는 reject() 결과가 저장되어 있음
// resolve()의 결과는 then에서 꺼내어 쓸수 있고, reject()결과는 catch() 에서 꺼내어 쓸수 있습니다 다만 어떤게 저장되어
// 있을지 모르니 보통은 아래와 같이 모두 기술해서 선택실행되게 합니다

// 모든 경우에 다 실행될 명령은 .finally()에 기술해줍니다
// then과 catch, finally 에는 실행할 명령을 익명함수에 넣어서 기술합니다

// resolve 와 reject 가 호출될 당시 전달인수로 전달한 전달인수('성공', '실패')는 아래 각 케이스별로 
pm1
  .then((message) => {
    console.log(message)
  })
  .catch((message) => {
    console.log(message)
  })
  .finally(() => {
    console.log("promise 가 종료됩니다")
  })
  console.log("promise 가 끝났습니다")















