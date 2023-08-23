package days04;

import java.util.Scanner;

public class ControllOp_For10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("정수를 입력하세요 : ");
		int num= sc.nextInt();
		int sum=0;
		
		//정수 하나를 입력 받아서 1부터 입력받은 정수까지 짝수의 합을 출력하세요
	
		 //1번 방식(선생님)
		for (int i=2; i<=num; i+=2) {
			sum=sum+i;
			System.out.println("2부터 "+i+"까지의 짝수들 합 : "+sum);
		}
		System.out.println();		
		
//2번 방식(내방식)
		for(int i=1; i<=num;i++) {
			if(i%2==0)
				sum=sum+i;
			System.out.println("2부터 "+i+"까지의 짝수들 합 : "+sum);
		}
		
		System.out.println();	
		
		for(int i=1; i<=num;i++) {
			if(i%2==1) continue; //현재반복실행의 명령을 현재 지점에서 실행중단 & 다음 반복으로 이동
			sum=sum+i;
			System.out.println("2부터 "+i+"까지의 짝수들 합 : "+sum);
		}
		
		
		
	}

}
