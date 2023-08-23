const express = require(`express`);
const router = express.Router();

router.get(`/`, (req, res) => {

    if (req.session.loginUser != undefined) {
        res.redirect('/boards/')
    } else {
        res.render(`login`, {});
    }
});

module.exports = router;