
// wirteem2.txt 에 글을 써서 콘솔창에 출력하세요
const fs = require('fs')
const string = '안녕하세요 \n반갑습니다\n잘가세요'
fs.writeFile('./writeme2.txt', string, (err) => {
  if (err) {
    console.error(err)
  }
})
fs.readFile('./writeme2.txt', (err, data) => {
  if (err) {
    console.error(err)
  } else {
    console.log(data.toString())
  }
})