const express = require("express");
const path = require("path");
const mysql = require("mysql2");
const app = express();
const port = process.env.PORT || 5000;

const connection = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "adminuser",
  database: "scott",
});

connection.connect(() => {
  console.log("DB 연결 성공");
});

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.use(express.static(path.join(__dirname, "../client08/build")));

app.get("/", (req, res) => {
  res.send("<h1>Hello World!</h1>");
});

app.get("/main", (req, res) => {
  res.sendFile(path.join(__dirname, "../client08/build/index.html"));
});

app.post("/api/test", (req, res) => {
  console.log(`서버에서 받은 데이터 : ${req.body.text}`);

  res.status(200).json({
    success: true,
    text: "안녕하세요",
  });
});

app.post("/api/join", (req, res, next) => {
  const sql =
    "insert into members( userid, pwd, name, email, phone ) values(?,?,?,?,?)";
  const { id, pwd, name, email, phone } = req.body;

  connection.query(
    sql,
    [id, pwd, name, email, phone],
    (err, result, fields) => {
      if (err) {
        console.error(err);
        next(err);
      } else {
        console.log(result);
        connection.end();
        return res.json({ success: "ok" });
      }
    }
  );
});

app.post("/api/members", (req, res, next) => {
  const sql = "select * from members";
  connection.query(sql, (err, result) => {
    if (err) {
      console.error(err);
    } else {
      console.log(result);
      return res.json(result);
    }
  });
});

app.listen(port, () => {
  console.log(`오픈된 포트 :  ${port}번`);
});
