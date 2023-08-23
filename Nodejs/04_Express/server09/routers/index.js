const express = require('express')
const router = express.Router() // App.js 와 연결되기 위해 라우터 기능 사용
router.get('/', (req, res) => {
  res.send('<h1>Hello - index</h1>')
})

router.get('/about', (req, res) => {
  res.send('<h1>Hello - about</h1>')
})

module.exports = router
