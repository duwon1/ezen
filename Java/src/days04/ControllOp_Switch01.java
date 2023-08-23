package days04;

import java.util.Scanner;

public class ControllOp_Switch01 {

	public static void main(String[] args) {
		
		int a;
		Scanner sc =new Scanner(System.in);
		System.out.println("정수를 입력하세요 : ");
		a = sc.nextInt();
		
//		if (a==1)System.out.println("1을 입력하셨습니다.");
//		else if (a==2)System.out.println("2를 입력하셨습니다.");
//		else if (a==3)System.out.println("3을 입력하셨습니다.");
//		else if (a==4)System.out.println("4를 입력하셨습니다.");
//		else System.out.println("1~4 외의 값을 입력하셨습니다.");
		
//		 switch 문 : if문과 비슷한 구조이지만, 변수값의 단순 참조일 때 사용하며, 변수값이나 연산식 결과값에 따라 
//		실행한 명령이 선택됨
		switch( a ) {
			case 1 :
				System.out.println("1을 입력하셨습니다.");
				break;
			case 2 : 
				System.out.println("2를 입력하셨습니다.");
				break;
			case 3 : 
				System.out.println("3을 입력하셨습니다.");
				break;
			case 4 : 
				System.out.println("4를 입력하셨습니다.");
				break;
			default:
				System.out.println("1~4 외의 값을 입력하셨습니다.");
		// break : 자신을 감싼 switch, for, while 등의 {} 영역을 빠져나가라는 명령
				
		}
	}

}
