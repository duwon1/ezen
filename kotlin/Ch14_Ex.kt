fun main(){
    print("연도 입력 : ")
    val year:Int = readLine()!!.toInt()
    print("월 입력 : ")
    val month:Int = readLine()!!.toInt()
    //print("일 입력 : ")
    //val day:Int = readLine()!!.toInt()

    // 년 월  을 입력 받아  해당월의 달력을 출력하는 프로그래미을 작성하세요
    var days:Int = calDays(year, month, 1)
    val temp:Int = days % 7;

    printCalendar( year, month, temp );
}

fun printCalendar(year: Int, month: Int, temp: Int) {
    var mdays = arrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31) // 배열생성
    println("$year 년  $month 월");
    println("-------------------------------------------------");
    println("일\t월\t화\t수\t목\t금\t토")
    println("-------------------------------------------------");
    var blank = 0;
    while(blank<temp){
        print("\t");
        blank++;
    }
    var prnNum=1
    while( prnNum <= mdays[month] ){
        print("$prnNum\t");
        prnNum++; blank++;
        if(blank%7==0)println();
    }
}

fun calDays(year: Int, month: Int, i: Int): Int {
    var days:Int = 0
    var mdays = arrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31) // 배열생성
    if( (year%4==0) && (year%100!=0) || (year%400==0))
        mdays[2] = 29;

    days = 365*(year-1);
    val yearRange:IntRange = 1..(year-1)
    for(i in yearRange){
        if( (i%4==0) && (i%100!=0) || (i%400==0))
            days++;
    }

    val monthRange = 1..(month-1)
    for(i in monthRange){
        days += mdays[i];
    }

    days+=1;
    return days;
}

