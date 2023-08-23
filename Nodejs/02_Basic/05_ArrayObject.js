// 1. 생성자 함수로 배열의 요소 추가
function student(name, korean, math, english, science) {
	this.name = name
	this.kor = korean
	this.math = math
	this.english = english
	this.science = science
	this.getSum = function () {
		return this.kor + this.math + this.english + this.science
	}
	this.getAvg = function () {
		return this.getSum() / 4
	}
	this.toString = function () {
		return `이름 : ${this.name} 총점 : ${this.getSum()} 평균 : ${this.getAvg()}`
	}
}

let students = [] // 빈 배열 생성
let std1 = new student('홍길동', 84, 82, 75, 99) // student 객체를 생성
students.push(std1) // students 배열에 객체를 추가

students.push(new student('홍길서', 92, 71, 78, 84))
students.push(new student('홍길남', 91, 84, 74, 74))
students.push(new student('홍길북', 17, 27, 25, 94))

// for(var i in students) {
//   console.log(students[i].toString())
// }
students.map(function (k) {
	console.log(k.toString())
})

console.log('--------------------------------------------------------------')

// 객체와 문자열과 그리고 변수, 함수의 활용
let sayNode = () => {
	console.log('Node')
} // 변수에 함수를 저장해서 변수이름이 함수이름이 됨
let myName = 'NodeJS'

let obj = {
	// myName : 'NodeJS',
	// myName : myName,
	myName, // 멤버변수와 대입될값을 저장하고 있는 변수의 이름이 같다면, 한번만 써서도 작동함
	sayJS: () => {
		console.log('JS')
	},
	// sayNode: () => {
	// 	console.log('Node')
	// },
	sayNode,

}
console.log(obj.myName)
obj.sayNode()
obj.sayJS()

console.log('--------------------------------------------------------------')

let es = 'ES'
obj[es + '6'] = 'Fantasic'

const newObj = {
	myName,
	sayJS: () => {
		console.log('JS')
	},
	sayNode,
	[es + 6]: 'Fantastic',
}
console.log(newObj.myName)
newObj.sayNode()
newObj.sayJS()
console.log(newObj.ES6)

console.log('--------------------------------------------------------------')

// 객체의 구조 분해 : 객체 내부의 멤버변수 또는 멤버메서드를 별도의 변수에 따로 저장하여 별도로 사용하기 위한 문법
const sayJ = newObj.sayJS
sayJ()
const sayN = newObj.sayNode
sayN()
var es6 = newObj.ES6
console.log(newObj.ES6)
console.log(es6)
const myN = newObj.myName
console.log(myN)

console.log('--------------------------------------------------------------')

// OneStep 구조분해
const newObject1 = {
	myName1: 'NODE.JS',
	[es + 2]: 'Fantastic',
	sayJS: () => {
		console.log('JS')
	},
	sayNo: () => {
		console.log('NODE')
	},
}
const { myNmae1, ES2, sayJS, sayNo } = newObject1
// 구조분해되어 저장될 변수들이 있는 객체에서, 변수들의 이름은 객체내부에 있는 멤버변수들의 이름과 같은 이름을 사용하기
console.log(myName)
console.log(ES2)
sayNo()
sayJS()

console.log('--------------------------------------------------------------')

const candyMachine = {
	status: {
		name: 'node',
		count: 5,
	},
	getCandy() {
		this.status.count--
		return this.status.count
	},
}
// 객체의 구조분해를 하지 말아야 하는 경우 - this 를 사용하는 객체는 구조분해를 하지 않는것이 좋음
var getCandy = candyMachine.getCandy
// getCandy() // 이건 에러
// 객체 내의 메서드가 구조 분해 되는순간 안에 있던 this를 사용할 수 없게 되므로 그 안의 count 또한 없는 변수가 되어 에러가 발생

var { getCandy, status: { count } } = candyMachine
// 분해하지 않으려고 하는 멤버는 중괄호안에 쓰지 않아서 분해하지 않을수도 있음

console.log('--------------------------------------------------------------')

// 이는 아래와 같이 배열에 여러 자료를 넣어 놓고 인덱스를 이용하여 따로 따로 추출하는 것과 한번에 추출하는 모양과 같은 형식으로 사용함
// 하나의 변수에 하나씩 추출
let array1 = ['nodejs', {}, 10, true]
let node1 = array1[0]
let obj3 = array1[1]
let bool1 = array1[3]
console.log(node1, obj3, bool1)
// 한번에 추출
const array2 = ['nodejs2', {}, 20, false]
const [node2, obj2, bool2] = array2
console.log(node2, obj2, bool2)



