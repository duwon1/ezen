fun main(){
    val obj1 = TestClass11()
    val obj2 = TestClass12()
    println("obj2 : $obj2")
    println("obj2.v1 : ${obj2.v1}")
    println("obj2.v2 : ${obj2.v2}")

    val obj3 = TestClass12(100, 200)
    println("obj3 : $obj3")
    println("obj3.v1 : ${obj3.v1}")
    println("obj3.v2 : ${obj3.v2}")
    println("-----------------------------------")

    val obj4 = TestClass13(100, 200)  // 생성자에 전달된 100, 200은 멤버변수 a1, a2에 저장됩니다.
    println("obj4.a1 : ${obj4.a1}")
    println("obj4.a2 : ${obj4.a2}")
    // val obj5 = TestClass13()  // 에러 : 매개변수 두개있는 생성가자 디폴트생성자를 대체하고
    // 별도로 디폴트 생성자를 오버로딩 하지 않았으므로 이는 에러

    println("-----------------------------------")
    val obj6 = TestClass15(100, 200)
    println("obj6.a1 : ${obj6.a1}")
    println("obj6.a2 : ${obj6.a2}")
    println("-------------------------")
    val obj7 = TestClass15(300)
    println("obj7.a1 : ${obj7.a1}")
    println("obj7.a2 : ${obj7.a2}")
}
// 클래스 이름 옆에 생성자를 만들고 나서,  오버로딩된 생성자를 사용하고 싶을때
class  TestClass15 (var a1:Int, val a2:Int){

    constructor(a1:Int) : this(a1,  100) {
        println("보조 생성자 호출")
    }
    // 보조 생성자의 생성 : 현재 클래스는 디폴트 생성자가 매개변수 두개가 있는 생성자로 대체된
    // 된 상태이므로 매개변수가 없거나 하나만 있는 생성자를 만들고 호출한다면, 반드시 대채된
    // 디폴트 생성자를 재호출하여야 에러가 없습니다.
    // 보조생성자에서 디폴트 생성자를 재호출 하는 방법은 Constructor() 옆에
    // : this(디폴트생성자에 맞는 전달인수)  형태로 호출합니다/
    // 클래스 이름 옆에 생성자는 멤버변수를 포함하고 있기때문에 그를 호출하지 않으면 객체생성시
    // 멤버변수가 만들어지지 않는다는 말과 같습니다. 따라서 반드시  this 호출이 필요합니다.
}


// 매개변수가 있는 생성자 생성 및 매개변수 를 멤버변수로 생성
class TestClass13 constructor( var a1:Int, val a2:Int ){
    // 보통 함수의 매개변수는 val, var 을 붙이지 않지만,  대표생성자에 쓰여지는 매개변수는 멤버변수로도 사용이 될
    // 예정이므로, var 또는 val 을 붙여서 사용합니다.
    // 매개변수에 전달되는 전달인수의 값이 멤버변수의 초기값이 됩니다.

}
// 생성자에 선언된 매개변수가 var 과  val 에 의해
// 멤버변수로 만들어집니다. 또한 전달된 전달인수가 생성된 멤버변수 a1, a2 에 저장됩니다.
// 매개변수를 멤버변수로 만들어주는 역할은 순전히 var 과 val 이 해주는 일입니다.
// 위 코드는 매개변수가 없는 디폴트 생성자를 대채하는 생성자로서, 매개변수 없는 생성자는
// 현재 클래스에서 없다고 생각해야 합니다

// 위 생성자의 모습은 이렇게도 바꿔서 쓸수 있습니다. constructor 키워드의 생략
// class TestClass13 (var a1:Int, val a2:Int) { }

// 클래스 생성시 매개변수가 없는 생성자는 이미 존재하기때문에 아래와 같은 표현은 따로 쓰지 않습니다
// class TestClass14 constructor() { }









// 생성자의 사용
class TestClass12{
    var v1:Int = 0
    var v2:Int = 0
    // 생성자를 만듭니다.
    // 생성자를 만들지 않으면 내부에 존재하는 디폴트 생성자가 사용되지만
    // 아래와 같이 인위적으로 꺼내서 따로 기술할 수 있습니다
    // 코틀린 클래스의 생성자의 이름은 Constructor 입니다
    constructor(){
        println("매개 변수가 없는 생성자")
    }
    constructor(a1:Int, a2:Int){
        println("매개 변수가 두 개인 생성자")
        v1 = a1
        v2 = a2
    }
}

// Kotlin은 클래스에 init 코드 블록을 만들어 주면 객체 생성시 자동으로 처리되는 코드를
// 만들 수 있습니다. 멤버변수에 값을 초기화하는 기능도 가능합니다.
// init 블럭은 생성자와 비슷한 역할을 할수 있는 영역이지만 전달인수나 기타의 함수로서의 기능
// 은 없는 단순 블럭입니다.
// init 블럭은 멤버변수 초기화, 생성자는 그외 객체 생성시 해야할 일들이 실행됩니다.
class TestClass11{
    init{
        println("객체가 생성되면 자동으로 동작되는 부분입니다")
    }
}