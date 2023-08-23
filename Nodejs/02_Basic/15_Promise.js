// Promise 를 리턴하는 함수를 동기식으로 진행되는 함수안에서 써야할때
let condition = false
const promise1 = new Promise((resolve, reject) => {
  if (condition) {
    resolve('성공')
  }
  else {
    reject('실패')
  }
})

// await 를 사용한 명령은 async 로 만들어진 함수 안에서 사용해야 함
async function abcd() {
  try {
    // promise1의 값을 현재 함수의 지역변수에 저장 이떄 await 라는 키워드를 사용
    result = await promise1
    console.log(`1 ${result}`)
  } catch (err) {
    console.error(`2 ${err}`)
  }
  console.log('3. abcd 함수 종료')
}
abcd()