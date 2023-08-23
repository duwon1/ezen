
const passport = require('passport');
const kakaoStrategy = require('passport-kakao').Strategy;
const User = require('../models/loginUser');


module.exports = () => {
    passport.use(new kakaoStrategy({
        clientID: process.env.KAKAO_ID,
        callbackURL: '/kakao/callback',
    }, async (accessToken, refreshToken, profile, done) => {
        console.log('kakaoprofile', profile);
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
                    userid: profile.id,
                    nick_name: profile.displayName,
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




















