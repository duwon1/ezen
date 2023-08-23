package days03;

import java.util.Scanner;

public class ControllOp_IF05 {

	public static void main(String[] args) {
		
		// 출생년도 입력 받아서 나이 계산하고 (2023 -입력년도+1)
		// 12세 미만 어린이, 12~18 청소년, 19~25 청년, 26 이상 성년
		
		int year;
		int age;
		Scanner sc = new Scanner(System.in);
		System.out.println("출생년도 입력 : ");
		year = sc.nextInt();
		
		age = 2023- year +1;
		if(age<12) System.out.println("어린이");
		else if(12<=age&&age<=18) System.out.println("청소년");
		else if(18<age&&age<=25) System.out.println("청년");
		else System.out.println("성년");
		
	}

}
