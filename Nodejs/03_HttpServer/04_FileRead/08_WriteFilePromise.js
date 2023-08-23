
const fs = require('fs').promises

fs.writeFile('./writeMe3.txt', '안녕하세요 \n반갑습니다')
  .then(() => {
    // 방금쓴 내용을 다시 읽어오는 promise 를 리턴함
    return fs.readFile('./writeMe3.txt')
    // then 에서 프라미스 함수가 리턴되면, 또 하나의 then을 이어서 결과처리를 할 수 있음
  })
  .then((data) => {
    console.log(data.toString())
  })
  .catch((err) => {
    console.error(err)
  })