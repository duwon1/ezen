//  04_Array.js
// 객체가 key:value 형태의 자료의 집합이라면, Array 는 key 대신 index(번호)를 사용하여 여러 자료를 한 곳에 모아 사용하는 형태
// 다양한 자료를 하나의 범주안에 넣고, 인덱싱(번호)을 이용해 컨트롤 하는 변수
var array = [273, 'string', true, function(){}, {}, [150, 170]];
console.log(array[0]);
console.log(array[1]);
console.log(array[2]);
console.log(array[3]);
console.log(array[4]);
console.log(array[5]);
console.log(array);
console.log('\n');




var arr = ['a', 'b', 'c'];
console.log('변경전 : ' + arr);

// 배열의 내용을 볼 수 있는 방법 #1
console.log( arr );

// 배열의 내용을 볼 수 있는 방법 #2
for( var i in arr ){
    // i 는 배열의 index
    console.log(i);
}
console.log('--------------------------------------------------------------')

// 배열의 내용을 볼 수 있는 방법 #3
// arr.map() // ()안에 익명함수를 하나 넣는데 그 익명함수르 배열의 요소들을 대상으로 한번씩 실행
// arr.map(function(){})

arr.map(function(value, idx) {
  // value : 배열의 요소들이 한번씩 저장될 변수
  // idx : 그 요소들의 첨자
  console.log(`index: ${idx}, value : ${value}`)
})

console.log('--------------------------------------------------------------')

arr.push('d') // 배열의 끝에 요소를 추가
console.log(`배열 끝에 요소 추가 : ${arr}`)

arr.unshift('A') // 배열의 앞쪽에 요소를 추가
console.log(`배열의 앞쪽 요소 추가 : ${arr}`)

arr.splice(2, 0, 'B') // index 2 ('b')의 위치에 요소를 추가
console.log(`index : 2('b')의 위치에 'B' 요소를 추가 : ${arr}`)

console.log('--------------------------------------------------------------')

arr = ['a', 'b', 'c', 'e', 'f']
console.log(`변경전 : ${arr}`)
// index : 2 부터 1개의 요소 ('c')를 제거
arr.splice(2, 1)
console.log(`변경후(index 2 부터 1개의 요소 'c'를 제거) : ${arr}`)

console.log('--------------------------------------------------------------')
arr = ['a', 'b', 'c', 'e', 'f']
console.log(`변경전 : ${arr}`)
arr.splice(1, 2)
console.log(`변경후(index 1 부터 2개의 요소('b', 'c')를 제거) : ${arr}`)

console.log('--------------------------------------------------------------')

// delete 로 배열의 요소를 삭제할 경우 값은 삭제되고, 자리요소는 존재합니다
var arr = ['a', 'b', 'c', 'e', 'f']
console.log(`변경전 : ${arr}`)
delete arr[1]
console.log(`변경후(arr[1] 삭제) : ${arr}`)