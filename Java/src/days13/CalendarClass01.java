package days13;

import java.util.Calendar;

public class CalendarClass01 {

	public static void main(String[] args) {
//		싱글톤 방식의 클래스
//		생성자가 private으로 접근 차단됨(외부에서 접근 금지.->외부에서 new Calendar()사용 안됨)
//		유일하게 실행된 new Calendar()는 클래스 내부에서 실행되어 클래스내부에 단하나만 존재함
//		그리고 그 레퍼런스 변수가 갖고 있는 주소를 리턴하는 public static 형태의 getInstance메서드로
//		인스턴스 주소를 리턴받아씀
//		이후 다시 getInstance()메서드가 실행되도 현재 Heap에 이미 있는 인스턴스의 주소가 리턴됨
		Calendar tomorrow = Calendar.getInstance(); //특별히 날짜지정을 하지 않으면 현재날짜는 오늘날짜
//		공유된 인스턴스에서 현재날짜에 관한 정보만 객체끼리 서로 다른 날짜를 따로 관리하고 많은 내용이 공유됨
		
//		Calendar 클래스에는 static final멤버변수가 다수 있음
		System.out.println("년도 상수 : "+Calendar.YEAR);
		System.out.println("월 상수 : "+Calendar.MONTH);
		System.out.println("일 상수 : "+Calendar.DATE);
		System.out.println("현재 연도 내 주 상수 : "+Calendar.WEEK_OF_YEAR);
		
//		위의 static final이 사용되는 예
		Calendar today = Calendar.getInstance(); //특별히 날짜지정을 하지 않으면 현재날짜는 오늘날짜
		System.out.println("today 객체의 연도 : "+today.get(1));
		System.out.println("today 객체의 연도 : "+today.get(Calendar.YEAR));
//		.get(): 전달인수의 정수가 무엇이냐에 따라 날짜 정보 중 필요한 정보를 추출해내는 메서드
//		1을 전달하면 연도 추출
//		String으로 만든 날짜 : "2022-10-17"
//		Date또는 Calendar로 만든 날짜 : 2022-10-17
//		String 데이터에서 2022를 추출하려면 substring 사용-> 결과 String"2022"
//		Calendar에서 2022를 추출하려면 get 사용 ->결과 int
		
		int i = today.get(Calendar.MONTH);
		System.out.println("월 : (0~11) : "+i+"월");
//		MONTH 로 얻어낸 월의 값은 1월이 0, 2월이 1,... 12월이 11로 얻어짐
		System.out.println("월 : (1~12) : "+(i+1)+"월");
		
		i=today.get(Calendar.DATE);
		System.out.println("일 :"+i);
		
//		1.일요일, 2.월요일, 3.화요일...
		i=today.get(Calendar.DAY_OF_WEEK);
		System.out.println("요일(1~7, 1:일요일) : "+i);
		i=today.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		System.out.println("이 달의 몇 째 요일 : "+i);
		
		System.out.println("이 달의 말일 : "+today.getActualMaximum(Calendar.DATE));
		i=today.get(Calendar.WEEK_OF_YEAR);
		System.out.println("금년의 몇째주 : "+i);
		i=today.get(Calendar.WEEK_OF_MONTH);
		System.out.println("현재 달의 몇 째 주 : "+i);
		i=today.get(Calendar.DAY_OF_YEAR);
		System.out.println("현재 년도의 몇 일 : "+i);
		
		System.out.println("오전_오후(0:오전, 1: 오후):"+today.get(Calendar.AM_PM));
		System.out.println("시간(0~11) : "+today.get(Calendar.HOUR));
		System.out.println("시간(0~23):" +today.get(Calendar.HOUR_OF_DAY));
		System.out.println("분(0~59) : "+today.get(Calendar.MINUTE));
		System.out.println("초(0~59) : "+today.get(Calendar.SECOND));
		System.out.println("1000분의 1초(0~999) : "+today.get(Calendar.MILLISECOND));
//		프로그램이 시작되어  Calendar 인스턴스가 만들어진 시점
//		시:분:초:1/1000초

	}

}
