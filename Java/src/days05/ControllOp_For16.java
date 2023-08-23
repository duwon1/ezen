package days05;

import java.util.Scanner;

public class ControllOp_For16 {

	public static void main(String[] args) {
		
		// 정수 하나를 입력 받아서 그 숫자가 소수(prime number)인지 아닌지를 출력하는 명령
//		Scanner sc=new Scanner(System.in);
//		System.out.print("정수를 입력하세요 : ");
//		int num = sc.nextInt();
		int i;
		// 1부터 자기 자신까지의 숫자를 모두 나눠보고 나눠지는 횟수가 딱 2번인 경우
//		int count=0;// 나눠떨어지는 횟수를 카운트하기 위한 변수, 나눠질 때마다 count++연산으로 횟수 카운트
//			for(int i=1;i<=num; i++) {
//				if(num%i==0) { 
//					count++;
//				}
//			}
//			if(count==2) System.out.println("입력한 정수 "+num+"은 소수입니다.");
//			else System.out.println("입력한 정수 "+num+"은 소수가 아닙니다.");
		
		// 1부터 100사이의 소수를 모두 출력해주세요
		int count;
		int j;
		for(i=2; i<=100; i++) {
			count=0;
			for(j=2; j<=i/2; j++) {
				// 어떤 수에서 절반이후는 전부 1.XXX고 원래 수로 나눠야 1이기 때문에 절반부터 원래 수보다 하나 작은 부분은 버려도됨
				if(i%j==0) count++;
			}
			if (count==0) System.out.printf("%d ", i);
		}
		
//		count를 왜 맨 위에서 0을 주면 안풀리는 걸까? 
//		--아 알겠음 for문 처음으로 돌아왔을 때 초기화가 안됨
//		int count=0;
//		int j;
//		for(i=1; i<=100; i++) {
//			for(j=1; j<=i; j++) {
//				// i값을 1~i값을 갖는 j로 모두 나눔
//				if(i%j==0) count++;
//			}
//			if (count==2) System.out.printf("%d ", i);
//		}
		
	}

}
