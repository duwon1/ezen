
const http = require('http')
const { url } = require('inspector')
const { json } = require('stream/consumers')
const fs = require('fs').promises

let users = {}

http.createServer(async (req, res) => {
  try {
    if (req.method == 'GET') { // 조회기능에 많이 사용
      if (req.url === '/') {
        const data = await fs.readFile('./05_Front.html')
        res.writeHead(200, { 'Content-Type': 'text/html; charset=urf-8' })
        return res.end(data.toString())
      } else if (req.url === '/about') {
        const data = await fs.readFile('./05_about.html')
        res.writeHead(200, { 'Content-Type': 'text/html' })
        return res.end(data)
      } else if (req.url === '/users') {
        // users 객체에 있는 값들을 클라이언트로 안전하게 전송
        res.writeHead(200, { 'Content-Type': 'application/json; charset=utf-8' })
        // users 객체 안의 내용을 json 형식으로  변경하여 전송
        return res.end(JSON.stringify(users))
      }

    } else if (req.method == 'POST') { // 중요정보 입력
      let body = ''
      if (req.url === '/user') {
        req.on('data', (data) => {
          body += data // 비어있는 글자를 이어붙이기 해서 toString() 없이 문잘 변환
          const { name } = JSON.parse(body) // 전달된 데이터의 값을 꺼내서 name 변수에 저장
          const id = Date.now() // id 변수에 날짜를 추출(현재시간을 밀리초로)
          users[id] = name // 키값은 id, 밸류값은 name 으로 객체에 저장
          console.log(users)
        })
        return res.end('ok')
      }

    } else if (req.method == 'PUT') { // insert, update
      if (req.url.startsWith('/user/')) {
        let body = ''
        let urlarr = req.url.split('/')
        const key = urlarr[2];
        req.on('data', (data) => {
          body += data
          users[key] = JSON.parse(body).name

        })
        res.writeHead(200, { 'Content-Type': 'text/plain; charset=utf-8' })
        return res.end('ok')
      }

    } else if (req.method == "DELETE") { // delete
      if (req.url.startsWith('/user/')) {
        let urlarr = req.url.split('/')
        const key = urlarr[2]
          delete (users[key])
          res.writeHead(200, { 'Content-Type': 'application/json; charset=utf-8' })
          return res.end('ok')
      }
    }

  } catch (err) {
    console.error(err)
    res.writeHead(500, { 'Content-Type': 'text/html; charset=urf-8' })
    res.end(err.message)
  }
  res.writeHead(404)
  return res.end('NOT FOUND')
}).listen(3000, () => {
  console.log('3000포트에서 서버 열림')
})