
const passport = require('passport')
const LocalStrategy = require('passport-local').Strategy;
const bcrypt = require('bcrypt');
const User = require('../models/loginUser');

// 일반 사용자의 로그인 절차를 정의한 strategy
// 아래 익명함수 어디에선가 (authError, user, info) => { }를 done 이라는 이름의 변수에 받아서 done 이름으로 호출됩니다
module.exports = () => {
    passport.use(new LocalStrategy({
        usernameField: 'userid',
        passwordField: 'pwd',
    }, async (userid, pwd, done) => {

        try {
            const exUser = await User.findOne({
                where: {
                    userid,
                }
            })

            if (exUser) {
                if (pwd == exUser.pwd) { // 비밀번호가 일치한다면
                    done(null, exUser)
                } else {
                    done(null, false, { message: '비밀번호가 일치하지 않습니다' })
                }
            } else {
                done(null, false, { message: '아이디가 없습니다' })
            }
        } catch (err) {
            console.error(err);
            done(err);
        }
    }));
}