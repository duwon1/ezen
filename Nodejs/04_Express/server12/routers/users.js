
const express = require('express')
const User = require('../models/user')
const router = express.Router()

router.post('/insert', async (req, res, next) => {
  try {
    const inserteduser = await User.create({
      name: req.body.name,
      age: req.body.age,
      married: req.body.married,
    })
    res.json(inserteduser)
  } catch (error) {
    console.error(error)
    next(error)
  }
})

router.get('/', async (req, res, next) => {
  try {
    // 검색 조건없는 모든 레코드 조회
    const users = await User.findAll({})
    res.json(users)
  } catch (error) {
    console.error(error)
    next(error)
  }
})

module.exports = router

// 2. 일반조회(모든, 필드, 모든 레코드)
// 모델명.findAll({})
// User.findAll({})

// 3. 일부 필드만 조회(select name, married, from users)
// user.findAll({
//  attrib: ['name','married'],
// })

// 4. 일부필드 & 일부 레코드(where 조건) 조회
// - select name, married, from users where married = 1 nad age>30
// User.findAll({
//    attrib: ['name','married'],
//    where: {
//    married: 1,
//    age: {Op.gt: 30},
//    }
// })

// where 절에 두개의 조건이 별도의 언급없이 "," 로 이어졌다면 그 둘은 and 로 묶여있는 것입니다

// or 을 쓰려면
// select id, name form where married = 0 or age < 30
// User.findAll({
//    attrib: ['id','name'],
//    where: {
//      [op.or]: [{married: 1}, {age: {Op.lt: 30}}]
//    }
// })

// 크거나 같다 or 작거나 같다는 뒤에 e를 붙히면됨 lte, gte


// 5. Select id, name from users order by age desc
// User.findAll({ 
//    attrib: ['id','name'],
//    order: [['age', 'DESC']],
// })

// Select id, name from users order by age desc, id desc
// User.findAll({ 
//    attrib: ['id','name'],
//    order: [['age', 'DESC'], ['id', 'DESC']],
// })

