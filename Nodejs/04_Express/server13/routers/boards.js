const express = require(`express`);
const Board = require('../models/Board');
const Reply = require('../models/Reply');
const multer = require('multer');
const fs = require('fs');
const path = require('path');
const { isLoggedIn, isNotLoggedIn } = require('./middleware');

const paging = {
    page: 1,
    totalCount: 0,
    beginPage: 0,
    endPage: 0,
    disPlayRow: 10,
    disPlayPage: 10,
    prev: false,
    next: false,
    startNum: 0,
    endNum: 0,
    paging: () => {
        // paging 함수
        this.endPage = (Math.ceil(this.page / this.disPlayPage)) * this.disPlayPage;
        this.beginPage = this.endPage - (this.disPlayPage - 1)
        let totalPage = Math.ceil(this.totalCount / this.disPlayRow)
        if (totalPage < this.endPage) {
            this.endPage = totalPage
            this.next = false
        } else {
            this.next = true
        }

        this.prev = this.beginPage == 1 ? false : true
        this.startNum = (this.page - 1) * this.disPlayRow + 1
        this.endNum = this.page * this.disPlayRow

        console.log(this.beginPage, this.endPage, this.prev, this.next, this.startNum, this.endNum);
    }
}

const router = express.Router();

// 업로드용 폴더의 인식 & 생성
try {
    fs.readdirSync('public/upload')
} catch (err) {
    fs.mkdirSync('public/upload');
}

const upload = multer({
    storage: multer.diskStorage({
        // 업로드 경로 및 파일이름 설정
        destination(req, file, done) {
            done(null, 'public/upload');
        },
        filename(req, file, done) {
            const ext = path.extname(file.originalname)
            done(null, path.basename(file.originalname, ext) + Date.now() + ext);
        },

    }),

    limits: {
        fileSize: 5 * 1024 * 1024
    },
})

router.get('/', isLoggedIn, (req, res) => {
    const loginUser = req.session.loginUser;
    res.render('main', { loginUser })

    // if (req.session.loginUser == undefined) {
    //     res.redirect('/')
    // }
    // const loginUser = req.session.loginUser;
    // res.render('main', { loginUser })
});

// router.get('/boardList', async (req, res, next) => {
//     try {
//         const boardList = await Board.findAll({
//             order: [['id', 'desc']] // 게시물 번호로 내림차순 정렬
//         });
//         res.json(boardList);
//     } catch (err) {
//         console.error(err);.
//         next(err);
//     }
// });


router.get('/boardList/:page', async (req, res, next) => {

    console.log("page : ", req.params.page);
    if (req.params.page == undefined) {
        paging.page = 1;
    } else {
        paging.page = req.params.page;
    }

    // 게시물 갯수 조회
    let count = 0;
    paging.paging()
    try {
        const result = await Board.findAll({
        })
        count = result.length;
    } catch (err) {
        console.error(err);
    }
    paging.totalCount = count;

    try {
        const boardList = await Board.findAll({

            offset: paging.startNum, // 조회하고자하는 게시물의 시작 위치
            limit: paging.endNum - paging.startNum, // 조회할 레코드의 갯수
            order: [['id', 'desc']] // 게시물 번호로 내림차순 정렬
        });
        res.json({ boardList, paging });
    } catch (err) {
        console.error(err);
        next(err);
    }
});

router.get(`/boardView/:id`, async (req, res, next) => {
    try {
        // 게시물을 id로 검색 (readCount 만)
        const result = await Board.findOne({
            attributes: [`readCount`],
            where: {
                id: req.params.id,
            },
        });
        // 검색한 게시물의 조회 수를 추출해서 +1
        const readCount = result.readCount + 1;
        await Board.update({
            readCount,
        }, {
            where: {
                id: req.params.id,
            },
        })
        // 다시 게시물 검색
        const board = await Board.findOne({
            where: {
                id: req.params.id,
            },
        });
        // render로 전송 (로그인 유저, 현재시간도 같이 전송)
        const loginUser = req.session.loginUser;
        const nowDate = new Date();
        nowDate.setHours(nowDate.getHours() + 9);
        res.render('boardView', { board, loginUser, nowDate });
    } catch (error) {
        console.error(error);
    }
});

