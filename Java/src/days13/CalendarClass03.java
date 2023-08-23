package days13;

import java.util.Calendar;

public class CalendarClass03 {

	public static void main(String[] args) {

		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();
		
		time1.set(Calendar.HOUR_OF_DAY, 10);
		time1.set(Calendar.MINUTE, 20);
		time1.set(Calendar.SECOND, 30);
		
		time2.set(Calendar.HOUR_OF_DAY, 11);
		time2.set(Calendar.MINUTE, 30);
		time2.set(Calendar.SECOND, 10);
		
		printTime(time1);
		printTime(time2);
		//00시 00분 00.000초
		
		System.out.println(time1.getTimeInMillis());
		//밀리초-초-분-시-날짜 모두 밀리초로 변경
		System.out.println(time2.getTimeInMillis());
		
		long dif=(time2.getTimeInMillis()-time1.getTimeInMillis());
		System.out.println("time1과 time2의 차이는 "+dif+"밀리초입니다");
		System.out.println("time1과 time2의 차이는 "+(dif/1000)+"초입니다");
		
	}
	
	public static void printTime(Calendar c) {
		System.out.println("time :"
				+c.get(Calendar.HOUR_OF_DAY)+"H "
				+c.get(Calendar.MINUTE)+"M "
				+c.get(Calendar.SECOND)+"."
				+c.get(Calendar.MILLISECOND)+"S"); //시,분,초는 정해졌지만 밀리는 계속 바뀜
	}
}
