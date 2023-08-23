// 현재 파일엣 사용하던 변수, 객체, 함수 등을 다른 파일에서도 사용이 가능함
// 현재 파일에서 exports
// 사용하고자 하는 파일에서 require

const odd = '홀수입니다'
const even = '짝수입니다'

module.exports = { odd: odd, even: even }
// 만들어진 객체를 module.exports 에 저장하면 그 객체는 외부로 보내집니다
// 딱히 어느 파일로 내보낸다라는 방향은 없고,
// exports 되었다라는 걸 알고 있는 파일에서 require 해서 사용합니다
// module 이라는 단위로, 이름은 파일이름은 var로 exports 됩니다