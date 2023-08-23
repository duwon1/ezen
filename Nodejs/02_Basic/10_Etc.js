// try ~ catch

var sports = '축구'
// const 변수 선언후 값을 변경할 수 없음 (상수형 변수)

try {
  sports = '영어'
} catch (error) {
  console.log('에러')
}
console.log(sports)

const obj = { language: '한글' }
obj.language = '영어'
console.log(obj.language)
// obj 변수는 language 라는 멤버변수를 갖는 객체로 선언되어서, 그 형태가 고정되는 형태
// obj 변수는 객체의 주소를 저장하는 참조변수
// obj = {}
// 위와 같이 obj 변수가 갖는 참조값을 변경하는 행위는 에러, 그외의 동작은 에러가 발생하지 않음

console.log('--------------------------------------------------------------')

// switch case
var cnt = 1
switch (cnt) {
  case 1:
    console.log('1')
    break // break 명령이 없으면 아래 case도 실행됨

  case 2:
    console.log('2')
    break

  default:
    break
}

console.log('--------------------------------------------------------------')

// 변수의 선언과 사용
// 변수는 사용하기 전에 반드시 선언(생성)이 되어 있어야함

// 에러는 안나지만 undefined
let language
console.log(language)

// 변수 선언이 출력보다 뒤에있지만 var 변수는 에러가 발생하지 않음
// 초기화 되지 않은 변수의 출력은 undefined
console.log(music)
var music

console.log('--------------------------------------------------------------')

// 반복실행문 for
let arr1 = ['가', '나', '다', '라']
arr1.map((val, idx) => {
  console.log(`${idx} : ${val}`)
})

console.log('--------------------------------------------------------------')

for (var i in arr1) { // in에 의해서 배열의 index를 차례로 i변수에 저장
  console.log(`${i} : ${arr1[i]}`)
}

console.log('--------------------------------------------------------------')

for (var value of arr1) { // of에 의해서 배열의 값요소를 차례로 value변수에 저장
  console.log(`${value}`)
}

console.log('--------------------------------------------------------------')

for (var value of "ABC") { // A B C 가 각각 value에 전달됨
  console.log(`${value}`)
}

// forof.js 와 forof.html 참조

console.log('--------------------------------------------------------------')

// 객체들의 배열을 for-of 에 적용할 경우
let values = [
  { item: '선물1', amount: { apple: 10, candy: 20 } },
  { item: '선물2', amount: { apple: 30, candy: 40 } },
]
// 배열의 요소들이 각각하나의 값으로 구성된 경우는 of 앞에 변수가 하나만 존재하면 되지만
// 객체가 배여의 요소들이라면 아래와 같이 그형태에 맞춰서 변수를 구성해줘야 적용이 가능함

// item, amount, apple, candy : 각 객체의 값들이 해당 변수에 저장될 수 있도록 구분하는 필드명
// 각 객체내의 값들을 저장할 변수
for (var { item: one, amount: { apple: two, candy: five } } of values) {
  console.log(one, two, five)
}

// for(객체를 저장할 수 있는 변수 of 객체들을 요소로하는 배열) { }

console.log('--------------------------------------------------------------')

let act = {
  soccer: '축구',
  baseball: '야구',
}

for (var k in act) {
  console.log(`${k} `)
}
let keyList = Object.keys(act)

for (var key of keyList) {
  console.log(`${key} : ${act[key]}`)
}

console.log('--------------------------------------------------------------')

// 배열의 복사
arr1 = [1, 2, 3, 4]
let arr2 = [...arr1]
console.log(arr1)
console.log(arr2)

arr2 = [...arr1, 5] // 배열 복사및 추가
console.log(arr2)

arr2.push(6)
console.log(arr2)

console.log('--------------------------------------------------------------')

// arguments : 함수의 전달인수의 모두를 받아줄수 있는 숨어있는 매개변수(배열)
// 매개변수 유무와 상관없이 전달되는 모든 전달인수를 배열로 저장함
function func1(a, b, c) {
  console.log(`${a}, ${b}, ${c}`)
  for (var val of arguments) {
    console.log(`${val} `)
  }
}
func1(1, 2, 3, 4, 5)

