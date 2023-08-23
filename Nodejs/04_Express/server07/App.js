const express = require('express')
const path = require('path')
const fs = require('fs')
const multer = require('multer')
const app = express()

app.set('port', process.env.PORT || 3000)
app.use(express.json())
app.use(express.urlencoded({ extended: false }))

app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, '/multer.html'))
})

// static 폴더 설정
app.use('/', express.static(path.join(__dirname, 'uploads')))

// 파일을 업로드 하려면 업로드될 폴더가 지정되어야 함
// fs모듈에 있는 기능을 이용해서 폴더를 검색하고 없으면 생성함
// 서버내의 저장장치나 외부 기기와의 통신은 언제든 에러요소가 존재하므로 try-catch 를 사용

try {
  fs.readdirSync('uploads')
} catch (e) {
  console.error(e)
  fs.mkdirSync('uploads')
}

// multrer 객체를 생성하고, 폴더와 파일이름을 설정
// const upload = multer({ storage: multer.diskStorage({}), limits: {} })
const upload = multer({
  storage: multer.diskStorage({
    // 경로설정에 관한 함수
    // done : 전달인수로 익명함수를 전달받아 done() 호출하는 매개변수
    destination(req, file, done) {
      done(null, 'uploads/')
      // multer 모듈에서 done 매개변수에 만들어진 익명함수를 전달함
      // 그 전달한 익명함수를 done 을 이용해 호출하면 함수가 실행됨
    },
    // 저장될 파일이름에 관한 함수
    filename(req, file, done) {
      const ext = path.extname(file.originalname) // 확장자 추출
      const fn = path.basename(file.originalname, ext) + Date.now() + ext // 확장자를 제외한 파일이름 + 현재시간 + 확장자
      done(null, fn)
    }
  }),
  limits: {
    fileSize: 5 * 1024 * 1024
  }
})

app.post('/upload', upload.single('image'), (req, res) => {
  // upload.single('image) 로 파일을 업로드 합니다
  return res.json({
    title: req.body.title,
    filename: req.file.filename
  })

})

app.listen(app.get('port'), () => {
  console.log(app.get('port'), '포트에서 대기중')
})