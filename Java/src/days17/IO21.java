package days17;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class CalculatorResult implements Serializable{
	private int leftValue;
	private int rightValue;
	private String operator;
	private double result;
	
	public CalculatorResult(int leftValue, int rightValue, String operator, double result) {
		super();
		this.leftValue = leftValue;
		this.rightValue = rightValue;
		this.operator = operator;
		this.result = result;
	}
	
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		return this.leftValue + this.operator	+ this.rightValue + "=" + df.format(this.result);
	}// 왼쪽값 연산자 오른쪽값 = 결과값 을 String 으로 리턴합니다(소수점 두자리까지 표시)
	
}

public class IO21 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		// 특정 날짜를 String으로 입력 받아서 그날짜 파일만 출력합니다
		// 날짜 입력 양식을 정해서 잘못된 입력은 다시 입력 받게 설정합니다
		
		String inputDate;
		Date iDate;
		
		// 입력받은 날짜를 파일형식으로 변환하고 그 이름으로 파일을 검색
		BufferedReader in 	= new BufferedReader(	new InputStreamReader(System.in));
		SimpleDateFormat sdf1 =new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.print("날짭 입력(2023-03-24) : ");
		while(true) {
			try {
				inputDate = in.readLine();
				if( inputDate.length() != 10 ) throw new Exception();
				iDate = sdf1.parse( inputDate );
				break;
			} catch (ParseException e) {
				System.out.print("입력 오류 - 입려예를 확인하세요 (2023-03-24) : ");
			} catch (Exception e) {
				System.out.print("입력 오류 - 입려예를 확인하세요 (2023-03-24) : ");
			}
		}
		// System.out.println( sdf1.format( iDate ) );
		SimpleDateFormat sdf2 =new SimpleDateFormat("yyyy_MM_dd");
		
		// 읽어올 파일 경로 설정
		File dir = new File("D:\\JAVA01\\Java_se\\temp");
		// dir 에 설정된 경로에 있는 모든 파일의 목록 가져옵니다
		String [] f = dir.list();
		// for( String s : f) System.out.println(s);
		
		for(int i=0; i<f.length; i++) {
			// f[i] : 파일이름
			if( f[i].length() < 10 ) continue;  // 파일이름이 10글자 이내이면 다음 파일로
			// 앞으로 사용할 메서드가   f[i].substring(0,10); 인데,  
			// f[i]에 있는  String 글자갯수가 10개가 안되면 에러입니다.
			// 10글자이상 파일이름을 선별하여 실행합니다.
			
			// 현재 반복 실행 중인 파일이름의 날짜에 해당하는 앞 10글자를 추출
			String s1 = f[i].substring(0, 10);
			// 입력받은 날짜는  2022-10-25  ->  2022_10_25  날짜 형식 변환 
			// 그리고 "" 를 이어붙이해서 String 으로 변환
			String s2 = sdf2.format(iDate) + "";
			
			if( s1.equals(s2) ) {
				File file = new File( dir, f[i] );
				ObjectInputStream ois 
				= new ObjectInputStream( new BufferedInputStream( new FileInputStream(file) ) );
				ArrayList<CalculatorResult> list = (ArrayList<CalculatorResult>)ois.readObject();
				int k=1;
				System.out.println(f[i]); // 파일이름 먼저 출력
				for(CalculatorResult c : list ) {  // 읽어온 리스트 내용을 차례로 하나씩 출력
					System.out.println(k++ + ". "+  c);
				}
				ois.close();
				System.out.println();
			}
			
		}

	}

}














