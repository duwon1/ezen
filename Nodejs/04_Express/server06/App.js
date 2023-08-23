const express = require('express')
const path = require('path')
const morgan = require('morgan')
const cookieParser = require('cookie-parser')
const app = express()
const session = require('express-session')

app.set('port', process.env.PORT || 3000)
app.use(morgan('dev'))
app.use(cookieParser())
app.use(express.json())
app.use(express.urlencoded({ extended: true }))
app.use(session({
  resave: false,
  saveUninitialized: false,
  secret: "abcd123" // 세션의 암호화 코드
}))

app.get('/', (req, res) => {
  if (req.cookies.session) {
    res.send(`${req.session[req.cookies.session]} 님 반갑습니다 <a href="/logout">로그아웃</a>`)
  } else {
    res.sendFile(path.join(__dirname, '/index.html'))
  }

})

app.post('/login', (req, res) => {
  const id = req.body.id
  const pw = req.body.pw
  // 세션의 저장
  // req.session.id = "hello"
  // req.session.data = "afdafd"
  // 다른 미들 웨어에서 req.session.data 라는 이름으로 사용 가눙
  if (id == 'scott' && pw == 'tiger') {
    const uniqueInt = Date.now()
    req.session[uniqueInt] = id
    res.cookie('session', uniqueInt, {
      // Expire 를 생략하면 브라우저가 닫힐때 쿠키도 사라짐
      httpOnly: true,
      path: '/'
    })
    // req.session.userid = id
    return res.json({ msg: 'ok' })
  } else if (id != 'scott') {
    return res.json({ msg: '아이디가 없음' })
  } else if (pw != 'tiger') {
    return res.json({ msg: '비밀번호틀림' })
  } else {
    return res.json({ msg: '에러' })
  }
})

app.get('/logout', (req, res) => {
  req.session.destroy(
    () => {
      req.session
    }
  )
  res.clearCookie('session', req.cookies.session, {
    httpOnly: true,
    path: '/'
  })
  res.redirect('/')
})


app.listen(app.get('port'), () => {
  console.log(app.get('port'), '3000 포트에서 서버 대기 중')
});