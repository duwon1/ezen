fun main(){
    // 일반적인 함수의 생성과 호출
    testFunction1()

    // 아래의 동작->자바스크립트에서 가능했던 함수의 직접 변수 저장은 불가능합니다
    // val testFunction2 = testFunction1;
    // 아래와 같이 익명함수 저장은 가능합니다
    val testFunction2 = fun(){
        println("testFunction2 입니다")
    }
    testFunction2()

    // 익명 함수가 변수에 저장이 가능하다는 뜻은  익명함수를   다른 함수 호출시에 전달인수로 전달해줄수 있다는 뜻입니다
    //  익명함수 생성
    val t1 = fun(x1:Int, x2:Int) : Int {
        return x1 + x2
    }
    // 람다함수의 정의     val t1 : (Int, Int)->Int = { a1:Int, a2:Int -> a1+a2 }
    // 익명함수를 전달인수로 전달 #1  - 익명함수를 변수에 저장해서 변수를 전달
    testFunc1( t1, 100, 200)
    val t11 = fun(x1:Int, x2:Int) : Int {
        return x1 * x2
    }
    testFunc1( t11, 100, 200)

    // 익명함수를 전달인수로 전달 #2  - 익명함수를 직접 전달인수로 전달
    testFunc1(   fun(x1:Int, x2:Int) : Int { return x1 - x2  }  , 100, 200)

    // 익명함수를 전달인수로 전달 #3  -  람다함수형태의 몸체를 전달
    // 익명함수가 아닌 람다함수 형태의 몸체를 전달인수로 전달할 수 있습니다
    // val t1 : (Int, Int)->Int = { a1:Int, a2:Int -> a1+a2 } 에서
    //   val t1 : (Int, Int)->Int    에     { a1:Int, a2:Int -> a1+a2 }  를 전달하는 형태
    testFunc1( {x1:Int, x2:Int -> x1 / x2} ,200, 100)

    val t2 = testFunc2()  // 함수를 리턴받아 t2에 저장
    val r2 = t2(500, 800)  // t2 이름으로 함수 호출 -> 결과 리턴 r2 에 저장
    println("r2 : $r2")

    val t3 = testFunc3();
    val r3 = t3(100, 200);
    println("r3 : $r3");
    
    // 활용 분야 : 같은 형태의 전달인수와 다른 기능의 함수를 전달해서 각각의 기능이 실행되결과를 얻을수 있습니다
}

fun testFunc3() : (Int, Int) -> Int {
    return {x1:Int, x2:Int -> x1 - x2}  // 람다함수가 리턴값으로 사용
}

fun testFunc2() : (Int, Int) -> Int {
    // 실제 리턴값은 익명수의 몸체 또는 람다함수의 몸체를 리턴합니다.
    return  fun(x1:Int, x2:Int) : Int { return x1 * x2  }
}


// 함수를 매개변수로 받아서    그 변수이름로 함수를 호출하는 예
// 매개변수는 아래와 같이 전달되는 함수의 형태를 파악하여 그 형태를 온전히 받아 줄수 있는 람다함수의 선언부로 정의합니다
fun testFunc1(     lam1 : (Int, Int) -> Int       , a1:Int, a2:Int ){
    val r1 = lam1( a1, a2 );
    println("r1 : $r1")
}



// 일반적인 함수의 생성과 호출
fun testFunction1() {
    println("testFunction1 입니다")
}