// 문자열들의 이어붙이기 연산 '+'
// 출력되어야할 필요 String 자료와 특정 변수에 들어있는 값이 하나의 출력으로 이어져야한다면
var num1 = 1
var num2 = 2
var result = 3
var string1 = num1 + ' 더하기 ' + num2 + ' 는 \'' + result + '\''
// var string1 = num1 + '더하기' + num2 + ' 는 \'' + result + '\''
console.log(string1)

// Template String 을 사용하는 연산
// jsp 페이지에서 EL 문법을 사용한것과 비슷하게, 문자열과 변수값을 하나의 문장안에서 같이 표한하는 문법
// 전체 문자열은 `(그레이브-악센트)로 묶고 그 안에 ' 와 큰따옴표를 자유롭게 사용하며, ${변수이름}를 이용하여 변수의 값을 문자열 안에 삽입합니다

let string2 = `${num1} 더하기 ${num2} 는 '${result}'`
console.log(string2)

// 기존의 EL 문법처럼 중괄호안에서는 각 변수들간의 연산도 가능합니다
const num5 = 2000
const num6 = 3
const text = `${num5} 원짜리 모자를 ${num6}개 구입하여, ${num5*num6}원을 지출함`
console.log(text)