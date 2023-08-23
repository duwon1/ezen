package days08;

import java.util.Scanner;

public class Method10 {

	public static void main(String[] args) {
		
		int ban;
		double n, d;
		Scanner sc =new Scanner(System.in);
		System.out.println("반지름을 입력하세요 ");
		ban = sc.nextInt();
		
		n= calculate1(ban);//원의 넓이 메서드
		d= calculate2(ban);//원주 메서드
		prn(n,d); //넓이와 둘레를 출력하는 메서드

	}
	
	public static double calculate1(int ban) {
//		double a= ban*ban*3.14;
//		return a;
		return ban*ban*3.14; //이렇게 줄여쓸 수 있음
	}
	public static double calculate2(int ban) {
		return ban*2*3.14;
	}
	public static void prn(double n, double d) {
	System.out.printf("넓이 : %.1f, 원주 : %.1f", n, d);
	}

}
