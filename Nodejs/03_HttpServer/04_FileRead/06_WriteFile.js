
const fs = require('fs')

fs.writeFile(
  './writeMe.txt', // 수정하려는 파일
  '텍스트가 입력됨', // 수정하려는 내용
  (err) => {
    console.error(err)
  }
)


