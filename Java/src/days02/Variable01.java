package days02;

public class Variable01 {

	public static void main(String[] args) {
		
		// 변수(Variable) : 프로그램 실행 중 발생 또는 입력되는 데이터를 저정할 목적으로 만든 임시 저장장소
		// 프로그램 생성명령 실행 시 생성되고, 프로그램 종료시 소멸된다.
		
		// 35+38 = 73
		System.out.println(35 + "+" +38 +"=" +(35+38));
		System.out.println(35 + "-" +38 +"=" +(35-38));
		System.out.println(35 + "*" +38 +"=" +(35*38));
		System.out.println(35 + "/" +38 +"=" +(35/38));
		
		int a; //a라는 이름의 변수 생성(정수)
		int b;
		// int : 정수형 자료 하나를 저장을 공간을 생성하는 명령
		// a : 생성된 변수의 이름을 프로그램내에서 a라고 부르기 위해 지은 이름
		int plusResult, minusResult, multiplyResult; //한번에 여러변수 생성
		double divideResult; //divideResult 라는 이름의 변수 생성(실수)
		
		
//		변수의 이름을 만드는 규칙
//		1. 인터넷 사이트의 회원가입 시 만드는 아이디 이름 규칙과 비슷
//		2. 영문과 숫자, 그리고 일부 특수문자(_)를 섞어서 사용가능하지만 첫글자는 반드시 영문 사용
//		3. 중간에 공백 불가
//		4. 너무 짧지 않게 의미 부여하기
//		5. 두가지 단어가 조합되면 첫단어는 소문자로, 두번째 단어 첫글자는 대문자로 시작
//		예시)plusResult
//		6. 변수는 자료형(정수, 실수, 문자)에 따라 만드는 명령이 달라짐
//		int: 정수, double : 실수, String : 문자
		
		a = 10; // a에는 이제 10이 보관됨. 다른 값이 a변수에 다시 저장되거나 프로그램이 끝날 때까지 저장.
		
//		b = 10.123; // double->int로 데이터 손실 유발해 에러
		divideResult = 100; // int->double은 ㄱㅊ
		
		boolean b1; // true or false 자료형
		b1 = true;
		
		System.out.printf("변수 b1의 값 : %b\n", b1);
		System.out.println("변수 b1의 값 : " + b1);
		//boolean 자료를 printf로 출력할 때 %b 사용
		
//		int - 정수형 자료형 4byte 
//		long - 정수형 자료형 8byte
//		float - 실수형 자료형 4byte
//		double - 실수형 자료형 8byte
//		char - 문자 자료형 '', 2byte
//		String- 문자열 자료형 "", 글자갯수 제한 없이 저장할 수 있음/사실 자료형보다는 클래스(객체)라고 부르는 게 더 정확함 
		
//		저장용량 단위 - 1과 0 중 하나를 저장할 수 있는 단위 1 bit
//		8bit= 1 byte - 256개의 정보(2의 8제곱) 0~255까지 저장
//		예전 시스템의 int - 2byte ( -32768~ 32767)
//		현재 시스템의 int - 4byte (-2147483648~2147483647)
		
//		double - 8byte 0.00002 -> 0.2 x 10의 -4제곱 -> 변수에 2와 -4를 값과 지수로 저장
		
		char c;
		c = 'A';
				System.out.printf("변수 c의 값 : %c\n", c);
				System.out.println("변수 c의 값 : " + c);
		
		String s;
		s = "ABVCD";
				System.out.printf("변수 s의 값 : %s\n", s);
				System.out.println("변수 s의 값 : " +s);
				
		a = 16;
		b = 52;
		c = '+';  //변수에 값을 보관
		
		plusResult = a + b;	//변수를 이용해서 연산을 하고, 결과를 또 다른 변수에 저장
		System.out.printf("%d %c %d = %d\n", a, c, b, plusResult);
		
		c = '-'; // 새로운 값을 다시 넣으면 이전값 사라지고 새로운 값 보관됨
		minusResult = a - b;
		System.out.printf("%d %c %d = %d\n", a, c, b, minusResult);
		c = 'x'; 
		multiplyResult = a * b;
		System.out.printf("%d %c %d = %d\n", a, c, b, multiplyResult);
		c = '÷'; 
		divideResult = a / (double)b; //b는 정수형인데 실수형으로 바꾸고 싶을 때 잠깐 사용
		System.out.printf("%d %c %d = %.2f\n", a, c, b, divideResult); //안떨어지는 나눗셈이라 f를 넣어야함
		//피연산자 둘 중 하나만 실수이면 연산의 결과는 실수가 됨
		//(double) : 현재 위치에서 잠시 double로 변환. 이 명령이 지나면 다시 int형이 됨
		a = 16;
		b = 52;
		c = '+';	
		System.out.println(a+""+c+""+b+"="+plusResult);
		// 변수 사이에 "" 안넣으면 그냥 다 합쳐짐
		c = '-';
		minusResult = a - b;
		System.out.println(a+""+c+""+b+"="+minusResult);
		c = '*';
		multiplyResult = a * b;
		System.out.println(a+""+c+""+b+"="+multiplyResult);
		c = '÷';
		divideResult = a / (double)b; //b는 정수형인데 실수형으로 바꾸고 싶을 때 잠깐 사용
		System.out.println(a+""+c+""+b+"="+divideResult);
		System.out.println(a+""+c+""+b+"="+(int)(divideResult*100)/100.0);
		
//		64.666666666 원하는 소수점 자리까지 만들기
//		64.666666666 * 100 -> 6466.6666666
//		(int)6466.666666 -> 6466
//		6466/100 ->64.66
//		이걸 한 줄로 줄이면
//		 (int)(64.66666666 * 100)/ 100.0;
//		(int)(divideResult * 100)/ 100.0;
		
	
		
		
	}

}
