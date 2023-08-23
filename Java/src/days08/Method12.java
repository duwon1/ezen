package days08;

import java.util.Scanner;

public class Method12 {

	public static void main(String[] args) {
		int a, b;
		double c;
		a = myInput(1); //밑변을 입력받음. "밑변을 입력하세요" 라고 안내
		b = myInput(2); //높이를 입력받음. "높이를 입력하세요" 라고 안내
		//전달인수가 1이면 밑변을 입력받아 리턴하는 메서드로,
		//2면 높이를 입력받아 리턴하는 메서드로 동작
		c = calculate(a,b); //넓이 계산
		prn(c); //넓이 출력
	}
	
	public static int myInput(int l) {
		Scanner sc = new Scanner(System.in);
		int a;
		if(l==1) System.out.printf("밑변을 입력하세요 : ");
		else 	System.out.printf("높이를 입력하세요 : ");
		a = sc.nextInt();
		return a; //return sc.nextInt();
	}
	
	public static double calculate(int a, int b) {
		return a*b*0.5;
	}
	
	public static void prn(double a) {
		System.out.println("삼각형의 넓이는 : "+a);
	}

}
