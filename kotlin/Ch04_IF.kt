fun main(){
    val a1: Int = 10
    if (a1 == 10) println("a1은 10입니다.")

    if (a1 == 10) println("a1은 10입니다")
    else println("a1은 10이 아닙니다")

    if (a1 == 5) println("a1은 5입니다")
    else if (a1 == 10) println("a1은 10입니다")
    else println("a1은 5, 10, 20이 아닙니다")

    // Kotlin 과  java 가 달라지는 점

    //var str:String;
    // str = (a1==10)? "10입니다" : "10이 아닙니다 "
    var a4:String = ""
    val a5:Int = 10

    if(a5 == 10)  a4 = "10 입니다"
    else a4 = "10이 아닙니다"

    println("a4 : $a4")

    val a6:String =  if(a5 == 10) "10입니다" else "10이 아닙니다"
    println("a6 : $a6")



    val a7:String =
    if(a5 == 10){
        println("블록 1 수행")
        "10입니다"
    } else {
        println("블록 2 수행")
        "10이 아닙니다"
    }
    println("a7 : $a7")

}