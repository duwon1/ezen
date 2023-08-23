const express = require('express')
const router = express.Router()

router.get('/', (req, res) => {
  res.send('<h1>Hello - users</h1>')
})

router.get('/search', (req, res) => {
  res.send('<h1>Hello - /users/search</h1>')
})

module.exports = router