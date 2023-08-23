package days03;

import java.util.Scanner;

public class ControllOp_IF06 {

	public static void main(String[] args) {
		
		int basic; // 기본급 저장 변수
		double total; // 총지급액 저장 변수
		double bonus ; // 계산된 보너스 금액 저장 변수
		Scanner sc = new Scanner(System.in);
		System.out.printf("기본급을 입력하세요 : ");
		basic = sc.nextInt();
		//기본급이 백만원 이상이라면 기본급의 50%를 보너스로 합산
		//기본급이 백만원 미만이라면 기본급의 60%를 보너스로 합산
		
		// 내방식
		double a;
		
		if(basic>=1000000) {
			a=0.5;
		}else {
			a=0.6;
		}
		bonus= basic*a;
		total = basic+bonus;
		System.out.println("총지급액 : "+total);

		//1번
		if(basic>=1000000) {
			bonus= basic*0.5;
			total = basic+bonus;
//			System.out.println("총지급액 : "+total);
			System.out.printf("기본급 : %d, 보너스: %.1f, 총지급액 : %.1f\n", basic, bonus, total);
			
		}else {
			bonus= basic*0.6;
			total = basic+bonus;
			System.out.printf("기본급 : %d, 보너스: %.1f, 총지급액 : %.1f\n", basic, bonus, total);
		}
//			System.out.println("총지급액 : "+total);
			
			//2번
			if(basic>=1000000) bonus= basic*0.5;
			else bonus= basic*0.6;
			total = basic+bonus;
			System.out.printf("기본급 : %d, 보너스: %.1f, 총지급액 : %.1f\n", basic, bonus, total);
			
			//3번
			if(basic>=1000000) System.out.printf("기본급 : %d, 보너스: %.1f, 총지급액 : %.1f\n", basic, basic*0.5, basic+basic*0.5);
			else System.out.printf("기본급 : %d, 보너스: %.1f, 총지급액 : %.1f\n", basic, basic*0.6, basic+basic*0.6);
			


	}

}
