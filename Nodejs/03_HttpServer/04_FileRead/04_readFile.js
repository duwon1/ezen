
// 파일의 내용을 읽거나 쓰기위한 모듈
const fs = require('fs');
fs.readFile(
  './readMe.txt', // 읽어올 파일의 경로와 이름
  (err, data) => { // 읽어온 파일을 처리함 함수
    if (err) {
      console.error(err)
    } else {
      console.log(data)
      console.log(data.toString())
    }
  }
)
// err : 파일읽기에 실패했을때 전달되는 에러메시지
// data : 파일읽기에 성공했을때 읽어온 파일 내용 데이터



