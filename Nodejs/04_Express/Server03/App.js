
const express = require('express')
const path = require('path')
const app = express()

app.set('port', process.env.PORT || 3000)
// app.get() 또는 app.post() 등...
// req로 url 을 받아 해당 요청에 응답을 보내주는 메서드들을 "라우터"라고 부릅니다
// 라우토의 첫번째 전달요소로 "리퀘스트키워드"를 요청받아 익명함수를 실행해서 응답합니다
// 그 익명함수를 "미들웨어" 라고 부릅니다

// 미들웨어 실행만을 위한 멤버함수(라우터)가 존재합니다
// 1. 모든 라우터들이 실행되기 전 실행되는 라우터들이  보통 다른 라우터들의 위쪽에 기술되어져서, 모든 라우터들이
// 어떤 라우터가 실행되기전 반드시 실행되는 라우터
app.use((req, res, next) => {
  console.log('모든 요청에 실행하고 싶어요')
  next()
  // 모든라우터에 next 가 있지만 사용하지 않아서 생략된 상태 필요하면 꺼내서 사용할 수 있음
  // next() 가 없으면 현재 라우터에서 요청에 대한 응답이 종료됨, 미들웨어를 위한 라우터는 반드시 next() 를 사용해야 함
})

// 2. 특정 리퀘스트 에서만 실행할 미들웨어
app.use('/router', (req, res, next) => {
  console.log('router 요청에만 실행됨')
  next()
})
// get 과 post 등 모든 method 에서 리퀘스트 키워드만 같으면 실행됨
// 실행후 next() 로 인해 제어구너이 아래로 이동하여, 해당 get 이나 post 등이 추가 실행됨


// 3-1. 정상 라우터 또는 미들웨어 실행중 에러가 발생했을때
app.use((req, res, next) => {
  // throw new Error('에러를 강제로 발생 시킴')
  // 현재 코드는 에러의 상세내용이 웹브라우저에 나옴
  // 브라우저에 에러내용을 나오지 않게 하려면 1차적으로 try~catch 를 이용하고 에러처리 라우터를 만들어서 사용함

  // 에러처리의 또다른 형태
  /*
  try {
    console.log()
  } catch (err) {
    next(err) // 에러처리 미들웨어로 이동하는 next
    // next 에 error 가 인수로 들어가면 에러처리 라우터로 이동함
  }
  */
  next()
})

// 이 라우터는 라우터 및 미들웨어에서 에러가 발생하면 실행되는 미들웨어임
// 에러처리 라우터에 있는 미들웨어는 반드시 매개 변수가 err, req, res, next 네개가 있어야 에러처리로 인식됨 하나만 빠져도 인식이 안됨

// '/' 와 '/router' 라는 url 로 각각 index1.html, index2.html 을 응답파일로 전송하세요
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'index1.html'))
})

app.get('/router', (req, res) => {
  res.sendFile(path.join(__dirname, 'index2.html'))
})

app.listen(app.get('port'), () => {
  console.log(`서버열림 포트 : ${app.get('port')}`)
})

// 6. 라우터와 파라미터
// express 서버 역시 req.url 에 일부를 파라미터로 사용할수 있음
// http 서버에서는 이를 '/' 로 split 해서 사용하거나 parsing 해서 사용했다면, express 서버에서는 이를 바로 변수에 담아서 사용함
app.get('/category/Boots', (req, res) => {
  res.send(`<h2>Boots</h2>`)
})

app.get('/category/Heel', (req, res) => {
  res.send(`<h2>Heel</h2>`)
})
// 와이들 카드 키워드를 사용한 라우터는 범위가 넓으므로 가능한 아래쪽에 위치시켜, 명확한 구분은 먼저 실행되게 하고,
// 해당 라우터가 없을때 실행되게 하는것이 효과적임
app.get('/category/:name', (req, res) => {
  res.send(`<h2>Hello wild Card Char ${req.params.name}</h2>`)
})

// 3-2. 에러처리 라우터
app.use((err, req, res, next) => {
  console.error(err)
  res.status(200).send('에러내용을 가립니다')
})

// 5. 404 에러 처리
// 위의 모든 라우터를 검색하다가 해당 라우터가 없어서 이 미들웨어를 만나면 404 에러가 발생한 것이므로, 이 
// 미들웨어는 맨아래 또는 에러처리 라우터 바로 위에 위치 시킴
app.use((req, res, next) => {
  res.send('비정상적인 접근')
})

// 8. 미들웨어의 특성
// 하나의 미들웨어 에서 res.send() 또는 res.sendFile() 등을 두번이상 쓸수 없음 res.json() 도 마찬가지
// http 서버에서 사용하던 res.writeHeader() + res.end() 가 합쳐져서 res.send() 가 된것이므로 위 send 두번이상 쓰면 에러가 발생함
// res.writeHeader(200, {'Content-Type' : application/json})
// res.end(FJSON.stringfy({hello : 'hong'}))
// 위 둘이 합쳐져서 res.json({hello : 'hong'}) 로 사용됨
// 역시 다른 메서드들과 함께 두번이상 사용되지 않음

// Express 서버의 다른 서버와의 특징
// http 모듈의 웹서버의 확장판으로 코드의 가독성이 좋고 확장성이 좋음
// 프레임이 잡혀 있어 파일관리 및 운영이 용이함
// 비슷한 서버로서 koa, hapi 등이 있지만 Express 서버를 가장 많이 사용함
// 코드 관리 및 편의성에서 많은 장점을 제공함

// package.json
//Express 서버의 초기 설정 값들을 넣고 조절하는 파일
// 직접 작성하여 파일을 생성하여야 되고, npm init 를 실행하여 생성하여도 무방함

