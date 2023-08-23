// 함수의 표현방법
let add2 = (x, y) => {
	return x + y
}
const add3 = (x, y) => {
	return x + y
}
console.log(`add3 = (x, y) => {} ${add3(10, 20)}`)

// 함수 의 표현방법 
const add4 = (x, y) => x + y
// 리턴 명령 하나만 있는 함수라면 위와 같이 중괄호 없이 리턴될 값만 화살표뒤에 씁니다
console.log(`add4 = (x, y) => x+y ${add4(20, 30)}`)

console.log('--------------------------------------------------------------')

let arr = [1, 2, 3, 4, 5]
arr.map((val, idx) => {
	console.log(val, idx)
})

console.log('--------------------------------------------------------------')

// 매개변수 없고 리턴값이 없는 함수
const func1 = () => {
	console.log(`매개변수 없고 리턴값 없는 함수`)
}
// 매개변수 있고 리턴값이 없는 함수
const func2 = (x, y) => {
	console.log(`매개변수(${x}, ${y})있고 리턴값 없는 함수`)
}
// 매개변수 있고 리턴값이 있는 함수
const func3 = (x, y) => {
	console.log(`매개변수(${x}, ${y})있고 리턴값 있는 함수`)
	return x + y
}
// 매개변수 없고 리턴값이 있는 함수
const func4 = () => {
	console.log(`매개변수 없고 리턴값 있는 함수`)
	return 100
}