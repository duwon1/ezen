package days04;

import java.util.Scanner;

public class ControllOp_IF10 {

	public static void main(String[] args) {
		
		//2023년에 한해서 월과 일을 입력 받고, 요일을 출력하세요
		// 1월 10일 입력했다면 1월 1일부터 10일까지 10일의 날짜가 계산됩니다.
		// 그를 7로 나눈 나머지를 구하면 3이고, 1:일요일 2:월요일 3:화요일...
		// 위와같이 요일을 계산합니다. 해당입력일은 수요일
		// 2월 5일 입력했다면--1월에 해당하는 31일 + 입력한 일 5 ->36
		//36을 7로 나눈 나머지 계산하면 1, 해당입력일은 일요일이 됩니다.
		
		//1. 요일을 계산할 월과 일을 입력 받습니다.
		Scanner sc = new Scanner(System.in);
		System.out.printf("월 : ");
		int m = sc.nextInt();
		System.out.printf("일 : ");
		int d = sc.nextInt();
		System.out.printf("%d월 %d일을 입력하셨습니다.", m, d);
	
		//내가 만든 식
//		int d1 = (m-1)*31;
//		if (1<=m&&m<=2) d1=d1+d;
//		else if(3<=m&&m<=4) d1=d1-3+d;
//		else if(5<=m&&m<=6) d1=d1-4+d;
//		else if(7<=m&&m<=9) d1=d1-5+d;
//		else if(10<=m&&m<=11) d1=d1-6+d;
//		else  d1=d1-7+d;
//		
//		if ((d1%7)==1) System.out.println("입력한 날짜는 일요일");
//		else if ((d1%7)==2) System.out.println("입력한 날짜는 월요일");
//		else if ((d1%7)==3) System.out.println("입력한 날짜는 화요일");
//		else if ((d1%7)==4) System.out.println("입력한 날짜는 수요일");
//		else if ((d1%7)==5) System.out.println("입력한 날짜는 목요일");
//		else if ((d1%7)==6) System.out.println("입력한 날짜는 금요일");
//		else System.out.println("입력한 날짜는 토요일");
		
		//선생님 식
		int days = 0;
		
		// 1. 입력받은 월의 바로 전달까지 날짜수를 계산한다.
		if(m==1) days = 0;
		else if(m==2) days=31;
			else if(m==3) days =31+28;
				else if(m==4) days =31+28+31;
					else if(m==5) days= 31+28+31+30;
						else if(m==6) days= 31+28+31+30+31;
							else if(m==7) days= 31+28+31+30+31+30;
								else if(m==8)days= 31+28+31+30+31+30+31;
									else if(m==9)days= 31+28+31+30+31+30+31+31;
										else if(m==10) days=31+28+31+30+31+30+31+31+30;
											else if(m==11) days=31+28+31+30+31+30+31+31+30+31;
												else if(m==12) days=31+28+31+30+31+30+31+31+30+31+30;
												else {
													System.out.print("잘못 입력하셨습니다. 프로그램이 종료됩니다.");
												return; //프로그램 종료 명령은 아니지만 지금은 그 역할도 함
												}
		
		//2. 입력된 일을 days에 합산
		days+=d;
		
		int temp =days %7;
		
		if ((temp)==1) System.out.println("입력한 날짜는 일요일");
		else if ((temp)==2) System.out.println("입력한 날짜는 월요일");
		else if ((temp)==3) System.out.println("입력한 날짜는 화요일");
		else if ((temp)==4) System.out.println("입력한 날짜는 수요일");
		else if ((temp)==5) System.out.println("입력한 날짜는 목요일");
		else if ((temp)==6) System.out.println("입력한 날짜는 금요일");
		else if ((temp)==0) System.out.println("입력한 날짜는 금요일");
		 
		
//		 if의 각 경우의수의 처리할 변수의 명령이 초기화되지 않은 변수에 값을 동작들이라면
//		 각 경우의 수에 맞지 않는 변수값이 여전히 초기화되지 않으므로, else를 써서
//		 변수값이 대입될 경우의 수를 만들어 줌
//		 그렇지 않을 예정이라면 변수 선언 시 값을 넣어주는 방법을 쓸수 있음
	}

}
