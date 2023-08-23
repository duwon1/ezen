package days13;

import java.util.Calendar;

public class CalendarClass02 {

	static String [] weekday= {"","일", "월", "화", "수","목","금","토"};
	public static void main(String[] args) {

		
		Calendar date1=Calendar.getInstance();
		Calendar date2=Calendar.getInstance();
				
		//date1 달력 객체의 오늘 날짜를 2015년 8월 15일로 설정
		date1.set(2015,7,15);
		//set: 원하는 특정날짜로 객체 내 날짜구성을 재설정,  date2는 아직 오늘 날짜
		
		//set 메서드에 필드명과 값을 넣어주면 해당 필드값만 변경됨
		date2.set(Calendar.MONTH, 6);//->월만 7월로 바뀜
		
		//위 date1과 date2에 설정된 날짜를 "0000년 0월 0일 0요일" 형식으로 출력하기
		//System.out.println()안에 한번에 구성해서 출력하기
		
//		int y=date1.get(Calendar.YEAR);
//		int m=date1.get(Calendar.MONTH);
//		int d=date1.get(Calendar.DATE);
//		int i= date1.get(Calendar.DAY_OF_WEEK);
		//이럴필요가 없음 밑에처럼 하면 됨
		
//		System.out.println(date1.get(Calendar.YEAR)+"년 "
//		+(date1.get(Calendar.MONTH)+1)+"월 "
//				+date1.get(Calendar.DATE)+"일" 
//				+weekday[date1.get(Calendar.DAY_OF_WEEK)]+"요일");
//		
//		System.out.println(date2.get(Calendar.YEAR)+"년 "
//						+(date2.get(Calendar.MONTH)+1)+"월 "
//						+date2.get(Calendar.DATE)+"일" 
//						+weekday[date2.get(Calendar.DAY_OF_WEEK)]+"요일"));
						
		}
	public static void prnDate(Calendar c) {
		System.out.println(c.get(Calendar.YEAR)+"년"
				+(c.get(Calendar.MONTH)+1)+"월"
				+c.get(Calendar.DATE)+"일"
				+weekday[c.get(Calendar.DAY_OF_WEEK)]+"요일");
	}
}
