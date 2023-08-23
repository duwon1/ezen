package days04;

import java.util.Scanner;

public class ControllOp_For04 {

	public static void main(String[] args) {
		// 입력한 숫자의 구구단 출력하기
		Scanner sc = new Scanner(System.in);
		int dan;
		System.out.printf("출력할 단을 입력하세요(2~9) :");
		dan=sc.nextInt();
		
		for(int i=1;i<=9;i++) {
//			System.out.println(dan+"x"+i+"="+dan*i);
			System.out.printf("%dx%d=%d\n", dan, i, dan*i);
		}
		
		
	}

}
