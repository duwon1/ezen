
const passport = require('passport')
const LocalStrategy = require('passport-local').Strategy;
const bcrypt = require('bcrypt');
const User = require('../models/User');

// 일반 사용자의 로그인 절차를 정의한 strategy
// 아래 익명함수 어디에선가 (authError, user, info) => { }를 done 이라는 이름의 변수에 받아서 done 이름으로 호출됩니다
module.exports = () => {
    passport.use(new LocalStrategy({
        usernameField: 'email',
        passwordField: 'password'
    }, async (email, password, done) => {
        // 로그인을 위해서 입력한 이메일을 검색하고 있으면 비밀번호 까지 비교, 없으면 없는 아이디로 처리
        // done(null, await User.findOne({ email: username }));
        try {
            const exUser = await User.findOne({
                where: {
                    email
                }
            })
            if (exUser) { // 회원이 존재한다면
                // 입력받은 password 를 bcrypt로 암호화 하여 조회된 회원의 password와 비교합니다
                const result = await bcrypt.compare(password, exUser.password)
                if (result) { // 비밀번호가 일치한다면
                    done(null, exUser)
                } else { // 비밀번호가 일치하지 않으면
                    done(null, false, { message: '비밀번호가 일치하지 않습니다' })
                }
            } else { // 이메일이 없는 이메일이라면
                done(null, false, { message: '이메일이 없습니다' })
            }
        } catch (err) {
            console.error(err);
            done(err);
        }
    }));
}