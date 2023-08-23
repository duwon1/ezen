// 1. 자바스크립트의 객체 생성
// { } 중괄호안에 key(요소의 이름) 와 value(요소의 값)ㅇ; ':' (콜론) 으로 구분되어서 존재하는 값들의 집합
var product = {
  name: "냉장고",
  제조사: '대한민국',
}

// 변수하나 안에 한개이상의 키와 값이 조합되어 데이터를 넣어 사용합니다
// 객체안에 있는 키와 값의 조합하나를 속성이라고 하며, 각 속성은 콤마로 구분합니다

console.log(product.제조사)
console.log(product.name)

// 자바스크립트의 객체는 별도의 클래스 선언 없이, { }중괄호 안에 직접 속성들을 넣는 순간 객체(Object)로 인식되어 사용됩니다
// 값들의 자료형은 제한이 없으며, 객체안에 객체, 객체안의 배열등 모든 형태의 자료가 속성으로 들어갈 수 있음

var object = {
  useNumber: 273,
  userString: '문자열',
  useBoolean: true,
  useObject: {
    a: '1',
    b: '2'
  },
  useArray: [1, 2, 3, 4, 5],
}
console.log(object)

var obj2 = {} // 객체형 변수를 만들되 아직 넣어둘 속성이 없다면 빈 객체 생성이 가능함


// 2. 객체의 속성과 메서드
// - 속성 : 객체 내부에 있는 하나하나의 값
// - 메서드 : 객체 내부에 있는 멤버변수를 컨트롤하거나 객체관련된 작업을 하기위한 함수
var object = {
  useNumber: 273,
  userString: '문자열',
  useBoolean: true,
  useObject: {
    a: '1',
    b: '2'
  },
  useArray: [1, 2, 3, 4, 5],
  method: function () {
    console.log('멤버 함수를 실행함')
  },
}
object.method()

// 멤버 함수에 매개변수가 존재할 수 있음
var person = {
  name: '홍길동',
  eat: function (food) {
    console.log('음식 : ', food)
  }
}
console.log(person.name)
person.eat('스파게티')

// 멤버함수가 멤버변수로의 접근
// - this 키워드 : 자바스크립트는 멤버변수에 접근을 위해서 반드시 this 키워드를 써야함
var person = {
  name: '홍길동',
  eat: function (food) {
    console.log(`'${this.name}'이/가 '${food}'을/를 먹었습니다.`)
  }
}
person.eat('김밥')

// 3. 객체와 반복문
var product = {
  name: 'Node.js & Express',
  price: 'Free',
  language: '한국어',
  supportOS: 'win32/64',
  subecripton: true,
}

// key : 대상 객체의 속성이름들을 담을 String 변수
for (var key in product) {
  // console.log(key, " : ", product[key])
  console.log(`${key} : ${product[key]}`)
}

// 4. 객체와 관련된 키워드
var student = {
  이름: '홍길동',
  국어: 92,
  수학: 98,
  영어: 96,
  과학: 98,
}
var output = '';
output += "'이름' in student : " + ('이름' in student) + '\n'
output += "'성별' in student : " + ('성별' in student) + '\n'
console.log(output)

// - with 키워드 : 복잡하게 사용해야 하는 코드를 짧게 줄여주는 키워드

var write = ''
with (student) {
  write += `이름 : ${이름} \n`
  write += '국어 : ' + 국어 + '\n'
  write += '수학 : ' + 수학 + '\n'
  write += '영어 : ' + 영어 + '\n'
  write += '괴학 : ' + 과학 + '\n'
}
console.log(write)

// 5. 객체의 속성 추가와 제거
// - 동적 속성 추가/제거 : 처음 객체 생성하는 시점 이후에 객체의 속성을 추가하거나 제거할 수 있습니다

// 빈 객체를 생성
var student = {}

// 자바스크립트 객체의 장점 : 객체 생성이후 동적으로 석성(멤버변수)를 추가 할 수 있습니다

with (student) {
  이름 = '홍길동'
  취미 = '악기'
  특기 = '프로그래밍'
  장래희망 = '훌륭한 백엔드 개발자'
}


for (var key in student) {
  console.log(`${key} : ${student[key]}`)
}

// 같은 방식으로 멤버함수도 추가가 가능합니다
student.method = function () {
  console.log('동적 함수추가')
}
student.method()


// 선언된 객체 내부의 변수값 또는 함수를 변경할 수 있습니다
student.이름 = '홍길서'

student.method = function () {
  console.log('수정된 함수실행')
}
console.log(`이름 : ${student.이름}`)
student.method()


console.log('--------------------------------------------------------------')
// 객체 속성의 제거
delete (student.장래희망)
delete (student.method)
student.toString = function () {
  for (var key in this) {
    if (key != 'toString') {
      console.log(`${key} : ${student[key]}`)
    }
  }
}
student.toString()

console.log('--------------------------------------------------------------')

