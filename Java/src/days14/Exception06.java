package days14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Exception06 {

	public static void main(String[] args) {
		
		Date inDate = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Scanner sc= new Scanner(System.in);
		System.out.print("날짜를 예와 같이 입력해주세요. (입력 예:2015-12-31) : ");
		
	while(true) {	
		try {
			
			String strDate = sc.nextLine();
			inDate = sdf.parse(strDate);
			break; //자기 자신을 감싼 반복실행문 또는 switch문을 벗어남. try{}는 해당되지 않음
		} catch (ParseException e) {
			//입력 날짜 양식이 "yyyy-MM-dd"가 아니라면 처리될 영역
			System.out.println("날짜 양식이 틀렸습니다. 양식대로 다시 입력하세요 : ");
		}
	}
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일");
	System.out.println("입력한 날짜는 "+sdf2.format(inDate));
	}
}
