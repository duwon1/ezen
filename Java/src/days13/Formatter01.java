package days13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Formatter01 {

	public static void main(String[] args) throws ParseException {

		//날짜 데이터 클래스, Calendar 와는 다름
		Date today = new Date(); //java.util.Date
		System.out.println(today);
		
		//날짜 서식 클래스
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd"); //전달인수로 서식제공
		//날짜 데이터를 서식 데이터에 맞춰서 적용 후 출력
		System.out.println(sdf1.format(today));
		
		//날짜 서식 레퍼런스 변수들
		SimpleDateFormat sdf2,sdf3,sdf4,sdf5,sdf6,sdf7,sdf8,sdf9;
		sdf2=new SimpleDateFormat("yy년 MM월 dd일 E요일");
		sdf3=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdf4=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		//today 적용 후 출력
		System.out.println(sdf2.format(today));
		System.out.println(sdf3.format(today));
		System.out.println(sdf4.format(today));
		
//		y:년도 표시 자리수 문자(yyyy:2020, yy:20)
//		M: Month (MM:01~12 M:1~12)
//		d: Days(dd:01~31 d:1~31)
//		H: Hour(24H) (HH:01~23 H:1~23)
//		h: Hour(12H) (hh:01~12 h:1~12)
//		m: Minute //s: Second //S:Millisecond //a:am/pm
		
		sdf5=new SimpleDateFormat("오늘은 올 해의 D번째 날입니다.");
		sdf6=new SimpleDateFormat("오늘은 이 달의 d번째 날입니다.");
		sdf7=new SimpleDateFormat("오늘은 올 해의 w번째 날입니다.");
		sdf8=new SimpleDateFormat("오늘은 이 달의 W번째 날입니다.");
		sdf9=new SimpleDateFormat("오늘은 이 달의 F번째 E요일입니다.");
		
		System.out.println(sdf5.format(today));
		System.out.println(sdf6.format(today));
		System.out.println(sdf7.format(today));
		System.out.println(sdf8.format(today));
		System.out.println(sdf9.format(today));
		
		//Calendar 객체값을 Date 값으로 변환 후 SimpleDateFormat에 적용
		Calendar cal = Calendar.getInstance();
		Date day = cal.getTime();
		
		sdf1=new SimpleDateFormat("yyyy-MM-dd");
		sdf2=new SimpleDateFormat("yy-MM-dd E요일");
		sdf3=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdf4=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		
		System.out.println(sdf1.format(day)); //format(Date d)
		System.out.println(sdf2.format(day));
		System.out.println(sdf3.format(day));
		System.out.println(sdf4.format(day));
		
		//SimpleDateFormat 에는 String 데이터를 날짜 자료형으로 변경하는 메서드가 존재함
		//Date자료형을 String으로 변경- String.valueOf()를 쓰거나 날짜데이터 뒤에 +""
//		String strDate=sdf.format(day)+"";
//		String strDate=String.valueOf(sdf.format(day));
		
		// 반대로 String->Date
		String strDate = "2023-03-31";
		//적용한 String데이터에 날짜 양식에 맞춰서 SimpleDateFormat객체를 생성
		sdf1=new SimpleDateFormat("yyyy-MM-dd");
		// 그 양식에 String 데이터를 적용
		Date newDate= sdf1.parse(strDate);
		
		sdf2= new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println(sdf2.format(newDate));
		
	}

}
