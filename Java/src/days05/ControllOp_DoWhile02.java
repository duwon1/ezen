package days05;

import java.util.Scanner;

public class ControllOp_DoWhile02 {

	public static void main(String[] args) {
		
		// 두개의 정수와 연산할 연산자를 입력받아서 해당 연산의 결과를 출력하되
		// 연산과 출력 끝나고 나면 "계속하시겠습니까?(Y:1/N:2)"으로 물어보고
		// Y:정수와 연산자 재입력 & 재연산
		// N:프로그램 종료
		// do while 이용
		
		Scanner sc = new Scanner(System.in);
		int n1, n2, result=0, operator, isExit;
		do {
			System.out.print("1번째 정수를 입력하세요 : ");
			n1=sc.nextInt();
			System.out.print("2번째 정수를 입력하세요 : ");
			n2=sc.nextInt();
			System.out.print("계산에 사용할 부호를 입력하세요(+:1, -:2, *:3, /:4 : ");
			operator=sc.nextInt();

			switch(operator) {
			case 1 : result = n1 + n2; break;
			case 2 : result = n1 - n2; break;
			case 3 : result = n1 * n2; break;
			case 4 : result = n1 / n2; break;
			}
			System.out.printf("result = %d\n", result);
			System.out.printf("계속하시겠습니까?(Y:1/N:2) : ");
			isExit = sc.nextInt();
		}while( isExit !=2);
		System.out.println("프로그램 종료");
		
	}

}
