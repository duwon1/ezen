package days04;

import java.util.Scanner;

public class ControllOp_For09 {

	public static void main(String[] args) {
		//10개의 정수를 입력받아 합개와 평균을 출력
		//10개를 입력하는 중간에 종료를 원하면 0을 입력하여 입력 종료하고 최종 합계 출력
		
		//입력양식
		//입력 1:xx
		//...
		//입력 10:xx
		
		//출력양식
		//입력한 정수들의 합계 : XXX
		//입력한 정수들의 평균 : XX.X
		
		//중간에 0을 입력하면 입력이 종료되고 그 동안 입력한 데이터만으로 합계평균을 출력
		int sum = 0;
		int num;
		int i;
		Scanner sc =new Scanner(System.in);
//		for(int a=1; a<=10;a++) {
//			for(int i=1 ;i<=10; i++ ) {
//			System.out.printf("입력 "+a+" : ");break;
//			}
//				int b= sc.nextInt();
//				int sum=0;
//				sum= sum+b;
//				double avg = sum/a;
//				if(b==0) {
//					break;}
//					System.out.println("입력한 정수들의 합계 : "+sum);
//					System.out.println("입력한 정수들의 평균 : "+avg);
//				
//					else if (a==10) {
//					System.out.println("입력한 정수들의 합계 : "+sum);
//					System.out.println("입력한 정수들의 평균 : "+avg);
//			}
//		
//	
//}
		System.out.println("정수 열개를 엔터와 함께 하나씩 입력하세요 : ");
	for( i=1; i<=10; i++) {
		System.out.printf("입력 %d : ", i);
		num=sc.nextInt();
		if(num==0) break;	// 반복실행은 break로 정해진 횟수를 다 채우지 않고 멈출 수 있음
		sum=sum+num;	// 반복 실행 속에 입력명령이 있다면 다음 입력으로 현재 입력이 사라질 수 있음
	}
		System.out.println("입력된 점수의 합계 : "+sum);
		System.out.println("반복종료 후 i 값 : "+i);
		System.out.println("입력된 점수의 평균 : "+sum/(double)(i-1));
		
	}

}
