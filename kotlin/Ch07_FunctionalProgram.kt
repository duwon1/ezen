fun main(){
    // 1. 일반적으로 만들어진 함수의 호출과 결과 리턴
    val r1 = testFun1(100, 200)
    println("r1 : $r1")

    //2. 리턴될 값을 계산하는 수식으로 함수의 몸체를 대신한 함수를 호출
    val r2 = testFun2(100, 200)
    println("r2 : $r2")
    val r3 = testFun3(300, 400)
    println("r3 : $r3")


    println("-----------------------------------------------")
    // 람다 함수 : 함수의 초간단 간략형 표현으로 , 함수의 몸체를 변수에 담아 사용하도록 변형한 형태 입니다
    // 표현방식 #1
    val  lamFunction1 : ( Int, Int ) -> Int = { a1:Int, a2:Int -> a1+a2 }
    // ( Int, Int ) -> Int  전체적인 자료형과 형태 -
    // 괄호안의 자료형은 매개변수의 갯수와 자료형, -> 옆의 자료형은 리턴값이 자료형
    // { a1:Int, a2:Int -> a1+a2 }  앞에 정의된 자료형에 맞춰 사용되는 실제 매개변수와 연산식 & 리턴값
    // 지역변수에 담긴 함수이기 때문에 main 안에서 생성하고 사용합니다
    val r4 = lamFunction1(100, 200);
    println("r4 : $r4")

    // 표현방식 #2
    val lamFunction2 = { a1:Int, a2:Int -> a1+a2 }  // 매개변수, 리턴값의 자료형이 명확하다면
    // ':' 이후부터 '=' 이전 까지 생략 가능합니다
    val r5 = lamFunction2(100, 200)
    println("r5 : $r5")

    // 표현방식 #3
    val lamFunction3 : (Int, Int) -> Int = {a1, a2 -> a1 + a2}  // 함수 몸체쪽 자료형 생략도 가능합니다
    val r6 = lamFunction3(100, 200)
    println("r6 : $r6")

    // 표현방식 #4
    // 리턴값이 단순 연산식이 아니라 다른 명령들과 함께 실행되어야 할때
    val lamFunction4 = { a1:Int, a2:Int ->
        val r1 = a1 + a2
        val r2 = a1 - a2
        r1 * r2
    }
    val r8 = lamFunction4(100, 200)
    println("r8 : $r8")

}


// 함수의 몸체에 여러 명령이 필요한경우 원래의 함수 형태 생성
/*
fun testFun4(a1:Int, a2:Int):Int{
    val r1 = a1 + a2
    val r2 = a1 - a2
    val r3 = r1 * r2
    return r3
}*/


// 2. 함수의 리턴값이   단순변수의 값 or 단수연산의 결과  라면  함수의 몸체대신 리턴값을 연결해서  생성합니다
// k=>k+10   (a1, a2)=>{return a1+a2 }      (a1, a2)=>a1+a2    nodejs 에서 생성한 예
fun testFun2( a1:Int, a2:Int) : Int = a1+a2
// 함수의 몸체 대신 a1+a2 결과를 리턴하는 것으로 대신한  예입니다
fun testFun3(a1:Int, a2:Int) = a1 + a2
// 함수의 리턴값 자료형이   분명하게 정수로 예측된다면   리턴값 자료형(:Int)을 생략 가능합니다

// 1. 일반적인 함수의 생성
fun testFun1(a1:Int, a2:Int) : Int {
    return a1 + a2
}