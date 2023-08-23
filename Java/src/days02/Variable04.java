package days02;

import java.util.Scanner;

public class Variable04 {

	public static void main(String[] args) {
		
		//반지름을 입력받아 원의 넓이, 둘레의 길이 출력
		//넓이 - 반지름x반지름x3.141592	둘레-2x반지름x3.141592
		
		Scanner sc = new Scanner(System.in);
		
		int radius;
		double area, circum;
		
		System.out.printf("반지름을 입력하세요 : ");
		radius=sc.nextInt();
		
		//println 버전
		area = radius*radius*3.141592;
		System.out.println("원의 넓이는 "+(int)(area*100)/100.0+" 입니다.");
		
		circum = radius*2*3.141592;
		System.out.println("원주는 "+(int)(circum*100)/100.0+" 입니다.");
		//printf 버전
		System.out.printf("원의 넓이는 %.2f, 원주는 %.2f 입니다.", area, circum);
	}

}
