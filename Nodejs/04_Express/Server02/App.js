
const express = require('express')
const path = require('path')
const app = express()
app.set('port', process.env.PORT || 3000)

app.get('/', (req, res) => {
  // http 서버에서 사용했던 파일을 읽어오고 읽어온 내용을 보내고 하는 방식을 사용 하지 않음
  // 파일을 선택해서 파일만 전송합니다, 다만 경로가 아니라 절대 경로를 사용합니다
  // 03_HttpServer / 04_FileRead 폴더 참고
  // 파일을 직접 보내는 메서드 res.sendFile()
  res.sendFile(path.join(__dirname, '/index.html'))
})
app.get('/users', (req, res) => {
  res.end('<h1>Users Page</h1>')
})
app.listen(app.get('port'), () => {
  console.log(`서버열림 포트 : ${app.get('port')}`)
})