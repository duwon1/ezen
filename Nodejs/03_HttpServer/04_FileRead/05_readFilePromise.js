
// 파일 입출력을 위한 모듈의 prodmise 포함하여 로딩합니다
const fs = require('fs').promises

// readFile 함수에 Promise 객체를 리턴하는 기능이 담겨있습니다
// 파일 읽기에 성공했을떄와 실패했을때를 then과 catch에서 구분실행하면 됨
fs.readFile('./readMe.txt')
  .then(
    (data) => {
      console.log(data.toString())

    }
  )
  .catch(
    (err) => {
      console.error(err)
    }
  )
  console.log('Promise 로 파일읽기를 종료했습니다')