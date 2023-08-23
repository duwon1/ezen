const express = require('express');
const app = express();
const router = express.Router();
const { isLoggedIn, isNotLoggedIn } = require('./middleware');
const TextUser = require('../models/TextUser');

router.post(`/login`, isNotLoggedIn, async (req, res, next) => {
    try {
        const loginUser = await TextUser.findOne({
            where: {
                userid: req.body.userid,
            },
        });
        if (loginUser !== null) {
            req.session.loginUser = loginUser;
        };
        res.json(loginUser);
    } catch (error) {
        console.error(error);
        next(error);
    }
});
router.get('/main', (req, res, next) => {
    res.render('main');
})

router.get(`/logout`, (req, res, next) => {
    req.session.destroy(() => {
        req.session;
    });
    res.redirect(`/`);
});

module.exports = router;

