package days04;

import java.util.Scanner;

public class ControllOp_For06 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int k ;
		/*
		System.out.print("합계를 구할 끝숫자를 입력하세요 : ");
		k=sc.nextInt();
		
		int sum=0;
		for(int i=1; i<=k; i++)
			sum +=i;
		System.out.println("1부터"+k+"까지의 합계 : "+sum);
		*/
		/*//입력한 숫자의 팩토리얼 계산 후 출력
		System.out.printf("출력할 팩토리얼을 입력하세요 : ");
		k=sc.nextInt();
		int i;
		int fact=1;
		for(i=1;i<=k;i++) {
			fact=fact*i;
		}
		System.out.printf("%d! = %d", k, fact);
			*/
		
		//6!=1x2x3x4x5x6=720
		System.out.printf("출력할 팩토리얼을 입력하세요 : ");
		k=sc.nextInt();
		System.out.printf("%d!=",k);
		int i;
		int fact = 1;
		for(i=1;i<k;i++) {	// k에 7을 입력했다면 반복은 1~6
			fact = fact *i;
			System.out.printf("%dx",i); //1x2x3x4x5x6x 출력
		}
		System.out.printf("%d=%d", k, fact*k);		// 7과 최종 결과 7!값은 반복실행과는 따로 출력
		
		
	}

}
