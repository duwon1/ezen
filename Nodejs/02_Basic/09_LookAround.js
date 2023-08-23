// 정방 탐색
// 정규표현식으로 구분해 내고 매칭한 결과내용 중, 정규표현식에 사용되었던 글자를 제외한 나머지를 결과로 얻고자 할때,
// 예를 들어 https://www.naver.com 에서 '글자들이 반복되고 : 으로 끝남' 이라는 정규식이 있다면 결과는 https:
// 가 되겠지만 결과가 ':'를 제외한 'https' 만을 목적할때 사용하는 방식
var a = 'http://www.naver.com';
// '.' : \n 이 아닌 모든 글자
var result = a.match(/.+:/g)
console.log(result)

a = 'https://www.naver.com';
result = a.match(/.+:/g)
console.log(result)

console.log('--------------------------------------------------------------')

// 정방탐색을 사용한 예
// 정규식 : (?=정규식 또는 글자)
// 조건에 매칭이 된 후, 해당(?=뒤로 이어진) 정규식에 있는 글자는 소모하지 않는다(취하지 않는다)
a = 'http://www.naver.com';
result = a.match(/.+(?=:)/g)
console.log(result)

a = 'https://www.naver.com';
result = a.match(/.+(?=:)/g)
console.log(result)

console.log('--------------------------------------------------------------')

// 전방위 탐색
// 앞에서 정방탐색이라는 이름으로 매칭하고자 할때, 버릴 문자와 취할 문자들을 앞, 또는
// 뒤에서 검색하는것을 말합니다. 전방위 탐색은 검색하고 버릴 문자를 앞쪽에서 검색합니다
// ?<=정규식

// 후방위 탐색
// 검색후 버릴 문자를 뒤에서 검색합니다

a = '<html><head><title>안녕하세요 반갑습니다</title></head>' + 
'<body><div>웹사이트에서 내용을 발췌합니다</div></body></html>'

// <div></div>가 포함되어져서 추출
console.log(a)
result = a.match(/<div>.+<\/div>/g)
console.log(result)
// .+ : 글자 반복
// <\/div> : </div>의 '/' 가 정규표현식의 종료로 잘못인식되지 않게 '<\/div>'라고 씁니다

// <div></div>를 제외하고 추출
result = a.match(/(?<=<div>).+(?=<\/div>)/g)
console.log(result)

// 연습문제
// 위의 a변수중 타이틀내용을 발췌해서 출력하세요
result = a.match(/(?<=<title>).+(?=<\/title>)/g)
console.log(result)

// 연습문제
a = '일반텍스트 파일 : bac.txt, 자동실행파일 : autoexec.bat, 데이터분석파일 : bigdata.ai, 더미파일 : gfreag, 알수없는 파일 : orea.bat'
// a변수에서 파일이름.확장자명 으로 구성된 파일명만 골라서 출력하세요 더미파일 제외 전부 추출
result = a.match(/\b\w+[.]\w*\b/g)
console.log(result)

// a변수에서 확장자가 b로시작하는 파일을 찾아서 출력
result = a.match(/\b\w+[.]b\w*\b/g)
console.log(result)

a = '박길동 : park@naver.com , 김하나 : kim@daum.net , 이두울 : ee@myhome.co.kr , 웹사이트 : http://abcdefg.co.kr'
// 이메일 주소만 출력하되 .net 과.com만 출력하세요
result = a.match(/[가-힣]+\s:\s\w+@\w+\.(com|net)/g)
console.log(result)

a = '현재 접속중인 외부 아이피는 110.8.6.181   이며, 내부아이피는 192.168.0.544 입니다'
// 아이피 주소만 매칭하여 출력하세요
result = a.match(/([0-9]{1,3}\.){3}(\d{1,3})/g)
console.log(result)

console.log('--------------------------------------------------------------')

// REPLACE
// replace 함수를 이용하여 패턴으로 매칭된 텍스트를 지정한 텍스트로 최환할 수 있습니다
a = 'blue socks and red socks'
result = a.replace(/blue|white|red/g, 'color')
console.log(result)

a = 'park 010-1234-1234 , kim 010-8888-7777 m lee 010-1435-3111'
// 정규표현식과 replace 를 이용하여 전화번호 뒷자리를 모드 마스킹으로 치환하기
b = a.replace(/[-]\d{4}\s/g, '-****, ')
console.log(b)

 a = '네이버 - http://www.naver.com , 다음 - http://www.daum.net , 네이트 http://www.nate.com'
 result = a.replace(/\w+(?=:)/g, 'https')
 console.log(result)

console.log('--------------------------------------------------------------')


