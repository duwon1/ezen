package days04;

import java.util.Scanner;

public class ControllOp_For12 {

	public static void main(String[] args) {
		
		//입력 받은 두개의 공약수들을 출력하세요
		// 12 36을 입력한 경우 1 2 3 4 6 12
		// 공약수가 모두 출력 됐다면 최대공약수를 따로 출력
		
		Scanner sc =new Scanner(System.in);
		int num1, num2;
		int i;
		int small;
		System.out.printf("첫번재 정수 입력 : ");
		num1= sc.nextInt();
		System.out.printf("두번재 정수 입력 : ");
		num2= sc.nextInt();
		int k;
		for(i=1;i<=num1;i++) {
			if(((num1%i)==0) &&((num2%i)==0)){
						System.out.printf("%d  ",i);
						k = i;
			}
		}
	}
}
		
		//최대공약수가 나오긴했는데 굳이이렇게 늘려서 할 필요가 없음 
//		for(small=1;small<=i;small++) {
//			if(small==i)
//			System.out.println(small-1);}
		
		
		
		
