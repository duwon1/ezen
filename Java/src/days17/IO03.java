package days17;

import java.io.IOException;

public class IO03 {

	public static void main(String[] args) throws IOException {
		
		// System.in 객체를 사용하여 더하기 연산을 수행하는 프로그램을 작성합니다
		// 첫번째 정수 : 123 , 두번째 정수 : 25   결과 : 123 + 25 = 148
		
		byte [] firstNumber = new byte[10];
		byte [] secondNumber = new byte[10];
		// 비열 자료형이  byte 라는건 한칸에 -128~127 까지 입력이 가능하나든 말인데
		// 우리는 System.in.read 로 읽어낸 내용을 저장할 예정이므로, 
		// 한칸 들어가는 값은 입력받은 문자의 아스키 코드들이 될 예정입니다
		
		System.out.print("첫번째 정수 : ");
		int size1 = System.in.read(firstNumber);
		System.out.print("두번째 정수 : ");
		int size2 = System.in.read(secondNumber);

		/*
		System.out.println("size1 : " + size1);
		for(int i=0; i<size1; i++) 
			System.out.printf("%c", (char)firstNumber[i]);
		System.out.println("size2 : " + size2);
		for(int i=0; i<size2; i++) 
			System.out.printf("%c", (char)secondNumber[i]);
		*/
		
		// | 6 | 7 | 5 | 1 | 2 |  - 입력된 글자
		// | 0 | 1 | 2 | 3 | 4 |  - 배열의 인덱스
		// firstNumber[4] * 1       firstNumber[3] * 10     firstNumber[2] * 100   firstNumber[1] * 1000
		// firstNumber[0] * 10000
		// 첨자는 4 3 2 1 0  순서로 진행, 곱해야 할 숫자는 1 10 100 1000 10000 순서로 진행되는 반복실행문을 사용
		// 글자수 5개, size는 7,  맨 마지막 다섯번째글자( 첨자로는 4번째) 부터 반복이 실행되려면  7(size)-3  부터 시작
		int m=1;
		int n1 = 0;
		for( int i= size1-3; i>=0; i--) {    // i는 글자갯수-3부터  0까지 
			n1 += (firstNumber[i] - '0' ) * m;   //  설정된 i변수를 첨자로 숫자와 m 을 곱합니다
			System.out.printf("firstNumber[%d]-%d \t", i ,  firstNumber[i]-'0'  );
			System.out.printf(" %d x %d => %d \t", firstNumber[i]-'0',  m ,  (firstNumber[i]-'0')*m );
			System.out.println(n1);
			m = m*10;  //  1부터 10씩 매반복마다 곱해집니다
		}
		System.out.println("최종 계산결과 : " + n1);
		
		m=1;
		int n2 = 0;
		for( int i= size2-3; i>=0; i--) {    // i는 글자갯수-3부터  0까지 
			n2 += (secondNumber[i] - '0' ) * m;   //  설정된 i변수를 첨자로 숫자와 m 을 곱합니다
			System.out.printf("secondNumber[%d]-%d \t", i ,  secondNumber[i]-'0'  );
			System.out.printf(" %d x %d => %d \t", secondNumber[i]-'0',  m ,  (secondNumber[i]-'0')*m );
			System.out.println(n2);
			m = m*10;  //  1부터 10씩 매반복마다 곱해집니다
		}
		System.out.println("최종 계산결과 : " + n2);
		
		System.out.println();
		System.out.printf("%d + ", n1);
		System.out.printf("%d = ", n2);
		System.out.println((n1+n2));
		
		
	}
}