console.log('--------------------------------------------------------------')
/* 화살표 함수는 arguments 사용이 기존함수처럼 사용이 어려움
let func2 = () => {
  for(var val of arguments) {
    console.log(`${val}`)
  }
}
func2()
*/
// 화살표 함수에는 argument 대신 사용할수 있는 rest 라는 매개변수가 있음
let func2 = (a, b, ...rest) => {
  console.log(`${a}, ${b}`)
  for (var i = 0; i < rest.length; i++) {
    console.log(rest[i] + ' ')
  }
}
// arguments와 달리 rest는 앞에 있는 매개변수가 이미 전달된 전달인수를 제외한 나머지를 저장하는 배열
func2(1, 2, 3, 4, 5)

console.log('--------------------------------------------------------------')
{
  // 구조분해 상세
  let one, two, three, four, five;
  values = [1, 2, 3];
  // 배열요소의 갯수만큼 변수를 구성하여 배열의 값들을 각각의 변수에 담을수 있습니다ㅅ
  [one, two, three] = values;
  console.log("A : ", one, two, three);

  // 변수의 갯수를 조절해서 분해할당 하고싶지 않은 값을 조절할수 있습니다
  [one, two] = values;
  console.log("B : ", one, two);

  // 배열의 요소 갯수보다 할당받을 변수의 갯수가 많다면 남는 변수값은 undefined가 됩니다
  [one, two, three, four] = values;
  console.log("C : ", one, two, three, four, five);

  // 2차원 또는 3차원의 복잡한 배열은 분해할당할 형태를 맞춰서 분해합니다
  [one, two, [three, four]] = [1, 2, [73, 74]];
  console.log("D : ", one, two, three, four);

  // 분해할당에서 제외하고자 하는 요소가 중간에 있다면 자리를 비워두고 분해합니다
  [one, , , , four] = [1, 2, 3, 4];
  console.log("E : ", one, four)

  // 분해에서 제외할 하나가 맨앞에 있다면 아래와 같은 형태로 분해합니다
  // [one, ...other] = [1, 2, 3, 4];
  // console.log("F : ", other)
}

console.log('--------------------------------------------------------------')

// 객체의 구조분해
{
  // 필드명을 이용하여 객체의 구조 분해를 할수 있으며, 이름이 맞지 않는 필드는 분해에서 제외시킬 수 있습니다 또한
  // 필드로 존재하지 않는ㄴ 변수는 undefined로 저장됩니다
  let { one, two } = { one: 1, nine: 9 }
  console.log(one, two)
  // 위와 변수 선언과 동시에 구조 분해하는것이 보통이며, 만약 이미 정의되어 있는 변수로
  // 구조분해 한다면 아래와 같이 괄호로 묶어서 실행합니다
  let three, four
  ({ three, four } = { three: 3, four: 4 })
  console.log(three, four)
}

console.log('--------------------------------------------------------------')

// 구조분해를 이용한 함수의 매개변수
// 함수의 전달인수가 배열이거나 객체라면 그형태데로 구조분해되어 저장될 변수들을 매개변수로 위치함
function total({ one, plus: { two, five } }) {
  console.log(one, two, five)
  console.log(one * (two + five))
}
total({ one: 5, plus: { two: 2, five: 5 } })

console.log('--------------------------------------------------------------')

// 구조분해에서 사용하는 기본값 default value
{
  // 배열 구조분해 기본값
  let [one, two, five = 5] = [1, 2]
  console.log(one, two, five)

  // 객체 구조분해 기본값
  let { six, seven = 7 } = { six: 6 }
  console.log(six, seven)

  // 함수의 매개변수 기본값
  let plus = (one, two = 2) => one + two

  console.log(plus(1)) // two 에 전송값이 없음
  console.log(plus(1, undefined)) // two 에 전송값이 없는것과 마찬가지
  console.log(plus(1, 70)) // two 에 전송값 70이 전송 기본값은 삭제

  // 객체 또는 배열이 매개변수일떄 의 기본값
  let getTotal = ([one, two] = [10, 20]) => one + two
  console.log(getTotal()) // 아무 전달인수 없어도 one 10, two 20 으로 적용

  let getValue = ({ two: value } = { two: 20 }) => value
  console.log(getValue()) // 아무 전달인수 없어도 two 20 으로 적용
}

console.log('--------------------------------------------------------------')

// 디스트럭처링 : 객체의 필드명을 문자열의 연산으로 조합하여 생성
let item = {
  ['one' + 'two']: 12,
}
console.log(item.onetwo)
item = 'tennis'
sports = {
  [item]: 1,
  [item + 'Game']: '윔블던',
  [item + 'Method']() {
    return this[item]
  }
}
console.log(`${sports.tennis} ${sports.tennisGame} ${sports.tennisMethod()}`)













