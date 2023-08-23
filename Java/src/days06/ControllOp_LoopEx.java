package days06;

import java.util.Scanner;

public class ControllOp_LoopEx {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int ans;
		do {
			// 컴퓨터가 사용자에게 알려주지 않은 1~200 사이의 값을 변수에 저장합니다
			int com = (int)(Math.random() * 200) + 1;
			// System.out.println(com);
			int user;
			do {
				// 사용자에게 컴퓨터가 저장하고 있을 숫자를 예측해서 입력하도록 합니다.
				System.out.print("사용자 입력 : ");
				user=sc.nextInt();	
				// 입력된 숫자와 컴퓨터가 기억된 숫자를 비교해서 일치하면 게임 종료
				// 일치하지 않으면 그 수치를 비교해서 Up 또는 Down 을 출력합니다.
				// Up/Down 을 보고 다시 입력하고 그리고 다시 비교해서 출력하고...
				// 그렇게  맞출때까지 반복합니다.
				if( user==0 ) {
					System.out.println("프로그램이 사용자 요청에 의해 종료되었습니다");
					return;
				}else if( com < user ) System.out.println("Down");
				else if( com > user ) System.out.println("Up");
				else System.out.println("맞췄습니다");
				
			} while( com != user );
			System.out.print("다른 게임을 하시겠습니까?(Y:1 / N:2)");
			ans = sc.nextInt();
		}while(ans == 1); // 숫자를 맞추면, 다시 물어봅니다. "다른 게임을 하시겠습니까?(Y:1 / N:2)
		// 계속하겠다는 응답이 있으면  맨위컴퓨터가 숫자를 다시 결정하는곳부터 반복합니다
		// 게임 중간에라도 종료하고자 한다면 '0' 를 입력해서 종료할수 있게 해주세요
		
	}

}
