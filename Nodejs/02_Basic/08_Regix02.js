// 메타캐릭터(메타문자) : ^, $, | 등의 글자로 패턴을 표현한 글자들
// | : or 의 의미로 사용 a|b 는 a 또는 b 라는 의미
var a = "Hello World"
var result = a.match(/Hello|Crow/g)
console.log(result)

 a = "Welcome Crow"
 result = a.match(/Hello|Crow/g)
console.log(result)

a = "Hello World Welcome Crow"
result = a.match(/Hello|Crow/g)
console.log(result)

console.log('--------------------------------------------------------------')

// ^ : ^abc 는 abc로 시작하는 의미의 정규식 ([ ] 안에서 사용할 떄는 다른 의미)
a = "Life is too short"
result = a.match(/^Life/g)
console.log(result)

console.log('--------------------------------------------------------------')

// $ : abc$는 abc로 끝나는 의미의 정규식
a = "Life is too short"
result = a.match(/short$/g)
console.log(result)

console.log('--------------------------------------------------------------')

// \b : word Boundary 의미로 whitespace 로 식별되는 메타 문자입니다
// 원래 문자열 안에 사용하는 \b 는 백스페이스의 역할을 하는 이스케이프 문자이지만
// 정규표현식에서는 공백을 의미하도록 사용함
a = "no class are all classa"
result = a.match(/\bclass\b/g)
console.log(result)

a = "the declassified algrithm"
result = a.match(/\bclass/g)
console.log(result)

a = "one subclass is'"
result = a.match(/\bclass\b/g)
console.log(result)

console.log('--------------------------------------------------------------')

// \B : whitespace 로 구분되지 않은. 그 외 다른 글자로 구분되는 정규식
a = "no class are all classa"
result = a.match(/\Bclass\B/g)
console.log(result)

a = "the declassified algrithm"
result = a.match(/\Bclass\B/g)
console.log(result)

a = "one subclass is'"
result = a.match(/\Bclass\B/g)
console.log(result)
