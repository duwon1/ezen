package days04;

import java.util.Scanner;

public class ControllOp_For05 {

	public static void main(String[] args) {
		//a 변수값부터 b변수값까지 차례로 출력
		//3,8을 입력했다면 3 4 5 6 7 8 이라고 출력되게 반복실행문을 작성하세요
		Scanner sc = new Scanner(System.in);
		int i,a,b;
		System.out.printf("첫번째 정수 입력 : ");
		a = sc.nextInt();
		System.out.printf("두번째 정수 입력 : ");
		b = sc.nextInt();
		//for(a=1; )XXXX
//		for(i=a; i<=b; i++) {
//			System.out.printf("%d ",i);//이건 a가 b보다 작을때는 실행안됨
//		}
		//입력받은 숫자 중 작은 숫자부터 큰 숫자까지 모든 정수를 출력
		//8과 3을 입력했다면 345678
		
		//첫번째 방법
		if(a<b) {
			for(i=a; i<=b;i++)
				System.out.printf("%d ",i);
		}else {
			for(i=b; i<=a;i++)
				System.out.printf("%d ",i);
		}
		//두번째 방법
		System.out.println();
		int min, max;
		if(a<b) {
			min=a;
			max=b;
		}else {
			min=b;
			max=a;
		}
		for(i=min; i<=max; i++)
			System.out.printf("%d ", i);
		}

}
