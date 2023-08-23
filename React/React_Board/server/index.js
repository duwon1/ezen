const express = require('express');
const path = require('path');
const cookieParser = require('cookie-parser');
const session = require('express-session');
// ----------------------------------------------------------------
const app = express();
const port =  5000;
app.use(express.static(path.join(__dirname, 'public')));

app.use(cookieParser());
app.use(session({ resave: false, saveUninitialized: true, secret: 'keyboard'}));
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
// ----------------------------------------------------------------

const membersRouter = require('./routers/member');
const boardsRouter = require('./routers/board');

app.use('/api/members', membersRouter);
app.use('/api/boards', boardsRouter);





// ----------------------------------------------------------------

app.use((req, res, next) => {
  const err = new Error(`${req.method} ${req.url} - Not Found`);
  err.status = 404;
  next(err);
})
app.use((err, req, res, next) => {
  res.locals.meessage = err.message;
  res.locals.error = req.app.get('env') === 'development'? err : {};
  res.status(err.status || 500);
  console.error(err.message);
  res.send(`${err.message}`);
})



app.listen(port, () => {
  console.log(`Example app listening on port ${port}!`);
})











