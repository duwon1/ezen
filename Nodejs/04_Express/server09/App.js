const express = require('express')
const app = express()
app.set('port', process.env.PORT || 3000)

// 클라이언트의 요청에 대한 응답을 별도의 파일에 넣어둔 라우터를 이용하여 응답할 예정
// 라우터를 종류별로 파일에 분산 운영
const indexRouter = require('./routers/index')
// 경로에 ,.routers 만 써도 index.js가 자동으로 인식됨
const userRouter = require('./routers/users')

// 앞으로 요청되는 모든 '/' 요청은 indexRouter 와 연결되어 응답
app.use('/', indexRouter)

// '/' 로 시작하는 요청중 '/users' 로 시작하는것은  users.js 에 분리되어 운영 
app.use('/users', userRouter)

app.listen(app.get('port'), () => {
  console.log(app.get('port'), '포트 대기중')
})