student = {
  이름 : '홍길남',
  취미 : '스포츠',
  특기 : '게임',
  toString : function () {
    for (var key in this) {
      if (key != 'toString') {
        console.log(`${key} : ${student[key]}`)
      }
    }
  },
}
student.toString()

// 6. 생성자 함수 : new 키워드를 사용해 객체를 생성할 수 있는 함수
// - 생성자 함수를 사용한 객체의 생성과 출력. 그냥 함수를 사용해 객체를 리턴하는 방법과 차이가 없음

// 함수하나를 생성하되 함수안에 this를 이용한 변수에 값을 넣으면 그 이름의 멤버 변수가 만들어지고,
// 취종 그 변수들을 멤버로하는 객체가 만들어지는 생성자 함수로 인식이 됨
function Student(name, korean, math, english, science) {
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
// 객체가 만들어지기 위한 생성자 함수
var std1 = new Student('홍길동', 88, 78, 98, 87)
var std2 = new Student('홍길서', 78, 88, 88, 25)
var std3 = new Student('홍길남', 58, 58, 56, 37)
console.log(std1.toString())
console.log(std2.toString())
console.log(std3.toString())

console.log('--------------------------------------------------------------')
// std1.music = 100
Student.music = 100 // Student 생성자 함수에 속성 추가
console.log(`music : ${std1.music}`)

// 7. 프로토타입
// - 생성자 함수를 사용해 생성된 객체가 공통으로 가지는 공간.
// - 자바스크립트의 모든 생성자 함수는 내부의 this 변수들의 prototype을 갖습니다.
// 그리고 prototype은 객체입니다.
function Student(name, korea, math, english, science){
  this.name = name;
  this.kor = korea;
  this.math = math;
  this.english = english;
  this.science = science;
}
// 생성자에서 만들어진 원본객체이며, 생성자호출로 객체를 만들때, 그 원본을 복사해서 객체를 생성함.
// 생성자 함수가 만들어지고 그안에 this를 이용한 멤버변수가 정의되면, 그 함수로 만들어질 객체를 위한 "프로토타입"
// 이라고 하는 복사용 원본객체가 생성됩니다
// 프로토타입은 생성될 객체로 복사될 원본이며, 객체형태로 존재합니다
console.log('--------------------------------------------------------------')
var std1 = new Student('홍길서', 64, 93, 46, 85)
// 위 명령이 실행되는 순간 프로토타입의 사본이 std1에 저장되면서 새로운객체를 이룹니다
Student.prototype.music = 100
var std2 = new Student('홍길남', 76, 56, 42, 46)
console.log(`music : ${std1.music}`)
console.log(`music : ${std2.music}`)

var std1 = new Student('홍길서', 87, 98, 87, 45);
// 위 명령이 실행되는 순간 프로토타입의 사본이 std1에 저장되면서 새로운 객체를 이룹니다.

std1.music = 100; // sdt1 객체에만 별도로 멤버변수가 추가되는 경우
console.log(`music : ${std1.music}`);

// 만약 생성자 함수에 추가로 멤버변수 또는 멤버메서드를 추가하려고 한다면,
Student.prototype.music = 100;
var std2 = new Student('홍길동', 87, 98, 87, 45);
console.log(`music : ${std2.music}`);
// 새로 추가된 멤버변수 music 변수의 값을 전달인수로 전달해서 초기화할 수는 없습니다.
// 이 후에 새로 만들어지는 모든 객체의 music 변수 값은 모두 100입니다.

// 멤버함수를 생성자에 추가하려면
Student.prototype.getSum = function(){
  return this.kor + this.math + this.english + this.science + this.music;
};
Student.prototype.getAvg = function(){
  return this.getSum() / 5;
};
Student.prototype.toString = function(){
  return `${this.name} | ${this.getSum()} | ${this.getAvg()}`;
};

var std4 = new Student('홍길북', 87, 98, 87, 45);
console.log();
console.log(std4.toString());

// 객체를 생성 후에 멤버메서드와 멤버변수를 추가하느냐,
// 생성자 만들어서 프로토타입에 메서드와 멤버변수를 추가 후 객체를 만드느냐
// 선택적으로 사용할 수 있습니다.


console.log('\n\n');
// 9. Object 객체
// - toString() 메서드.
// - 객체를 문자열로 변환할 때 자동으로 호출.
var obj = new Object();
console.log(obj);   // {}
console.log(obj.toString());    // [object object]

// new Object()로 만들어진 객체에 내가 필요한 변수와 메서드를 추가하면, Object가 갖고 있던 요소들과 함께 사용이 가능합니다.
// - toString() 메서드 재정의(override)
obj.name = '김하나';
obj.grade = '고등학교 1학년';
console.log( "toString 재정의 전 : " , obj.toString() );
obj.toString = function(){  return this.name + ' : ' + this.grade;  };
console.log( obj.toString() );

console.log(obj);