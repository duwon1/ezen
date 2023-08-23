fun main(){

    // 자바의  switch 와 같은 맥락의 문법입니다.
    val a1 = 1
    when(a1) {
        1 -> println("a1은 1입니다")
        2 -> {
            println("수행되는 코드")
            println("a1은 2입니다")
        }
        3 -> println("a1은 3입니다")
        else -> println("a1은 1, 2, 3이 아닙니다")
    }
    // : 대신 ->       break 사용X          default 대신 else

    val a2 = 3
    when(a2){
        1, 2 -> println("a2는 1이거나 2입니다")
        3, 4 -> println("a2는 3이거나 4입니다")
        5, 6 -> println("a2는 5이거나 6입니다")
        else -> println("a2는 1, 2, 3, 4, 5, 6이 아닙니다")
    } // (,) 컴마로 구분하여 두가지의 경우를 하나의 case 로 처리 가능합니다


    val a5 = 5
    when(a5){
        in 1..3 -> println("a5는 1 ~ 3사이의 숫자입니다")
        in 4..6 -> println("a5는 4 ~ 6사이의 숫자입니다")
        in 6..9 -> println("a5는 6 ~ 9사이의 숫자입니다")
        else -> println("a5는 1 ~ 9사이의 숫자가 아닙니다")
    } // in 키워드와 .. 연산자를 이용하여 범위를 골라내는 case 를 제작할 수 있습니다.

    val a6=20
    val str:String = when(a6){
        10->"10입니다"
        20->"20입니다"
        30->"30입니다"
        else -> "10~30 이 아닙니다"
    }// 각 케이스에서 선택된 값을 결과로 반환하여 변수의 값으로 활용할 수 있습니다.
    println("str : $str")

}
// when 의 선택을 함수의 리턴값으로 사용할수 있습니다
fun selectValue(a1:Int) = when(a1){
    10->"10입니다"
    20->"20입니다"
    30->"30입니다"
    else -> "10~30 이 아닙니다"
}
/*
fun selectValue(a1:Int) : String {
    val str:String = when(a1){
        10->"10입니다"
        20->"20입니다"
        30->"30입니다"
        else -> "10~30 이 아닙니다"
    }
    return str;
}*/