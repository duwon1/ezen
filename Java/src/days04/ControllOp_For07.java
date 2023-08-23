package days04;

import java.util.Scanner;

public class ControllOp_For07 {

	public static void main(String[] args) {
		//6!=6x5x4x3x2x1= 720
		Scanner sc= new Scanner(System.in);
		int fact=1;
		int i, k;
		System.out.printf("출력할 팩토리얼을 입력하세요 : ");
		k =sc.nextInt();
		
		System.out.printf("%d!=",k);
		
		for(i=k; i>1; i--) {		//7을 입력했다면
			fact=fact*i;
			System.out.printf("%dx",i);  //7x6x5x4x3x2x 출력
		}
		System.out.printf("%d=%d", 1,fact);  //7=7!결과출력
	}

}
