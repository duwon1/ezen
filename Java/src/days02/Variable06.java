package days02;

public class Variable06 {

	public static void main(String[] args) {
		
		// 정수형 : byte(1), short(2), int(4-기본형) -21억~21억, long(8)
		// 실수형 : float(4), double(8 - 기본형)
		
		// 기본형이란 별도의 표시없이 쓰여지는 정수나 실수가 int 와 double로 인식되어 사용된다는 뜻
		// 100(int형), 100L(long 형)  123.123(double) 123.123F (float)
//		byte b= 1234;		//용량초과로 에러
//		float f = 123.12;		//에러
		
		// 문자형 : char(2 - 유니코드 지원)
		// 진위형 : boolean( X -true/false의 값만 저장)
		// 문자열 : String(클래스, 정해진 크기가 없음)
		
//		Scanner sc = new Scanner(System.in);
		// 변수의 다양한 선언(생성) 방법
		
		// 1. 변수 선언 후 값을 할당(대입)하는 방법
		int n1;
		n1= 10;
		
		// 2. 변수의 선언과 값의 대입을 동시에 처리하는 방법
		int n2 = 20;
		
		// 3. 다수개의 변수를 한번에 선언하는 방법(동일한 자료형일 때만 가능)
		int n3, n4, n5;
		
		// 4. 다수개의 변수도 선언과 동시에 값을 대입할 수 있음
		int n6 =60, n7 = 70;
		// 선언과 동시에 값을 대입한다고 해서 반드시 모든 변수에 값을 넣어야 하는 것은 아님
		int n8, n9 = 90, n10;
		
		// 변수 선언의 위치
		// 사용할 변수가 아직 사용 전이면 아무 위치에서 변수 선언 가능
		// 변수는 반드시 선언 후에 사용할 수 있음. 선언 전에 사용하는 변수는 오류
		int v1 = 10;
		System.out.println("프로그램 시작 v1변수의 값 : "+v1);
		
		// 변수는 선언 이후라도, 값이 대입되지 않으면 사용 불가
//		int v4;
//		System.out.printf("v4 변수의 값 %d\n", v4); //오류
		int v4 = 40;
		System.out.printf("v4 변수의 값 %d\n", v4);
		
		// 변수의 값은 여러번 대입할 수 있으며, 저장되는 값은 가장 최근, 마지막에 저장한 값이 저장되어 사용됨
		// 그 이전에 저장된 값은 소멸- 한번에 하나씩만 저장할 수 있는 단점
		n1=60;
		System.out.println("프로그램 실행 중 변경된 n1 변수의 값 : "+n1);
		
		
		
		// char 형 데이터는 컴퓨터 저장장치에 저장될 때 특별한 이진수 코드로 저장됨
		// 문자를 저장하기 위한 코드체계에 의해 조합된 코드임.
		// 이를 십진수로 변환하면 정수로 변환 가능
		// 그래서 정수와 문자간에는 약간의 호환성이 발생됨.
		
		char ch = 'A';
		int intchar = ch;
		
		System.out.printf(" ch -> int 에 저장 %d\n", intchar);
		System.out.printf("ch-> %c\n", ch);
		System.out.printf("ch-> 정수 출력자리에 문자출력 %d\n", (int)ch);
		System.out.printf("ch-> 문자 출력자리에 정수출력 %c\n", intchar);
		
		
		
	}

}
