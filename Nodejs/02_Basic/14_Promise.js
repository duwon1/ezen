// 동기실행과 비동기실행의 차이
// 긴작업의 작업1과 짧은 작업의 작업2가 있다면
/*
// 동기실행
console.log('===작업시작===')
console.log('작업1 시작')
// 현재시간에 3초를 더한값을 wakeUpTime 변수에 저장
const wakeUpTime = Date.now() + 3000
while (Date.now() < wakeUpTime) { }
console.log('작업1 종료')
console.log('작업2 시작')
console.log('작업2 종료')
console.log('===작업 끝===')
*/
/*
console.log('--------------------------------------------------------------')

// 비동기 실행
function longRunnungTask() {
  console.log('작업1 진행 모두 종료후 =>작업1 종류')
}

console.log('===작업시작===')
console.log('작업1 시작')
console.log('작업1을 비동기 실행으로 전환')
// 3초후에 longRunningTask 함수를 호출함
setTimeout(() => {
  longRunnungTask
}, 3000);
console.log('작업2 시작')
console.log('작업2 종료')
console.log('===작업 끝===')
*/
/*
console.log('--------------------------------------------------------------')

console.log('===작업시작===')
let longRunningTask = new Promise((resolve, reject) => {
  console.log('작업1 시작')
  setTimeout(() => {
    console.log('작업1 종료')
  }, 3000);
  resolve()
})
longRunningTask.then(
  () => {
    console.log('작업2 시작')
    console.log('작업2 종료')
  }
)
console.log('===작업 끝===')

console.log('--------------------------------------------------------------')
*/
console.log('===작업시작===')
const pm1 = new Promise((resolve, reject) => {
  console.log('첫번쨰 리졸브')
})
pm1.then((msg1) => {
  console.log(msg1)
  return new Promise((resolve, reject) => {
    resolve('두번째 리졸브')
  })
}).then((msg2) => {
  console.log(msg2)
  return new Promise((resolve, reject) => {
    resolve('세번째 리졸브')
  })
}).then((msg3) => {
  console.log(msg3)
}).catch((error) => {
  console.error(error)
})

console.log('===작업 끝===')
