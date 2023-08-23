package days02;

import java.util.Scanner;  //import 단축키 : ctrl + shift + 'o'

public class Variable02 {

	public static void main(String[] args) {
		
		int number1, number2;
		int result1; // 덧셈, 뺄셈, 곱셈의 결과를 저장할 변수
		double result2; // 나눗셈의 결과를 저장할 변수
		
		// 외부의 라이브러리 또는 API를 불러다 사용해야 하는 경우가 있음
		// 사용자로부터 화면 입력을 받는 도구는 외부 라이브러리에 있는 도구를 불러와서 사용해야 함
		// 사용자 입력을 위해 불러와서 준비해야할 코드
		Scanner sc = new Scanner(System.in); //화면입력을 위한 준비코드
		
		System.out.printf("첫번째 정수를 입력하세요 : ");
		number1 = sc.nextInt(); //화면으로부터 사용자가 입력한 내용을 프로그램 내부로 가져오라는 명령
		System.out.println("입력한 첫번째 정수는 "+ number1 + "입니다.");
		// 컴파일러가 sc.nextInt() 명령을 만나면 사용자에게서 입력이 있을 때 까지 무한정 대기함
//		System.out.println("입력한 정수는 "+ number1 + "입니다.");
		
		// 나는 println으로 함
		System.out.printf("두번째 정수를 입력하세요 : ");
		number2 = sc.nextInt();
		System.out.println("입력한 두번째 정수는 "+ number2 + "입니다.");
		
		
//		result1 = number1 + number2;
//		System.out.println("두 정수의 합은 "+number1+"+" + number2 +"=" + result1 + "입니다.");
//		result1 = number1 - number2;
//		System.out.println("두 정수의 차는 "+number1+"-" + number2 +"=" + result1 + "입니다.");
//		result1 = number1 * number2;
//		System.out.println("두 정수의 곱은 "+number1+"x" + number2 +"=" + result1 + "입니다.");
//		result2 = number1 / (double)number2;
//		System.out.println("두 정수의 나눗셈은 "+number1+"÷" + number2 +"=" + (int)(result2 *10)/10.0 + "입니다.");
		
		//쌤은 printf
		result1 = number1 + number2;
		System.out.printf("%d + %d = %d\n", number1, number2, result1);
		result1 = number1 - number2;
		System.out.printf("%d - %d = %d\n", number1, number2, result1);
		result1 = number1 * number2;
		System.out.printf("%d * %d = %d\n", number1, number2, result1);
		result2 = number1 / (double)number2;
		System.out.printf("%d ÷ %d = %.1f\n", number1, number2, result2);
		
		
	}

}
