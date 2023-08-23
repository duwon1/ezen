package days02;

public class Println01 {

	public static void main(String[] args) {
		
		System.out.println(10); // 정수 출력
		System.out.println(12.123); // 실수 출력
		System.out.println("Java Programming");// String 출력
		
//		 System.out.println() 은 System.out.printf("\n")와 동일
//		 println 은 \n이 없어도 모든 출력 후 줄바꿈을 한번 실행해 줌
//		 System.out.println("\n"); <--두 줄 바꿈
//		 printf와 같이 format 양식 글자 (%d, %f 등)를 사용 못함
//		 다만 printf보다 출력이 간단함
		
		System.out.println(10 + "_" + 12.123);
		//10+"_" --> "10_"  "10_"+12.123 -->"10_12.123"
//		'+' 연산기호는 숫자끼리 연산은 산술연산, 문자와 다른 자료형의 연산은 이어붙이기 연산이 실행됨
//		 문자+문자 ->문자		문자+다른 자료 ->문자
		
		//문자와 숫자의 차이
		/*
		 * 1. 표면상으론 따옴표 안에 쓰였냐 아니냐로 구분
		 * 2. 123은 백이십삼이라고 읽지만, "123"은 일이삼이라고 읽음
		 * 3. 987은 1234보다 작지만, "987"은 "1234"보다 큼
		 * - 문자들간의 비교는 첫글자부터 하나씩 같은 위치의 글자와 비교
		 * - 첫글자에서 크기가 결정되면 그 다음은 비교하지 않음
		 * - 두번째 글자를 비교하는 경우는 첫번째가 같은 글자일 때만
		 * - 두번째 글자도 같으면 세번재 글자 비교
		 * - 사전에서 찾았을 때 먼저 나오는 글자를 작다라고 하고 뒤에 나오는 글자를 크다라고 함
		 */
		
		System.out.println();
		System.out.println("10"+"5");
		System.out.println("10"+5);
		System.out.println(10+"5");
		System.out.println(10+5); //산술 덧셈
		System.out.println("Hello"+"World~!");
		
		// 10+5 = 15 를 출력하고 싶을 때
		System.out.println(10 + "+" +5+ "="+(10+5));
		System.out.println("10+5"+ "="+(10+5));
		System.out.println("10+5="+(10+5));
		System.out.println("10+5=1"+5);
		System.out.println("10+5=15");
		
		
	}

}
