package days04;

import java.util.Scanner;

public class ControllOp_Switch02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("월 : ");
		int m = sc.nextInt();
		System.out.printf("일 : ");
		int d = sc.nextInt();
		System.out.printf("%d월 %d일을 입력하셨습니다.", m, d);
		
int days = 0;
		
		switch(m) {
		case 1 :days = 0; break;
		case 2 :days=31;break;
		case 3 :days =31+28;break;
		case 4 :days =31+28+31;break;
		case 5 :days= 31+28+31+30;break;
		case 6 :days= 31+28+31+30+31;break;
		case 7 :days= 31+28+31+30+31+30;break;
		case 8 :days= 31+28+31+30+31+30+31;break;
		case 9 :days= 31+28+31+30+31+30+31+31;break;
		case 10 :days=31+28+31+30+31+30+31+31+30;break;
		case 11 :days=31+28+31+30+31+30+31+31+30+31;break;
		case 12 :days=31+28+31+30+31+30+31+31+30+31+30;break;
//		case 12 : case 13: days=31+28+31+30+31+30+31+31+30+31+30;break;
		//만약에 다른 변수가 값이 동일하면 위에 있는 것처럼 쓸 수 있음
		default : 
			System.out.println("잘못 입력하셨습니다. 프로그램이 종료됩니다.");
			return;
		}		
		
		days+=d;
		int temp =days %7;
		
		switch(temp) {
		case 0 :System.out.println("입력한 날짜는 토요일"); break;
		case 1 :System.out.println("입력한 날짜는 일요일");break;
		case 2 :System.out.println("입력한 날짜는 월요일");break;
		case 3 :System.out.println("입력한 날짜는 화요일");break;
		case 4 :System.out.println("입력한 날짜는 수요일");break;
		case 5 :System.out.println("입력한 날짜는 목요일");break;
		case 6 :System.out.println("입력한 날짜는 금요일");break;
		}
		
		
	}

}
