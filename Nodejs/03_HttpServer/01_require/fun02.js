// 구조분해 할당으로 변수 초기화
const { odd, even } = require('./var')
// {odd, even} = {odd : odd, even : even}

// require 로 얻어온 값을 이용한 함수 제작
// 전달인수의 값이 짝수인지 홀수인지 판단하는 함수
function checkOddOrEven(number) {
  if (number % 2) {
    return odd
  } else {
    return even
  }
}
console.log(checkOddOrEven(123))
module.exports = checkOddOrEven
// 모듈을 이용한다면, 함수도 exports 해서 다른 파일에서 사용이 가능합니다

/* // 함수가 담겨있는 변수를 써도 되고 아래처럼 직접 함수를 exports에 연결해도 됩니다
module.exports = (number) => {
  if (number % 2) {
    return odd
  } else {
    return even
  }
}
*/
