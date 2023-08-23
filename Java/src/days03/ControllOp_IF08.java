package days03;

import java.util.Scanner;

public class ControllOp_IF08 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int kor, eng, mat, tot;
		double ave;
		System.out.println("국어점수 : ");
		kor = sc.nextInt();
		System.out.println("영어점수 : ");
		eng = sc.nextInt();
		System.out.println("수학점수 : ");
		mat = sc.nextInt();
		tot = kor+eng+mat;
		ave= tot/3.0;

		//평균 60점 이상이면서 모든 과목 40이상이면 합격
		//그렇지 않다면 불합격을 출력하되,
		//해당되는 불합격사유(평균 미달, 국어 과락, 영어 과락, 수학 과락)를 모두 함께 출력하세요
		
		if(ave>=60&&((kor>=40)&&(eng>=40)&&(mat>=40))) System.out.println("합격입니다");
		else 
			System.out.print("불합격\t");
		
			if(ave<60) System.out.printf("평균미달\t");
			if(kor<60) System.out.printf("국어과락\t");
			if(eng<60) System.out.printf("영어과락\t");
			if(mat<60) System.out.printf("수학과락\t");
		
		
		
	}

}
