const express = require('express');
const { Post, User, Hashtag } = require('../models');
const router = express.Router();
const { isLoggedIn, isNotLoggedIn } = require('./middleware');

router.get('/', async (req, res, next) => {
    try {
        const postList = await Post.findAll({
            include: {
                model: User,
                attributes: ['id', 'nick']
            },
            order: [['createdAt', 'DESC']]
        })



        res.render('main', {
            title: 'NodeGram',
            user: req.user,
            posts: postList,
            followerCount: req.user ? req.user.Followers.length : 0,
            followingCount: req.user ? req.user.Followings.length : 0,
            followerIdList: req.user ? req.user.Followings.map(f => f.id) : [],
        });
    } catch (err) {
        console.error(err);
        next(err);
    }
});

router.get('/join', isNotLoggedIn, (req, res, next) => {
    res.render('join', {
        title: '회원가입 - NodeGram',
    })
})

router.get('/hashtag', async (req, res, next) => {
    const query = req.query.hashtag
    // console.log(query)
    if (!query) {
        return res.redirect('/')
    }

    try {
        // 1. 전달된 해시태그로 hashtags 테이블 검색해서 해당 해시태그의 id를 얻음
        const hashtag = await Hashtag.findOne({
            where: {
                title: query,
            }
        })
        // 2. 그 id로 PostHashtag 테이블에서 hashtagid 필드를 검색
        // 3. 검색결과에서 PostId 만 추출
        // 4. 추출한 PostId 로 posts 테이블에서 검색
        let posts = [] // 검색결과가 담길 배열
        if (hashtag) { // 1번에서 검색한 결과가 있다면
            posts = await hashtag.getPosts({
                include: [{
                    model: User
                }]
            }) // 검색결과의 hashtag 객체를 갖고, posts 테이블에서 검색하라는 명령
        }

        return res.render('main', {
            title: `${query} | NodeGram`,
            user: req.user,
            posts: postList,
            followerCount: req.user ? req.user.Followers.length : 0,
            followingCount: req.user ? req.user.Followings.length : 0,
            followerIdList: req.user ? req.user.Followings.map(f => f.id) : [],
        })

    } catch (err) {
        console.error(err);
        next(err);
    }
})

router.get('/profile', isLoggedIn, (req, res, next) => {
    res.render('profile', {
        title: '내정보 - NodeGram',
        user: req.user,
        followerCount: req.user ? req.user.Followers.length : 0,
        followingCount: req.user ? req.user.Followings.length : 0,
        followerIdList: req.user ? req.user.Followings.map(f => f.id) : []
    })
})

module.exports = router