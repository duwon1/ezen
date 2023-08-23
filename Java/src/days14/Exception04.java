package days14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exception04 {

	public static void main(String[] args) {
		//메서드 자체에 예외처리 요청 기능이 내포되어 있어서 메서드 호출 시 예외처리를 요구함
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String k = "2022.10.19";
		
		try {
			Date d = sdf.parse(k);
			System.out.println(d);
		} catch (ParseException e) {
			System.out.println(k+" : String 데이터의 날짜양식을 확인하세요");
			e.printStackTrace();
		}
	}

}
