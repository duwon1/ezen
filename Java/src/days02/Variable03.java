package days02;

import java.util.Scanner;

public class Variable03 {

	public static void main(String[] args) {
		
		// 삼각형의 밑변과 높이를 입력받아서 넓이를 출력
		// 삼각형의 넓이 : 밑변 x 높이 x 0.5
		
		int baseLine, height;
		double area;
		
		Scanner sc = new Scanner(System.in); //sc.nextInt() 전에만 이 문장이 나오면 됨
		
		System.out.printf("삼각형의 밑변 입력 : ");
		baseLine = sc.nextInt();
		System.out.printf("삼각형의 높이 입력 : ");
		height = sc.nextInt();
		
		area = baseLine *height * 0.5;
		System.out.printf("입력하신 삼각형의 넓이는 %.1f 입니다.", area);
		
		
		
		
		
		
		
	}

}
