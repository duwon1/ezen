
const url = require('url');

const { URL } = url;
const myURL = new URL('http://www.daum.net/book/bookList.aspx?sercate1=001001000#anchor')
console.log(`new URL() : ${myURL}`)
console.log(`new format() : ${url.format(myURL)}`)

console.log('--------------------------------------------------------------')

const parsedURL = url.parse('http://www.daum.net/book/bookList.aspx?sercate1=001001000#anchor')
console.log(`url.parse() : ${parsedURL}`)
console.log(`url.format() : ${url.format(parsedURL)}`)
//인터넷 주소를 parse 함수로 분해해서 각각의 요소들을 따로 분리하고 사용할 수 있습니다
console.log(parsedURL.query)

console.log('--------------------------------------------------------------')