router.get('/writeForm', async (req, res, next) => {
    const loginUser = req.session.loginUser;
    res.render('writeForm', { loginUser })
})

router.post('/writeBoard', upload.single('image'), async (req, res, next) => {
    try {
        // upload.single('image') : image 라는 id 로 된 태그에서 전송된 파일을, 설정되어 있는 파일이름으로 업로드 해줍니다
        if (req.file != undefined) {
            Board.create({
                subject: req.body.subject,
                content: req.body.text,
                filename: req.file.originalname, // 전송된 파일이름
                realfilename: req.file.filename, // 서버에 저장될 파일이름
                writer: req.body.writer,
            })
        } else {
            await Board.create({
                subject: req.body.subject,
                content: req.body.text,
                writer: req.body.writer,
            })
        }
        res.send('ok')
    } catch (err) {
        console.error(err);
        next(err);
    }
})

router.get('/replyList/:boardnum', async (req, res, next) => {
    try {
        const result = await Reply.findAll({
            where: {
                boardnum: req.params.boardnum,
            },
            order: [['id', 'desc']]
        })
        res.send(result);
    } catch (err) {
        console.error(err);
        next(err);
    }
})

router.get('/replycnt/:boardnum', async (req, res, next) => {
    try {
        const count = await Reply.findAll({
            where: {
                boardnum: req.params.boardnum,
            },
        })
        res.json({ cnt: count.length })
    } catch (err) {
        console.error(err);
        next(err);
    }
})

router.post('/insertReply', async (req, res, next) => {
    try {
        await Reply.create({
            content: req.body.reply,
            boardnum: req.body.boardnum,
            writer: req.body.writer
        })
        res.send("ok");
    } catch (err) {
        console.error(err);
    }
})

router.delete('/deleteReply/:id', async (req, res, next) => {
    try {
        await Reply.destroy({
            where: {
                id: req.params.id,
            },
        })
        res.end();
    } catch (err) {
        console.error(err);
    }
})

router.get('/UpdateForm/:id', async (req, res, next) => {
    try {
        const board = await Board.findOne({
            where: {
                id: req.params.id,
            },
        })
        const loginUser = req.session.loginUser;
        res.render('UpdateForm', { board, loginUser })
    } catch (err) {
        console.error(err);
    }
})

router.post('/update', upload.single('image'), async (req, res, next) => {
    try {
        if (req.file != undefined) {
            await Board.update({
                subject: req.body.subject,
                content: req.body.text,
                filename: req.file.originalname,
                realfilename: req.file.filename
            }, {
                where: {
                    id: req.body.id,
                },
            }
            )
        } else {
            await Board.update({
                subject: req.body.subject,
                content: req.body.text,
                filename: null,
                realfilename: null,
            }, {
                where: {
                    id: req.body.id,
                },
            })
        }

        res.end()
    } catch (err) {
        console.error(err);
        next(err);
    }
})

router.get('/BoardViewWithoutCount/:id', async (req, res, next) => {
    try {
        // 게시물을 id로 검색 (readCount 만)
        const result = await Board.findOne({
            attributes: [`readCount`],
            where: {
                id: req.params.id,
            },
        });
        // render로 전송 (로그인 유저, 현재시간도 같이 전송)
        const loginUser = req.session.loginUser;
        const nowDate = new Date();
        nowDate.setHours(nowDate.getHours() + 9);
        res.render('boardView', { board, loginUser, nowDate });
    } catch (error) {
        console.error(error);
    }
})

router.get('/deleteBoard/:id', async (req, res, next) => {
    try {
        const result = await Board.destroy({
            where: {
                id: req.params.id,
            }
        });
        res.redirect('/boards');
    } catch (err) {
        console.error(err);
    }
})

module.exports = router;