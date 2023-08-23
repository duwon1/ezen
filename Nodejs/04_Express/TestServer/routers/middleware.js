
exports.isLoggedIn = (req, res, next) => {
    if (req.session.loginUser != undefined) {
      // 로그인이 된 상태
      next();
    } else {
      // 로그인이 안된상태
      res.status(403).send('로그인이 필요합니다')
      
    }
  }
  
  
  exports.isNotLoggedIn = (req, res, next) => {
    if (req.session.loginUser == undefined) {
      // 로그인이 안된상태
      next();
    } else {
      // 로그인이 된 상태
      res.status(403).send('로그아웃 해주세요')
    }
  }