
const express = require('express');
const router = express.Router();
const { isLoggedIn, isNotLoggedIn } = require('./middleware');
const { Post, User, Hashtag } = require('../models');

router.post('/follow/:id', isLoggedIn, async (req, res, next) => {
    // 1. 로그인 유저의 id 조회
    // 2. follow 테이블에 로그인유저와 작성자유저로 레코드 추가
    // 로그인유저의 객체로 작성자 유저를 한번에 follow 테이블 레코드추가하는 명령을 사용

    // 로그인 유저 조회 - loginuser 변수에 객체 저장
    try {
        const loginuser = await User.findOne({
            where: {
                id: req.user.id
            }
        })
        await loginuser.addFollowings(parseInt(req.params.id, 10))
        // Model 에 정의해놓은 as : 'Followingns'에 따라서 메서드가 만들어짐
        // 복수, 단수 모두가능 setFollowing 수정 메서드
        // getFollowings 수정 메서드 removeFollowings 읽기 조회 
        // removeFollowigs 삭제
        // 복수면 [ ] 사용

        res.end()

    } catch (err) {
        console.error(err)
        next(err)
    }
})