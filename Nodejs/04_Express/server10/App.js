const express = require('express')
const cookieParser = require('cookie-parser')
const session = require('express-session')
const path = require('path')
const app = express()
const dotenv = require('dotenv') // 추가 1
app.set('port', process.env.PORT || 3000)
app.use(express.json())
app.use(express.urlencoded({ extended: false }))

dotenv.config() // 비밀키 비공개를 위한 기본 환경 구성 // 추가 2
app.use(cookieParser(process.env.SESSION_SECRET)) // 추가 3

app.use(session({
  resave: false,
  saveUninitialized: false,
  // secret: 'ss' // 저장될떄 사용하는 암호화키
  secret: process.env.SESSION_SECRET
}))

app.get('/', (req, res) => {
  if (req.session.userid) {
    res.send(`${req.session.userid} 님 반갑습니다 <a href="/logout">로그아웃</a>`)
  } else {
    res.sendFile(path.join(__dirname, '/login.html'))
  }
})

app.post('/login', (req, res) => {
  const id = req.body.id
  const pw = req.body.pw

  if (id == 'scott' && pw == 'tiger') {
    req.session.userid = id
    return res.send('ok')
  } else if (id != 'scott') {
    return res.send('없는아이디')
  } else if (pw != 'tiger') {
    return res.send('틀린 비밀번호')
  } else {
    return res.send('에러')
  }
})

app.get('/logout', (req, res) => {
  req.session.destroy(() => {
    req.session
  })
  res.redirect('/')
})

app.listen(app.get('port'), () => {
  console.log(app.get('port'), '포트 대기중')
})

// req.app : req 객체를 통해 app 객체에 접근할 수 있습니다. req.app.get('port') 와 같은 식으로 사용할 수 있습니다
// req.body : body-parser 미들웨어가 만드는 요청의 본문을 해석한 객체입니다
// req.cookies : cookie-parser 미들웨어가 만드는 요청의 쿠키를 해석한 객체입니다
// req.ip : 요청의 ip 주소가 담겨 있습니다
// req.params : 라우트 매개변수에 대한 정보가 담긴 객체입니다
// req.signedCookies : 서명된 쿠키들은 req.cookies 대신 여기에 담겨 있습니다
// req.get(헤더이름) : 헤더의 값을 가져오고 싶을 때 사용하는 매서드입니다

// res.app : req.app 처럼 res 객체를 통해 app 객체에 접근할 수 있습니다
// res.cookie(키, 값, 옵션) : 쿠키를 설정하는 메서드입니다
// res.clearCookie(키, 값, 옵션) : 쿠키를 제거하는 메서드입니다
// res.end() : 데이터의 없이 응답을 보냅니다
// re.json({}) : json 형식의 응답을 보냅니다
// res.redirect(주소) : 리다이렉트할 주소와 함께 응답을 보냅니다
// res.render(뷰, 데이터) : 다음 단원에서 다룰 템플릿 엔진을 렌더링해서 응답할때 사용하는 메서드입니다
// res.send(데이터) : 데이터와 함께 응답을 보냅니다. 데이터는 문자열일 수도 있고 html 일 수도 있으며, 버퍼일수 있고 객체 및 배열일수 있습니다
// res.sendFile(경로) : 경로에 위치한 파일을 응답합니다
// res.setHeader(헤더 ,값) : 응답의 헤더를 설정합니다
// res.status(코드) : 응답 시의 http 상태 코드를 지정합니다
// send sendFile render json end 등 요청에대한 데이터 전송은 한번에 한개, 
// 그리고 한번만 실행해야 하며, 하나의 라우터에서 두번 또는 두개가 실행되면 에러가 발생합니다

// 쿠키 옵션들
// maxAge : 쿠키의 수명을 밀리초 단위로 설정
// expires : 만료 날짜를 GMT 시간으로 설정
// path : 해당 디렉토리와 하위 디렉토리에서만 경로가 활성화되고, 웹 브라우저는 해당하는 쿠키만 웹 서버에 전송합니다
// domain : 도메인 네임
// secure : 웹브라우저와 웹서버가 https로 통신하는 경우만 웹브라우저가 쿠키를 서버로 전송합니다
// httpOnly : 웹 서버를 통해서만 쿠키에 접근할 수 있습니다 자바스크립트의 document.cookie를 이용해서 쿠키에 접속하는것을 막습니다
// signed : 쿠키의 암호화를 결정합니다

// 세션의 옵션들
// secret : 보안을 위한 임의의 문자열 (secret key)
// resave : 세션 데이터가 바뀌기 전까지 세션저장소의 값을 저장할지 여부 기본값 : false
// saveUnintialized : 세션이 필요하기 전에 세션을 구동할지 여부 기본값 : true
// store : 세션저장소를 지정

