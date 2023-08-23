const express = require("express");
const router = express.Router();
const mysql = require("mysql2");
const connection = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "adminuser",
  database: "scott",
});

router.post("/login", (req, res, next) => {
  const { userid, pwd } = req.body;
  const sql = "select * from members where userid=?";
  connection.query(sql, [userid], (err, rows) => {
    if (err) {
      console.error(err.message);
      next(err);
    } else {
      if (rows.length > 0 && rows[0].pwd == pwd) {
        // 아이디가 존재하고 비밀빈호도 맞음
        req.session.loginUser = rows[0];
        return res.json({
          loginUser: req.session.loginUser,
          login: "ok",
        });
      } else if (rows.length > 0 && rows[0].pwd != pwd) {
        // 아이디는 존재하지만 비밀번호가 틀림
        return res.json({
          login: "fail",
          message: "비밀번호가 맞지 않습니다",
        });
      } else {
        return res.json({
          // 아이디가 맞지않음
          login: "fail",
          message: "아이디가 없습니다",
        });
      }
    }
  });
});

router.get("/loginok", (req, res, next) => {
  if (req.session.loginUser) {
    return res.json({ login: "ok" });
  } else {
    return res.json({ login: "fail" });
  }
});

router.get("/getLoginUser", (req, res, next) => {
  console.log(req.session.loginUser);
  res.json({ loginUser: req.session.loginUser });
});

router.get("/logout", (req, res, next) => {
  req.session.destroy(() => {
    req.session;
  });
  res.end();
});

router.post("/join", (req, res, next) => {
  const { userid, pwd, name, phone, email } = req.body.joinUser;
  const sql = "select * from members where userid=?";
  connection.query(sql, [userid], (err, rows) => {
    if (err) {
      console.error(err.message);
      next(err);
    } else {
      if (rows.length > 0) {
        return res.json({
          join: "fail",
          message: "이미 존재하는 아이디입니다",
        });
      } else {
        const sql =
          "insert into members(userid, pwd, name, phone, email) values(?,?,?,?,?)";
        connection.query(
          sql,
          [userid, pwd, name, phone, email],
          (err, rows) => {
            if (err) {
              console.error(err.message);
              next(err);
            } else {
              return res.json({
                join: "ok",
                message: "회원가입 성공",
              });
            }
          }
        );
      }
    }
  });
});

router.post("/updateMember", (req, res, next) => {
  let sql = "update members set pwd=?, name=?, phone=?, email=? where userid=?";
  const { userid, pwd, name, phone, email } = req.body.loginUser;

  connection.query(sql, [pwd, name, phone, email, userid], (err, rows) => {
    if (err) {
      console.error(err.message);
      next(err);
    } else {
      sql = "select * from members where userid=?";
      connection.query(sql, [userid], (err, rows) => {
        if (err) {
          console.error(err.message);
          next(err);
        } else {
          req.session.loginUser = rows[0];
          return res.json({
            message: "회원정보 수정 성공",
          });
        }
      });
    }
  });
});

module.exports = router;
