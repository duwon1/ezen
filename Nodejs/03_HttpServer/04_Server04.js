
const http = require('http')
const fs = require('fs').promises

http.createServer(
  async (req, res) => {
    // promise 기능의 함수를 동기식 코드와 같이 사용 await
    // 파일의 내용을 읽어와서 그 결과를 클라이언트에 보내야 하기 때문
    // 파일을 읽어오는 fs.readFile 명령의 결과와 그 다음명령 (res.write or res.end)의 순서가 읽어온후 보내져야 하기 떄문에
    // promise 기능의 함수의 await 로 사용
    // then 에 전달된 data 대신에 결과를 리턴받아 then 과 catch 대신에 try ~ catch 를 이용해서 사용
    try {
      const data = await fs.readFile('./04_index.html')
      res.writeHead(200, {'Content-Type' : 'text/html; charset=urf-8'})
      res.end(data)
    } catch (err) {
      console.error(err)
      res.writeHead(500, {'Content-Type' : 'text/html; charset=urf-8'})
      res.end(err.message)
    }
  }
).listen(3000, () => {
  console.log('서버열림port : 3000')
})

// http 상태코드
// 2xx : 서버전송 완료
// 3xx : 리다이렉션 상태
// 4xx : 요청오류
// 5xx : 요청은 왔지만 서버오류