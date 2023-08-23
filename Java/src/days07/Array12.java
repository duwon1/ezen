package days07;

import java.util.Scanner;

public class Array12 {

	public static void main(String[] args) {
		
		// 점수를 입력 받아서 해당 학점을 출력
		// if 문을 이용하지 않고 배열을 이용하기
		// 90이상 A, 80이상 B, 70이상 C, 60이상 D, 나머지 F
		
		char [] grade = { 'F','F','F','F','F','F','D','C','B','A','A'};
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("점수를 입력하세요(0~100) : ");
		int score = Integer.parseInt( sc.nextLine() );		
		
		int index = score / 10;
		
		System.out.println("입력한 점수의 학점은 "+ grade[ index ] + "입니다");
		System.out.println("입력한 점수의 학점은 "+ grade[ score / 10 ] + "입니다");
		// 배열의 첨자는 정수이므로 변수를 사용할 수도 있고 연산식을 넣어서 사용할 수도 있음
		
		
	}

}
