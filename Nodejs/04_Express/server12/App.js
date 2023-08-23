const express = require('express')
const path = require('path')
const nunjucks = require('nunjucks')
const app = express()

app.set('port', process.env.PORT || 3000)
app.use(express.json())
app.use(express.urlencoded({ extended: false }))
app.set('view engine', 'html')
nunjucks.configure('views', {
  express: app,
  watch: true
})

app.use('/', express.static(path.join(__dirname, 'public')))

const { sequelize } = require('./models')
sequelize.sync({ force: false })
  .then(() => {
    console.log('데이터베이스 연결 성공')
  })
  .catch((err) => {
    console.error(err)
  })

// 라우터들을 수집(require) 합니다
const indexRouter = require('./routers')
const usersRouter = require('./routers/users')
const commentsRouter = require('./routers/comments')

app.use('/', indexRouter)
app.use('/users', usersRouter)
app.use('/comments', commentsRouter)

app.use((req, res, next) => {
  const error = new Error('Not Found')
  error.status = 404
  next(error)
})

app.use((error, req, res, next) => {
  res.locals.error = process.env.NODE_ENV === 'development' ? error : {}
  res.locals.message = error.message
  res.status(error.status || 500)
  res.render('error')
})

app.listen(app.get('port'), () => {
  console.log(`Express server listening on port ${app.get('port')}`)
})
