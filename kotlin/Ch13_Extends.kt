fun main(){
    val s1 = SubClass1()  // 자식 클래스의 객체 생성
    println("s1.subMember1 : ${s1.subMember1}")
    s1.subMember1()
    println("s1.superMember1 : ${s1.superMember1}")
    s1.superMethod1()
}
// 코틀린에서 정의하는 모든 클래스는 별도의 언급이 없으면 모두 final 로 생성됩니다. 이는 상속불가상태
// 상속 가능 상태로 만들려면,  키워드 open 을 앞에 붙여줍니다
open class SuperClass1{
    var superMember1 = 100
    fun superMethod1(){
        println("SuperClass1의 메서드 입니다")
    }
}
// 상속은 extends 카워드 없이 부모 클래스 이름을 ':' , '()' 와 함께 클래스 옆에 써줍니다
class SubClass1 : SuperClass1() {
    var subMember1 = 200
    fun subMember1(){
        println("SubClass1의 메서드 입니다")
    }
}


// 부모클래스 생성시 대표(기본)생성자가 있다면
open class SuperClass2 constructor(val a1:Int){

}
// 대표생성자가 있는 클래스를 상속한다면 반드시 부모클래스 이름옆에 괄호에 대표생성자 형태의
// 매개변수를 넣어줍니다
class SubClass2:SuperClass2( 100 ){ }

// 자식 클래스의 생성자가 따로 기술되아야 한다면 아래와 같이 표현 합니다.
class SubClass3 : SuperClass2{
    constructor() : super(100) {
    }
}

// 상속을 받는 자식 생성자에 대표생성자가 있다면
class SubClass4 (var a4:Int) : SuperClass2(100){

}