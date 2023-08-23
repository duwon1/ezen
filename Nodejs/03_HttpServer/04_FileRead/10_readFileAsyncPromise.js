
const fs = require('fs').promises

console.log('--------------------------------------------------------------')

console.log('시작')
fs.readFile('./readME1.txt')
  .then((data) => {
    console.log(`1번 : ${data.toString()}`)
    return fs.readFile('./readMe2.txt')
  })
  .then((data) => {
    console.log(`2번 : ${data.toString()}`)
    return fs.readFile('readMe3.txt')
  })
  .then((data) => {
    console.log(`3번 : ${data.toString()}`)
    console.log('끝')
  })
  .catch((err) => {
    console.error(err)
  })

  console.log('--------------------------------------------------------------')












