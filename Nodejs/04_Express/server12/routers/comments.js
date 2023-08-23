
const express = require('express');
const User = require('../models/user');
const Comment = require('../models/comment');
const router = express.Router();

router.get('/', async (req, res, next) => {
  try {
    const comments = await Comment.findAll({
      include: {
        model: User,
      }
    })
    //console.log(comments);
    res.json(comments);
  } catch (error) {
    console.error(error)
    next(error)
  }
})

router.post('/insert', async (req, res, next) => {
  try {
    const comment = await Comment.create({
      commenter: req.body.id,
      comment: req.body.comment
    })
    res.send('ok');
  } catch (error) {
    console.error(error);
    next(error);
  }
});

router.patch('/update/:id', async (req, res, next) => {
  try {
    const result = await Comment.update({
      comment: req.body.comment
    }, {
      where: {
        id: req.params.id
      }
    })
    res.send('ok');
  } catch (error) {
    console.error(error);
    next(error);
  }
})

router.delete('/delete/:id', async (req, res, next) => {
  try {
    const result = await Comment.destroy({
      where: {
        id: req.params.id
      }
    })
    res.send('ok');
  } catch (error) {
    console.error(error);
    next(error);
  }
})

router.get('/search/:id', async (req, res, next) => {
  try {
    const comments = await Comment.findAll({
      include: {
        model: User,
        where: {
          id: req.params.id
        }
      }
    })
    res.send(comments);

  } catch (e) {
    console.error(e);
    next(e);
  }
});

module.exports = router;




