
const passport = require('passport');
const local = require('./localStrategy');
const User = require('../models/loginUser');
const kakao = require('./kakaoStrategy');

module.exports = () => { // 정상 로그인이 되었을떄
    passport.serializeUser((user, done) => {
        done(null, user.userid); // 세션에 로그인되는 사용자의 모든정보가 저장되는것이 아니라 아이디만 저장하는 동작
        //이동직후 세션에 아이디가 저장된다라는건 세션쿠키에도 암호화된 키로 쿠키가 저장된다는 뜻
        // 브라우저에서 connect.sid 값이 쿠키로 관리되고 이후로는 아래 passport.deserializeUser로 아이디가 사용 (세션값으로 복구 및 사용) 됩니다
    });

    passport.deserializeUser((userid, done) => {
        User.findOne({
            where: { userid },
        }).then((user) => done(null, user))
            .catch((err) => done(err))
            // 세션에 저장된 아이디와 키쿠로 user 를 복구 req.user 로 사용
            // req 내장함수 : req.isAuthenticated() 함수 : passport 가 req 에 추가해준 함수, 로그인 되어 있는동안 true 를 리턴
    });

    local()
    kakao()

}