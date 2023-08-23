package days17;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// 사칙연산 프로그램
// 두개의 피연산자(정수)와  연산자(연산기호)를 입력 받아서 그 결과를 출력하는 프로그램
// 연산했던 기록을 두개의 정수와 하나의 연산기호를 저장할 수 있는 클래스 객체에 저장해서 파일에 저장
// 추후에 파일을 열어서 계산했던 기록을 열람할수 있게 합니다
// 파일은 날짜를 이용해서 이름을 만들고, 검색은 날짜를 입력해서 파일을 검색하고, 그날 계산했던 기록을 한번에 열람합니다



public class IO19 {

	public static void main(String[] args) throws IOException {
		
		//CalculatorResult temp = new CalculatorResult( 20 , 30 , "x" , 60000.0);
		//System.out.println(temp);
		
		// 입력받아서 계산하고 그 값들을 객체에 생성자를 통해 저장합니다.  
		// 그 저장된 내용의 객체는  ArrayList 에 저장합니다
		// 입력 및 계산 종료의사를 입력하면 ArrayList 는 오늘 날짜를 파일이름으로한 파일에 저장됩니다
		
		// 필요변수 선언
		int leftValue, rightValue;
		String operator;
		double result = 0.0;
		ArrayList<CalculatorResult> list = new ArrayList<>();
		char isExit;
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in) );
		do {
			// 좌항입력
			System.out.print("좌항을 입력하세요 : ");
			leftValue = Integer.parseInt( in.readLine() );
			// 우항입력 
			System.out.print("우항을 입력하세요 : ");
			rightValue = Integer.parseInt( in.readLine() );
			// 연산자 입력
			System.out.print("연산자를 입력하세요(+,-,x,/) : ");
			operator = in.readLine().trim();
			// 연산부호에 따른 연산
			switch(operator) {
				case "+": result = leftValue + rightValue; break;
				case "-": result = leftValue - rightValue; break;
				case "x": result = leftValue * rightValue; break;
				case "/": result = leftValue / (double)rightValue; break;
			}
			// 객체 생성
			CalculatorResult temp = new CalculatorResult(leftValue, rightValue, operator, result );
			// 객체를 리스트에 저장
			list.add(temp);
			// 객체 확인 출력
			System.out.println(temp);  
			
			System.out.print("계속하시겠습니까? (y/n) : ");
			isExit = in.readLine().trim().charAt(0);
		}while( isExit !='n' && isExit !='N' );
		in.close();	
		
		File dir = new File("D:\\JAVA01\\Java_se\\temp");
		if( !dir.exists() )dir.mkdirs();
		
		// 파일이름을 오늘 날짜 현재시간.dat 로 생성합니다. 파일이름예 : 2023_03_24_15_57.dat
		
		Date now = new Date(); // 오늘 날짜를 담은 Date  객체 생성
		// 파일이름이 될 양식으로 SimpleDateFormat 객체 생성
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy_MM_dd_HH_mm" );
		String fileName = sdf.format(now) + ".dat";  // 파일 이름 완성
		//모든 자료형은 String과 이어붙이기했을때 결과가 String 이 됩니다.
		
		File file = new File( dir, fileName);
		ObjectOutputStream oos 
			= new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		oos.writeObject( list );
		
		oos.close();		
	}

}







