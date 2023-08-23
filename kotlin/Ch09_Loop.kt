fun main(){
    // 반복실행문
    // var  a1:IntRange = 1..10
    var a1 = 1 .. 10
    println(a1);

    // 코틀린의 for 문은 자바에서 처럼 시작 값 끝값 증감량 등을 사용하지 않고, 범위데이터만 사용합니다
    for( i in a1){
        // a1 변수에 있는 범위데이터의 값들이 i 변수에 각각 한번씩 저장되면서 반복실행이 진행됩니다
        print("$i\t")
    }

    println("\n------------------------------------")
    val a2 = 1..10 step 2   // 2씩 증가하는 범위 데이터
    for(i in a2){
        print("$i\t")
    }

    println("\n------------------------------------")
    // 10 부터 1까지 줄어드는 범위데이터 사용
    // val a3 = 10..1
    val a3 = 10 downTo 1
    for(i in a3){
        print("$i\t")
    }

    println("\n------------------------------------")
    var a4=10 downTo 1 step 2
    for(i in a4){
        print("$i\t")
    }


    println("\n------------------------------------")
    var a5=0
    while(a5<10){
        print("$a5\t")
        a5++
    }
    println("\n------------------------------------")
    var a6 = 0
    do {
        print("$a6\t")
        a6++
    }while(a6 < 10)

}