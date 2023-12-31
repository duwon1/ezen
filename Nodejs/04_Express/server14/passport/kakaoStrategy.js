
const passport = require('passport');
const kakaoStrategy = require('passport-kakao').Strategy;
const User = require('../models/User');


module.exports = () => {
    passport.use(new kakaoStrategy({
        clientID: process.env.KAKAO_ID,
        callbackURL: '/auth/kakao/callback',
    }, async (accessToken, refreshToken, profile, done) => {
        console.log('kakao profile', profile);

        try {
            const exUser = await User.findOne({
                where: 
                {
                    snsid: profile.id,
                    provider: 'kakao'
                }
            });

            if (exUser) {
                done(null, exUser);
            } else {
                const newUser = await User.create({
                    email: profile._json && profile._json.kakao_account.email,
                    nick: profile.displayName,
                    snsid: profile.id,
                    provider: 'kakao'
                });
                console.log(newUser);
                done(null, newUser);
            }
        } catch (err) {
            console.error(err);
            done(err);
        }
    }))
}




















