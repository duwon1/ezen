const express = require(`express`);
const Member = require(`../models/Member`);
const { isLoggedIn, isNotLoggedIn } = require('./middleware');

const router = express.Router();

router.post(`/login`, isNotLoggedIn, async (req, res, next) => {
    try {
        const loginUser = await Member.findOne({
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

router.get(`/logout`, (req, res, next) => {
    req.session.destroy(() => {
        req.session;
    });
    res.redirect(`/`);
});

router.get(`/joinform`, (req, res, next) => {
    res.render(`memberInsert`, {});
});

router.post(`/insertMember`, async (req, res, next) => {
    try {
        const member = await Member.create({
            userid: req.body.userid,
            name: req.body.name,
            pwd: req.body.pwd,
            phone: req.body.phone,
            email: req.body.email,
        });
        res.end();
    } catch (error) {
        console.error(error);
        next(error);
    }
});

router.get(`/updateForm/:userid`, async (req, res, next) => {
    try {
        const member = await Member.findOne({
            where: {
                userid: req.params.userid,
            },
        });
        res.render(`memberUpdateForm`, {member});
    } catch (error) {
        console.error(error);
    }
});

router.post(`/update`, async (req, res, next) => {
    try {
        const result = await Member.update({
            pwd: req.body.pwd,
            name: req.body.name,
            phone: req.body.phone,
            email: req.body.email,
        },
        {
            where: {
                userid: req.body.userid,
            },
        });
        const member = await Member.findOne({
            where: {
                userid: req.body.userid,
            },
        });
        req.session.loginUser = member;
        res.json(member);
    } catch (error) {
        console.error(error);
    }
});

module.exports = router;