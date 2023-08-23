const express = require('express')
const app = express()
const path = require('path')
const nunjucks = require('nunjucks') // 템플릿 엔진을 위한


app.set('port', process.env.PORT || 3000)
app.use(express.json())
app.use(express.urlencoded({ Pextended: false }))

app.set('view engine', 'html')
nunjucks.configure('views', { // views : 템플릿 엔진이 렌더링 하기 위한 파일들이 모여있는 폴더명
  express: app,
  watch: true
}) // 넌적스 엔진을 사용하기 위한 설정

app.get('/', (req, res) => {
  // 넌적스에 의한 이동은 res.render 을 사용 함
  res.render('index', {
    title: 'Express'
  })
  // html 파일을 클라이언트에 보낼때 크파일에 전달해줄 테이터를 위와 같이 객체형식으로 하나이상 같이 보낼 수 있음
})

app.get('/extends', (req, res) => {
  res.render('extends', {
    title: 'Express'
  })
})

app.get('/include', (req, res) => {
  res.render('main', {
    title: 'Express'
  })
})

app.listen(app.get('port'), () => {
  console.log(app.get('port'), '포트 대기')
})