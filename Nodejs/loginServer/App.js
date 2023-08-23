
const express = require('express');
const cookieParser = require('cookie-parser');
const session = require('express-session');
const path = require('path');
const nunjucks = require('nunjucks');
const dotenv = require('dotenv');
const passport = require('passport');
const dateFilter = require('nunjucks-date-filter');
const morgan = require('morgan');

const app = express(); // 서버 객체
app.set('port', process.env.PORT || 3000); // 포트 변수설정
dotenv.config(); // .env 파일 사용 설정
app.set('view engine', 'html'); // 템플릿 엔진 파일확장자 설정
let env = nunjucks.configure('views', { express: app, watch: true }); // 템플릿 엔진 폴더 설정
env.addFilter('date', dateFilter) // 날짜 데이터 형식 사용설정
app.use(morgan('dev')); // 서버 클라이언트 요청응답 표시설정
app.use(express.static(path.join(__dirname, 'public'))); // static 폴더 설정

app.use(express.json()); //json 양식 사용설정
app.use(express.urlencoded({ extended: false })); // req.body 설정
app.use(cookieParser(process.env.COOKIE_SECRET)); // 쿠키 사용
app.use(session({ // 세션 사용
    secret: process.env.COOKIE_SECRET,
    resave: false,
    cookie: { // session-cookie 설정
        httpOnly: true,
        secure: false
    }
}))
// 한명의 사용자에 의해 세션에 한개이상 값이 저장되면 그 값을 사용하는 클러이언트를 구분할 수 있는 쿠키가 자동으로 클라이언트에 심어집니다,
// 그 쿠키에 대한설정 세션값이 삭제되거나 브라우저가 닫히면 쿠키값도 사라짐

const { sequelize } = require('./models');
sequelize.sync({ force: false }).then(() => {
    console.log('DB connected');
}).catch((err) => {
    console.error(err)
})

const passportConfig = require('./passport');
passportConfig();

// passport 모듈의 생성은 세션과 연관있으므로 그뒤에 미들웨어를 설정
app.use(passport.initialize());
app.use(passport.session());



const authRouter = require('./routers/auth')
app.use('/', authRouter);



app.use((req, res, next) => {
    const error = new Error('Not Found');
    error.status = 404;
    next(error);
})

app.use((err, req, res, next) => {
    res.locals.message = err;
    res.locals.error = req.app.get('env') === 'development' ? err : {};
    res.status(err.status || 500);
    console.error(err);
    res.send('error');
})

app.listen(app.get('port'), () => {
    console.log(`Express server listening on port ${app.get('port')}`);
})


