// 정규표현식

// 정규표현식은 문자표현공식, 문자탐색공식 이라고 부르는 연산식과 같은 분류언어임
// 전문가가 사용한 정규표현식은 초보자에게 외계언어와 같은 어려운 식들이지만
// 문자탐색과 스캔에 있어 강력한 기능을 가지고 있어, 여러분야에 많이 사용되고 있습니다
// 자바스크립트에서도 많은 다양한 정규표현식의 적용을 지원하고 있음

var a = 'While some may view this debt forgiveness as a slap in the face to people who where responsible and paid off there student loans'

// 문자변수 또는 문자데이터.match(/찾고자하는 문자/)
// 대장 문들에서 찾고자 하는 문자와 그 첫번째 위치를 얻을 수 있음
var result = a.match(/a/)
console.log(result)

result = a.match(/th/)
console.log(result[0])
console.log(result[1])
console.log(result[2])
// /th/g : 'th'를 모두 찾아 그룹으로 얻을 수 있습니다
result = a.match(/th/g)
console.log(result)

console.log('--------------------------------------------------------------')

var a = 'acabcabbcabbbbcabcba'
result = a.match(/ab*/g) // a변수안에 String 내용중 a로 시작하고 b가 몇개든 반복되는 글자를 검색 매칭해주세요
// * : 0번 이상 반복출현하는 매칭
console.log(result)

console.log('--------------------------------------------------------------')

// 정규표현식에 사용되는 탐색 기호들
// - [ ]
// [ ] : 배열에 썻던 대괄호로 표현합니다
// [ ] : 괄호안에 검색하고자 하는 글자들을 넣고, 그 포함 유무를 판단합니다
// [abc] 는 a 또는 b 또는 c를 의미함
a = 'a'
result = a.match(/[abc]/g)
console.log(result)

a = 'before'
result = a.match(/[abc]/g)
console.log(result)

a = 'dune'
result = a.match(/[abc]/g)
console.log(result) // 매칭결과가 없으면 결과는 null 임

a = 'beforeabc'
result = a.match(/abc/g) // 'abc' 단어를 검색
console.log(result)


// 위 둘의 매칭은 섞어서 사용이 가능
a = 'grezageagefvrzcezabczazbzc'
result = a.match(/z[abc]/g)
console.log(result) // z로 시작하면서 [a 또는 b 또는 c] 를 가지고 있는 단어를 검색

/*
[0-9] : 숫자와 매치, 0부터 9까지의 아라비아 기호 매칭 [0123456789] 라고 써야하지만 줄여서 사용
[a-z] : 문자 소문자와 매치 소문자 a부터 z 까지의 글자 매칭 = [abcdefghijklmnopqrstuvwxyz]
[A-Z] : 문자 대문자와 매치 대문자 A부터 Z 까지의 글자 매칭
[a-zA-Z] : 아라비아 기호를 제외한 대소문자를 매칭
[a-zA-z0-9] : 아라비아기호, 소문자, 대문자 모두 매칭
*/

// 소문자 검색
a = 'ABCEFGHjsjJFSIOIOSfjs'
result = a.match(/[a-z]/g)
console.log(result)

// 숫자 검색
a = 'adsahd18dwjdjsapodJDSIO94klJFKLS28'
result = a.match(/[0-9]/g)
console.log(result)

/*
'^' : [ ] 대괄호 안에서는 뒤에 적힌 글자를 제외한 것을 매칭하는 뜻, 대괄호 밖에서는 다른의미로 사용됨

[0-9], [a-z], [A-Z] 등과 같은 방식으로 매칭이 가능한 표현식
[\d] : 숫자와 매칭 [0-9]와 동일함
[\D] : 숫자가 아닌것과 매칭 [^0-9]와 동일함 
[\s] : whitespace 와 매치(공백) [\t\n\r\f\v]와 같은 표현
[\S] : whitespace 가 아닌것과 매치 [^\t\n\r\f\v]와 같은 표현
[\w] : 문자와 숫자들과 매치 [0-9a-zA-Z]와 같은 표현
[\W] : 문자와 숫자가 아닌것과 매치 [^0-9a-zA-Z]와 같은 표현
*/


// 숫자 검색
a = 'adsahd18dwjdjsapodJDSIO94klJFKLS28'
result = a.match(/[\d]/g)
console.log(result)

// 공백 검색
a = 'abc de f'
result = a.match(/[\s]/g)
console.log(result)

// 글자[문자와 숫자] 검색
a = '%*#(*1$)@)$@)(s(@*'
result = a.match(/[\w]/g)
console.log(result)

/*
Dot(.) : 줄바꿈 글자인 '\n'을 제외한 모든 글자와 매칭됨
a.b : a와 b사이에 어떤글자가 들어와도 매칭됨
a+ '모든문자' + b
*/

a = 'a.baㅁb'
result = a.match(/a.b/g)
console.log(result)

// a.b 와 a[.]b 의 차이점
// [.]은 괄호안에 '\n'을 제외한 모든문자를 표시하는게 아니라 괄호안의 '.'을 나타냄 a.b는 되지만 aab는 안됨

a = 'a.b aec'
result = a.match(/a[.]b/g)
console.log(result) // a와b 사이에 '.'가들어간것만 찾아줌

/*
 - 반복 * 와 +
 - '*' 는 앞에 있는 글자의 반복 횟수를 0회차부터 카운트 하여 반복된 문자열 탐색
 - '+' 는 앞에 있는 글자의 반복 횟수를 1회차부터 카운트 하여 반복된 문자열 탐색
*/
a = 'caaatcdaat'
result = a.match(/ca*t/g)
console.log(result)

a = 'caaatcaat'
result = a.match(/ca+t/g)
console.log(result)
a = 'ct'
result = a.match(/ca*t/g)
console.log(result)
a = 'ct'
result = a.match(/ca+t/g)
console.log(result)

/*
- 반복 {m, n}
{m} : 앞에 위치한 글자의 m회 반복 매칭
a{3} : a의 3회 반복
- 정규 표현식 : 'ca{2}t'

{m, n} : 앞에 위치한 글자의 m회 부터 n회 반복 매칭
a{2, 5} : a 의 2~5회 반복
- 정규표현식 : 'ac{2, 5}t'

? : 앞에 위치한 글자의 0회 또는 1회 반복 매칭
a? : a의 0~1회 반복
- 정규표현식 : 'ca?t'
*/

a = 'caat'
result = a.match(/ca{2}t/g) // a가 2번반복 매칭
console.log(result)

a = 'caaat'
result = a.match(/ca{2}t/g) // a가 3개라 null
console.log(result)

a = 'caaat'
result = a.match(/ca{2,3}t/g) // a가 2~3번 반복되는것을 찾음
console.log(result)

a = 'ct cat caat'
result = a.match(/ca?t/g) // a가 0개거나 1개인것을 찾음
console.log(result)

console.log('--------------------------------------------------------------')

// 연습
// 아래 문자중 전화번호만 추출하세요
a = "park chan ho 010-1234-1234 kim min kyu 010-0101-1241 lee dae ho 011-102-4822"
result = a.match(/01[0-9]-[0-9]{3,4}-[0-9]{4}/g)

a = "park chan ho opdisap@naver.com kim min kyu dksiaod@daum.co.kr lee dae ho woiqiodj@gmail.com"
result = a.match(/[a-zA-Z]\w+@\w+\.\w+\.*\w*/g)
console.log(result)