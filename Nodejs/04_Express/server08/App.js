const express = require('express')
const path = require('path')
const fs = require('fs')
const multer = require('multer')
const app = express()

app.set('port', process.env.PORT || 3000)
app.use(express.json())
app.use(express.urlencoded({ extended: false }))

app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, '/fileupload.html'))
})

// static 폴더 설정
app.use('/', express.static(path.join(__dirname, 'uploads')))

try {
  fs.readdirSync('uploads')
} catch (e) {
  console.error(e)
  fs.mkdirSync('uploads')
}

const upload = multer({
  storage: multer.diskStorage({
    destination(req, file, done) {
      done(null, 'uploads/')
    },
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
  return res.json({
    title: req.body.title,
    filename: req.file.filename,
    description: req.body.description,
    price: req.body.price
  })

})

app.listen(app.get('port'), () => {
  console.log(app.get('port'), '포트에서 대기중')
})