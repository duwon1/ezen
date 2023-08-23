const express = require('express');
const passport = require('passport');
const router = express.Router();

router.get('/', (req, res) => {
    res.render('loginForm')
});



router.post('/login', (req, res, next) => {
    passport.authenticate('local', (error, user, info) => {
        // 로그인이 성공하면 현재 로그인한 정보의 표현이담깁니다
        if (error) {
            console.error(error);
            return next(error);
        }
        // 로그인하려는 사람이 사용자목록에 없을떄
        if (!user) {
            console.log(`메시지입니다 : 에러메시지${info.message}`)
            return res.redirect(`/?loginError=${info.message}`);
        }
        // 여기서부터 정상 로그인(세션에 사용자 정보를 넣고 첫페이지로 이동)
        return req.login(user, (loginError) => {
            if (loginError) {
                console.error(loginError);
                return next(loginError);
            }
            // 현재위치에서 세션 쿠키가 브라우저로 보내짐
            return res.redirect('/main');
        })
    })(req, res, next)

})

router.get('/kakao', passport.authenticate('kakao'))

router.get('/kakao/callback', passport.authenticate('kakao', { failureRedirect: '/' }), (req, res) => {
    // 모든 로그인 절차를 마치고 다음 미들웨어 실행에서 첫페이지로 이동
    res.redirect('/main')
})

router.get('/main', (req, res, next) => {
    try {
        console.log(`현재로그인 중인 유저 ${req.user.nick_name}`)
        if(!req.user) {
            return res.redirect('/')
        }
        res.render('main', { loginUser: req.user })
    } catch (err) {
        console.error(err);
    }
})

router.get('/logout', (req, res) => {
    // req.logout() // 세션 삭제
    req.session.destroy()
    res.redirect('/')
})


module.exports = router