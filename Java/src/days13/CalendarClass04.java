package days13;

import java.util.Calendar;

public class CalendarClass04 {

	public static String dateToString(Calendar c) {
		String cDate=c.get(Calendar.YEAR)+"Y "
				+(c.get(Calendar.MONTH)+1)+"M "
				+c.get(Calendar.DATE)+"D";
		return cDate;
	}
	public static void main(String[] args) {

		Calendar date = Calendar.getInstance();
		System.out.println(dateToString(date));
		
		System.out.println("=1일 후=");
		date.add(Calendar.DATE, 1);
		System.out.println(dateToString(date));
		
		System.out.println("=3개월 전=");
		date.add(Calendar.MONTH, -3);
		System.out.println(dateToString(date));
		
//		add 메서드의 증감은 하나의 요소를 변경하지만, 그로 인해 다른 필드에 영향을 줄 수 있음
//		일을 변경해 달이 바뀌거나 월을 변경해 년도가 바뀌는 변경 등
//		음수를 입력하면 이전날짜 또는 월, 년으로 설정 가능

		System.out.println("=30일 후=");
		date.add(Calendar.DATE, 30);
		System.out.println(dateToString(date));
		
		System.out.println("=40일 후=");
		date.roll(Calendar.DATE, 40);
//		다른 필드에 영향을 주지 않고 해당 필드만으로 더하고 빼는 메서드
//		1월 21일에서 30일 더하면 2월 31일(30일)이 되고, 이후 10일이 더해져
//		다시 31이 나옴. 월에는 영향을 주지 않음 결과 1월 10일
		System.out.printf(dateToString(date));
	}
}
