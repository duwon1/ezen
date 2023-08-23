
const { copyFileSync } = require('fs')
const path = require('path')
// node.js와 자바스크립트 버전업에 따라 path모듈은 별도의 require 없이 사용이 가능해짐

console.log('--------------------------------------------------------------')

// path 가 아니어도 사용 가능한 경로와 파일관련 상수
console.log(__filename) // 현재사용중인 파일의 이름
console.log(__dirname) // 현재 파일이 위치한 경로

// 현재 경로와 파일의 이름을 변수에 저장하여 별도 출력
const string = __filename
console.log(string)

console.log('--------------------------------------------------------------')

console.log(`path.sep : ${path.sep}`)
// '\' back slash -> c:\users\java01 와 같이 사용합니다
console.log(`path.delimiter : ${path.delimiter}`)
// 환경변수내에서 서로다른 경로를 같이 나타낼때 고분해주는 구분 문자 - 세미콜론 ;
// c:\users\java01; c:\users\java01\documents; 와 같이 사용합니다

console.log('--------------------------------------------------------------')

let fileName = __filename // D:\JAVA01\Nodejs\03_HttpServer\04_FileRead\02_Path.js

// 파일이 위치한 폴더 경로를 보여줍니다
console.log(`path.dirname : ${path.dirname(fileName)}`)
// 파일의 확장자를 보여줍니다
console.log(`path.extname : ${path.extname(fileName)}`)
// 파일의 이름+확장자를 보여줍니다
console.log(`path.basename : ${path.basename(fileName)}`)
// 파일의 이름만 보고 싶다면, 함수의 두번째 인자로 확장자를 넣어줍니다
console.log(`path.basename(extname 제외) : ${path.basename(fileName, path.extname(fileName))}`)

console.log(path.dirname(fileName) + path.sep + path.basename(fileName))

console.log('--------------------------------------------------------------')

// 파일의 경로를 root, dir, base, ext, name 으로 분리함
console.log(`path.parse() : ${path.parse(fileName)}]`)
// 분리된 결과를 root, dir, base, ext, name 라는 필드로 객체를 구성함

// 파일의 이름, 경로, 확장자 등을 제공하고 fileName 에 저장된 정보처럼 조합합니다
let filename2 = path.format({
  dir : `D:\\JAVA01\\Nodejs\\03_HttpServer\\04_FileRead`,
  name : 'path-foramtex',
  ext : '.js'
})

console.log(filename2)

// 파일 경로를 사용하던중 \ / 를 실수로 잘못 쓴경우 수정합니다
console.log(`path.normalize() : ${path.normalize('D:/JAVA01\//\Nodejs///\\03_HttpServer\\//04_FileRead')}`)

// 파일의 경로가 절대경로인지 상대경로인지 true false 로 표시합니다
console.log(`path.isAbsolute(c:\\) : ${path.isAbsolute('C:\\')}`)
console.log(`path.isAbsolute(./home\) : ${path.isAbsolute('./home')}`)

// 파일의 입력인수를 넣어준 경로와 경로사이의 이동경로를 표시함
console.log(path.relative('D:\\JAVA01\\nodejs', 'D:\\'))

// 처음 경로부터 이후 나오는 경로로 이동한 폴더를 표시합니다
console.log(__dirname)
console.log(`path.join() : ${path.join(__dirname, '..', '/eejoonk', '.', '/node_js')}`)

console.log('--------------------------------------------------------------')

















