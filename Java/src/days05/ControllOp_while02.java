package days05;

import java.util.Scanner;

public class ControllOp_while02 {

	public static void main(String[] args) {
		
		// 1부터 100 사이의 짝수의 출력 : while문 이용
		
//		//1번 방법
//		int even=1;
//		while(even<=100) {
//			even++;
//			if(even%2==0) {
//				System.out.printf("%d ", even);
//			}
//		}
//		System.out.println();
//		//2번 방법
//		int i =2;
//		while(i<=100) {
//			System.out.printf("%d ",i); //이걸 while문 안에 넣고 증감하기 전에 출력해야 맨 첫 대입자도 나옴
//			i+=2;
//		}
		
		// 정수를 입력받아 입력된 정수의 팩토리얼 출력 : while 이용
		
		Scanner sc= new Scanner(System.in);
		int n, fact=1;
		int i=1;
		System.out.printf("정수 입력 : ");
		n = sc.nextInt();
		System.out.printf("%d!=",n);
		while(i<n) {
			System.out.printf("%dx", i);
			i++;
			fact=fact*i;
		}
			System.out.printf("%d=%d", n, fact);
			
		
		
	}

}
