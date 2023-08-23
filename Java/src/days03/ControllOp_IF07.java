package days03;

import java.util.Scanner;

public class ControllOp_IF07 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String level; //직급 저장 변수
		int pay; //판매실적금액 변수
		
		System.out.printf("직급 입력(과장/대리/사원) : ");
		level = sc.nextLine(); //String 입력 때 사용
		
				
		System.out.printf("판매실적금액 입력 : ");
		pay = sc.nextInt();
		double a;
		double total;
//		boolean b = level.equals("과장") // 이렇게도 되지만 너무 번거로움
		
		// 판매실적금액에 과장 50%, 대리 25%, 사원 15%의 활동비를 합산하여 출력해 주세요
		
		if(level.equals("과장")) //String은 이렇게
			a=0.5;
		else if(level.equals("대리"))	a=0.25;
			else	a=0.15;
			
		total=pay+pay*a;
		System.out.println("total : "+(int)total);
	}
		
}
