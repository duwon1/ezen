package days07;

import java.util.Scanner;

public class Array14 {

	public static void main(String[] args) {
		
		// 3명 학생의 3과목 점수 저장 배열. 마지막 열은 총점
		int [][] score = new int[3][4];
		
		double [] avg = new double[3];
		String [] name = new String[3];
		char [] grade = new char[3];
		
		Scanner sc = new Scanner(System.in);
		
		// 각 학생의 이름과 세 과목의 점수를 입력
		for(int i=0; i<name.length;i++) {
			System.out.print((i+1) + "번 학생 이름 : ");
			name[i] =sc.nextLine();
			
			for(int j=0; j<3; j++) {
				System.out.print((j+1) +"과목 점수 :");
				score[i][j] = Integer.parseInt( sc.nextLine());
			}
		}	
			
			//이렇게도 되지만 위가 좀 더 간단
//			System.out.print("국어 점수 :");
//			score[i][0] = Integer.parseInt( sc.nextLine());
//			System.out.print("영어 점수 :");
//			score[i][1] = Integer.parseInt( sc.nextLine());
//			System.out.print("수학 점수 :");
//			score[i][2] = Integer.parseInt( sc.nextLine());
			
			char [] g = { 'F','F','F','F','F','F','D','C','B','A','A'};
			// 이중 반복문을 이용해서 총점 평균 학점 계산
			
			for(int i=0; i<3; i++) {
				score[i][3] = score[i][0] + score[i][1] + score[i][2] ;
				avg[i] = score[i][3]/3.0;
				grade[i] = g[(int)(avg[i] /10)];
			}
		
			
			System.out.println("\t\t ###성적표###");
			System.out.println("------------------------------------------");
			System.out.println("번호\t이름\t\t국어\t영어\t수학\t총점\t평균\t학점");
			System.out.println("------------------------------------------");
			for(int i=0; i<3; i++) {
				System.out.printf("%d\t", i+1);
				System.out.printf("%s\t\t", name[i]);
				for(int j =0; j<4; j++) 
					System.out.printf("%3d\t", score[i][j]);
				System.out.printf("%.1f\t", avg[i]);
				System.out.printf("%c\n", grade[i]);
			}
		
		
	}

}
