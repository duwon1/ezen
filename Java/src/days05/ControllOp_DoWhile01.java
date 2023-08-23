package days05;

import java.util.Scanner;

public class ControllOp_DoWhile01 {

	public static void main(String[] args) {
		
		int i;
		for(i=11; i<=10; i++) {
			System.out.printf("%d ", i);
		}
		System.out.println("\nfor 반복 종료 후 i 변수 값 : "+i);
		System.out.println("-----------------------------------------");
		
		i=11;
		while( i<=10) {
			System.out.printf("%d ", i);
			i++;
		}
		System.out.println("\nwhile 반복 종료 후 i 변수 값 : "+i);
		System.out.println("-----------------------------------------");
		
		
		i=11;
		do {
			System.out.printf("%d ", i);
			i++;
		}while( i<=10);
			System.out.println("\ndo_while 반복 종료 후 i 변수 값 : "+i);
		System.out.println("-----------------------------------------");
		//do while의 특이점 while(조건)을 후미에 기술함
		//while(조건) 뒤에 ';' 세미콜론을 찍음
		//if(조건); X
		//for(int i=1;i<=10;i++); X
		//while(i<100); X
		//do{  }while(조건); O
		//do에 속한 { }안의 명령을 한번 먼저 실행 후 조건을 테스트함
		
		
		//do~while 반복문을 활용해 사용자가 100을 입력할 때까지 반복해서 입력받고 최종합계 출력
		int input,sum =0;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.print("정수를 입력(종료:100) : ");
			input = sc.nextInt();
			sum +=input;
		}while(input !=100 );
		System.out.println("입력한 정수의 합 : "+(sum-100));
				
		
		
		
	}

}
