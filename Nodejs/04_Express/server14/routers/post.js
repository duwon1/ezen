const express = require('express');
const router = express.Router();
const multer = require('multer');
const path = require('path');
const fs = require('fs');
const { Post, User, Hashtag } = require('../models');
const { isLoggedIn, isNotLoggedIn } = require('./middleware');

try {
    fs.readdirSync('uploads')
} catch (err) {
    console.error(err);
    fs.mkdirSync('uploads');
}
const uploadObj = multer({
    storage: multer.diskStorage({
        destination: (req, file, cb) => {
            cb(null, 'uploads/');
        },
        filename: (req, file, cb) => {
            const ext = path.extname(file.originalname);
            cb(null, path.basename(file.originalname, ext) + Date.now() + ext);
        }
    }),
    limits: { fileSize: 5 * 1024 * 1024 } // 5MB 
})


router.post('/img',isLoggedIn, uploadObj.single('img'), (req, res, next) => {
    console.log('이미지 : ' + req.file.filename);
    res.json({ url: '/img/' + req.file.filename });
})

const uploadObj2 = multer()
// form 안에 input type="file" 이 있기떄문에 submit 이 동작하면 파일을 한번더 업로드 하려함
// 파일 업로드를 생략하기위해 비어있는 multer 객체를 만들고 uploadOBj2.none() 으로 파일 업로드를 생략
router.post('/',isLoggedIn, uploadObj2.none(), async (req, res, next) => {
    try {
        // 1. post 테이블에 피드를 레코드로 저장
        const currentPost = await Post.create({
            content: req.body.content,
            img: req.body.url,
            UserId: req.user.id
        })
        // 2. 입력된 피드의 본문에서 해시태그만 골라낸다
        const hashtags = req.body.content.match(/#[^\s#]*/g)
        console.log(hashtags)

        /// 3. 해시태그를 하나씩 hashtags 테이블에서 검색해서, 없으면 자동생성 id와 함께 hashtags 테이블에 저장
        if (hashtags) { // 추출한 해시태그가 하나이상 있다면
            const result = await Promise.all(
                hashtags.map((tag) => {
                    // tag에 담긴 단어가 hashtags 테이블에 있으면 그냥 리턴 없으면 추가하고 리턴
                    return Hashtag.findOrCreate({
                        where: {
                            title: tag.slice(1).toLowerCase(),
                        },
                    });
                })
            )
            // 4. 방금 추가된 피드의 id와 해시태그 id를 PostHashTag 테이블에 추가
            // posts 테이블과 hashtags 테이블의 외래키 관계를 이용하여 간단한 레코트 추가 방법 
            await currentPost.addHashtags(result.map((r) => r[0]));
        }
        res.redirect('/')
    } catch (error) {
        console.error(error);
        next(error);
    }
});

module.exports = router;