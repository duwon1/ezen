const express = require("express");
const router = express.Router();
const mysql = require("mysql2");

const multer = require("multer");
const path = require("path");
const fs = require("fs");

const connection = mysql.createConnection({
	host: "localhost",
	user: "root",
	password: "adminuser",
	database: "scott",
});

try {
	fs.readdirSync("public/uploads");
} catch (err) {
	fs.mkdirSync("public/uploads");
}

const uploadObj = multer({
	storage: multer.diskStorage({
		destination: function (req, file, cb) {
			cb(null, "public/uploads/");
		},
		filename: function (req, file, cb) {
			const ext = path.extname(file.originalname);
			cb(null, path.basename(file.originalname, ext) + Date.now() + ext);
		},
	}),
});

let paging = {
	page: 1,
	totalCount: 0,
	beginPage: 0,
	endPage: 0,
	displayRow: 10,
	displayPage: 5,
	prev: false,
	next: false,
	startNum: 0,
	endNum: 0,
	calculate: function () {
		this.endPage = Math.ceil(this.page / this.displayPage) * this.displayPage;
		this.beginPage = this.endPage - (this.displayPage - 1);
		let totalPage = Math.ceil(this.totalCount / this.displayRow);
		if (totalPage < this.endPage) {
			this.endPage = totalPage;
			this.next = false
		} else {
			this.next = true
		}
		this.prev = (this.beginPage == 1) ? false : true;
		this.startNum = (this.page - 1) * this.displayRow + 1;
		this.endNum = this.page * this.displayRow;
		console.log(this.beginPage, this.endPage, this.startNum, this.totalCount)
	}
}

router.get("/getBoardList/:page", (req, res, next) => {
	if (req.params.page !== undefined) {
		paging.page = req.params.page
		req.session.page = req.params.page;
	} else if (req.session.page !== undefined) {
		paging.page = req.session.page
	} else {
		req.session.page = ''
	}



	// 게시물의 갯수를 세고, 그 숫자를 totalCount 에 저장하고, calculate 함수를 호출
	let sql = 'select * from boards'
	connection.query(sql, (err, rows) => {
		if (err) {
			console.error(err)
			next(err);
		};
		paging.totalCount = rows.length;
		paging.calculate()
		sql = "select * from boards order by id desc limit ? offset ? ";
		connection.query(sql, [paging.displayRow, paging.startNum], (err, rows) => {
			if (err) {
				console.error(err.message);
				next(err);
			} else {
				return res.send({ rows, paging });
			}
		});

	})

});

router.post("/getBoard", (req, res, next) => {
	console.log(req.body.boardid);
	const sql = "select * from boards where id=?";
	connection.query(sql, [req.body.boardid], (err, rows) => {
		if (err) {
			console.error(err.message);
		} else {
			console.log(rows[0]);
			req.session.boardid = req.body.boardid;
			return res.json({ board: rows[0] });
		}
	});
});

router.post("/fileupload", uploadObj.single("image"), (req, res, next) => {
	res.json({
		filename: `/uploads/${req.file.filename}`,
		realfilename: `/uploads/${req.file.originalname}`,
	});
});

router.post("/writeBoard", (req, res, next) => {
	console.log(req.body.board);
	console.log(req.session.loginUser);

	const sql =
		"insert into boards(subject, content, filename, realfilename, writer) values(?,?,?,?,?)";
	const { subject, content, realfilename, filename } = req.body.board;

	connection.query(
		sql,
		[subject, content, filename, realfilename, req.session.loginUser.userid],
		(err, rows) => {
			if (err) {
				console.error(err.message);
				next(err);
			} else {
				return res.send("ok");
			}
		}
	);
});

router.post("/updateBoard", (req, res, next) => {
	const { subject, content, realfilename, filename, id } = req.body.board;
	const sql =
		"update boards set subject=?, content=?, filename=?, realfilename=? where id=?";
	connection.query(
		sql,
		[subject, content, filename, realfilename, id],
		(err, rows) => {
			if (err) {
				console.error(err.message);
			} else {
				return res.send("ok");
			}
		}
	);
});

router.post("/deleteBoard", (req, res, next) => {
	const boardid = req.body.boardid;
	const sql = "delete from boards where id =?";
	connection.query(sql, [boardid], (err, rows) => {
		if (err) {
			console.error(err.message);
		} else {
			res.send("ok");
		}
	});
});

router.post("/getReplyList", (req, res, next) => {
	const boardid = req.body.boardid;
	console.log(req.body.boardid)
	const sql = "select * from replys where boardnum=?";
	connection.query(sql, [boardid], (err, rows) => {
		if (err) {
			console.error(err.message);
		} else {
			console.log("댓글 리스트", rows)
			res.json({ replyList: rows })
		}
	});
});

router.post('/reply', (req, res, next) => {
	const { reply, boardid, userid } = req.body;
	console.log(reply, boardid, userid)
	const sql = "insert into replys(content, boardnum, writer) values(?,?,?)";
	connection.query(sql, [reply, boardid, userid], (err, rows) => {
		if (err) {
			console.error(err.message);
		} else {
			res.send("ok");
		}
	})
})

router.post("/deleteReply", (req, res, next) => {
	const replyid = req.body.replyid;
	const sql = "delete from replys where id =?";
	connection.query(sql, [replyid], (err, rows) => {
		if (err) {
			console.error(err.message);
		} else {
			res.send("ok");
		}
	})
})

module.exports = router;
