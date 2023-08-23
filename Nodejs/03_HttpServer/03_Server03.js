
const http = require('http')
// 한번에 여러개의 서버를 실행
// 방법은 createServer 를 여러번 호출하는 방식으로 진행
// 단, 두서버의 포트를 다르게 지정해야 함, 포트가 충돌하면 에러발생

http.createServer((req, res) => {
  res.write('<h1>Hello Node Server #1</h1>') // 응답 내용의 본문 전송
  res.end('<h1>Hello Server </h1>') // 응답 내용의 마지막 전송 : res.end 실행 후에는 더이상 응답내용이 전송될 수 없음
}).listen(3001, () => {
  console.log('3001 포트가 열림')
})
// 매개변수이고, 서버에 있는 실제 request, response 객체가 전달 됨
// 매개 변수는 그 객체를 전달받아 사용하는 것으로 변수의 이름은 자유롭게 변경이 가능 다만 함수 내에서 변경된 이름을 일관되게 사용하는게 좋음
http.createServer((req, res) => {
  res.write('<h1>Hello Node Server #2</h1>')
  res.end('<h1>Hello Server </h1>')
}).listen(3002, () => {
  console.log('3002 포트가 열림')
})