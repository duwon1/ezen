const express = require('express');
const path = require('path');
const morgan = require('morgan');
const cookieParser = require('cookie-parser');
const app = express();

app.use(morgan('dev'));
app.use(cookieParser());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.set('port', process.env.PORT || 3000);

app.get('/', (req, res) => {
  if (req.cookies.id) {
    res.send(`${req.cookies.id} 님 반갑습니다 <a href="/logout">로그아웃</a>`)
  } else {
    res.sendFile(path.join(__dirname, '/index.html'))
  }
})

app.post('/login', (req, res) => {
  const id = req.body.id
  const pw = req.body.pw

  if (id == 'scott' && pw == 'tiger') {
    const expires = new Date()
    expires.setMinutes(expires.getMinutes() + 1)
    res.cookie('id', id, {
      expires,
      httpOnly: true,
      path: '/'
    })
    return res.json({ msg: 'ok' })
  } else if (id != 'scott') {
    return res.json({ msg: '아이디가 없음' })
  } else if (pw != 'tiger') {
    return res.json({ msg: '비밀번호가 틀림' })
  } else {
    return res.json({ msg: '에러' })
  }
})

app.get('/logout', (req, res) => {
  res.clearCookie('id')
  res.redirect('/')
})

app.listen(app.get('port'), () => { console.log(app.get('port'), ' 포트에서 서버 대기 중'); });