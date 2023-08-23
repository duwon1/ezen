package days04;

import java.util.Scanner;

public class ControllOp_For08 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//년도 입력 추가
		System.out.printf("년도 입력 : ");
		int y = sc.nextInt();
		System.out.printf("월 : ");
		int m = sc.nextInt();
		System.out.printf("일 : ");
		int d = sc.nextInt();
		System.out.printf("%d년 %d월 %d일을 입력하셨습니다.", y, m, d);
		int days = 0;
		
		//1. 입력받은 년도의 전년도까지 지나온 날짜수를 계산
		//		2023을 입력했다고 가정할 때 2022년까지 지나온 날짜를 계산
		// 365*2022+ (1년부터 2022년까지 있었던 윤년의 횟수)
		
		days = 365*(y-1);
		for(int i=1; i<=(y-1);i++)
			if((i%4==0)&&(i%100!=0)||(i%400==0))
				days++;
		
		switch(m) {
		case 12 : days = days +30; 
		case 11 :days = days +31;
		case 10 :days = days +30;
		case 9 :days = days +31;
		case 8 :days = days +31;
		case 7 :days = days +30;
		case 6 :days = days +31;
		case 5 :days = days +30;
		case 4 :days = days +31;
		case 3 : //입력한 년도가 윤년이면 29일 아니면 28일 더하기
			if((y%4==0)&&(y%100!=100)||(y%400==0))
			days = days +29;
			else 
				days = days +28;
		case 2 :days = days +31;
		case 1 : break;
		default :
			System.out.println("잘못 입력하셨습니다. 프로그램이 종료됩니다.");
			return;

		}		
		
		days+=d;
		int temp =days %7;
		
		switch(temp) {
		case 1 :System.out.println("입력한 날짜는 월요일");break;
		case 2 :System.out.println("입력한 날짜는 화요일");break;
		case 3 :System.out.println("입력한 날짜는 수요일");break;
		case 4 :System.out.println("입력한 날짜는 목요일");break;
		case 5 :System.out.println("입력한 날짜는 금요일");break;
		case 6 :System.out.println("입력한 날짜는 토요일");break;
		case 0 :System.out.println("입력한 날짜는 일요일"); break;
		}
		
	}

}
