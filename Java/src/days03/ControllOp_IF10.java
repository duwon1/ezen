package days03;

import java.util.Scanner;

public class ControllOp_IF10 {

	public static void main(String[] args) {
		// 2023년에 한해서  월과 일을 입력 받고, 요일을 출력하세요
		//  1월 10일 입력했다면   1월 1일 부터 10일까지 10일의 날짜가 계산됩니다
		//  그를 7로 나눈 나머지를 구하면  3이고,   1:토요일  2:일요일  3:월요일....
		// 위와 같이 요일을 계산합니다   해당 입력일은 월요일
		// 2월 5일 입력했다면 - 1월에 해당하는 31일 + 입력한 일 5 -> 36
		// 36을 7로 나눈 나머지 계산하면  1,  해당입력일은 토요일이 됩니다  
				
		// 1. 요일을 계산할 월과 일을 입력 받습니다
		Scanner sc = new Scanner(System.in);
		System.out.printf("월 입력 : ");
		int m = sc.nextInt();
		System.out.printf("일 입력 : ");
		int d = sc.nextInt();

	}

}
