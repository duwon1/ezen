// 객체를 생성하는 또다른 방법
let one = 1, two = 2
// 객체이름 values 필드명 one, two 필드값들은 1, 2
let values = { one, two }
console.log(values)

let obj = {
  kor: 80,
  getKor(param) {
    return this.kor
  },
  setKor(k) {
    this.kor = k
  }
}
console.log(obj.getKor())
obj.setKor(90)
console.log(obj.getKor())

console.log('--------------------------------------------------------------')

// Number 객체
// 표한 가능한 양의 정수 max 값
console.log('1 : ', Number.MAX_SAFE_INTEGER)
console.log('2 : ', Math.pow(2, 53) - 1) // Math.pwd(a, b) : a의 b자승

console.log('3 : ', Number.MIN_SAFE_INTEGER)
console.log('4 : ', Math.pow(2, 53) - 1)

// 이하 true
console.log('1 : ', Number.isInteger(0))
console.log('2 : ', Number.isInteger(1.0))
console.log('3 : ', Number.isInteger(-123))

//이하 false
console.log('4 : ', Number.isInteger('12'))
console.log('5 : ', Number.isInteger(1.02))
console.log('6 : ', Number.isInteger(NaN))
console.log('7 : ', Number.isInteger(true))

// Number String 의 관계
console.log("가".codePointAt(0))

values = "ABC"
for(var value of values) {
  console.log(value, value.codePointAt(0))
}
// # $ % &
console.log("1", String.fromCodePoint(35, 36, 37, 38))

// 16진수로 지정, 49, 50, 51로 지정한 것과 같음
console.log("2 : ", String.fromCodePoint(0x31, 0x32, 0x33))

// 가각
console.log("3 : ", String.fromCodePoint(44032, 44033))

console.log('--------------------------------------------------------------')

// startsWith : 대상 문자들이 지정한 글자로 시작하면 true 그렇지 않으면 false
let target = '123가나다'
console.log("1 : ", target.startsWith(123))
console.log("2 : ", target.startsWith('23'))
console.log("3 : ", target.startsWith('가나', 3)) // 인덱스3부터 "가나"로 시작

console.log('--------------------------------------------------------------')

target = "123가나다"

console.log(target.endsWith("가나다"))
console.log(target.endsWith("가나"))
console.log(target.endsWith("가나", 5))

console.log('--------------------------------------------------------------')

target = "123가나다라456"
console.log(target.includes(2))
console.log(target.includes("가나"))
console.log(target.includes("12", 4))









