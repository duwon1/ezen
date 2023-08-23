
// export된 파일을 불러올때 .js는 생략이 가능
const value = require('./var')
// var에는 export 된 객체가 있고, 그 안에는 odd 멤버변수와 even멤버변수가 있습니다 그리고 그 객체를 value 변수에 저장합니다
console.log(value)

const odd = value.odd
const even = value.even
console.log(odd)
console.log(even)
