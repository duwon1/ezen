const express = require('express');
const User = require('../models/User');
const bcrypt = require('bcrypt');
const router = express.Router();
const passport = require('passport');
const { isLoggedIn, isNotLoggedIn } = require('./middleware');

router.post('/join', async (req, res, next) => {
    const { nick, email, password } = req.body;
    try {
        // 회원가입 여부 확인
        const exUser = await User.findOne({
            where: { email }
        })

        if (exUser == null) {
            // password 를 암호화
            const hash = await bcrypt.hash(password, 9999);
            // 해쉬화를 하기위한 복잡도 인수 숫자가 클수록 해시화 암호화가 복잡해지고 복구시간도 오래걸림 12가 약 1초정도 시간의 실행을 해줌


            const loginUser = await User.create({ // 사용자를 추가
                nick,
                password: hash,
                email,
            });
            return res.redirect('/');
            module

        } else {
            return res.redirect('/join?joinError=이미 존재하는 이메일입니다')
        }


    } catch (err) {
        console.error(err);
        next(err);
    }

})

router.post('/login', async (req, res, next) => {
    // passport 모듈로 로그인을 구현함
    // 'local' : 일반 로그인을 하려고 보내지는 전달인수
    //() => { } : 그떄 보내서 실행할 전달인수로도서의 익명함수
    passport.authenticate('local', (authError, user, info) => {
        // 로그인이 성공하면 현재 로그인한 정보의 표현이담깁니다
        if (authError) {
            console.error(authError);
            return next(authError);
        }
        // 로그인하려는 이메일의 주인공이 사용자목록에 없을떄
        if (!user) {
            return res.redirect(`/?loginError=${info.message}`);
        }
        // 여기서부터 정상 로그인(세션에 사용자 정보를 넣고 첫페이지로 이동)
        return req.login(user, (loginError) => {
            if (loginError) {
                console.error(loginError);
                return next(loginError);
            }
            // 현재위치에서 세션 쿠키가 브라우저로 보내짐
            return res.redirect('/');
        })


    })(req, res, next)
    // 미들웨어 내의 미들웨어에는 뒤쪽게 (req, res, next) 를 붙여야함
})

router.get('/logout', (req, res) => {
    // req.logout() // 세션 삭제
    req.session.destroy()
    res.redirect('/')
})

router.get('/kakao', passport.authenticate('kakao'))

router.get('/kakao/callback/', passport.authenticate('kakao', {
    failureRedirect: '/'
}), (req, res) => { // 모든 로그인 절차를 마치고 다음 미들웨어 실행에서 첫페이지로 이동
    res.redirect('/')
})

module.exports = router