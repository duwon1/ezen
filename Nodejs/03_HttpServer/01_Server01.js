// Node.js에 포함된 기능과 문법을 이용하여 웹호스팅을 할 수 잇는 서버를 구축함

// Node 에서 제공하는 라이브러리 중 서버 구축에 필요한 기능과 함수를 담고 있는 http 모듈을 require 합니다
const http = require('http')
const { serialize } = require('v8')
// require : 외부에서 공유한 모듈을 불러와서 사용할수 있게 하는 node.js 의 문법이며, 잘 알고 있는 import 의 의미가 담겨있는 명령임
// http 모듈을 내용을 불러와서 http 라는 변수에 저장하여 사용합니다
// 객체형식으로 불러와서 저장한형태이므로 http.함수이름(), http.변수이름 처럼 사용함

// ttp.createServer()
// create Server 함수 : Node.js 자바스크립트로 만든 http 서버가 실행되게 하는 함수입니다

// (req, res) => { } : 서버에 클라이언트가 요청이 있을때 실행할 명령들이 들어감
// http.createServer((req, res) => { })

http.createServer((req, res) => {
  // req는 요청을 받고 res는 응답을 함
  res.write('<h1>Hellow Node Server!</h2>')
  res.write('<h1>Wellcome to My Node Server</h2>')
}).listen(3000, () => {
  console.log('3000port 에서 서버가 열렸음')
})

/*
const ser = http.createServer()
ser.listen(3000, () => {
  console.log('3000port 에서 서버가 열렸음')
})
*/
// 3000은 포트번호, 익명함수는 서버 오픈과 동시에 실행할 명령들이 들어감



