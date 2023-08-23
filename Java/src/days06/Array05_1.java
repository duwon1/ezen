package days06;

import java.util.Scanner;

public class Array05_1 {

	public static void main(String[] args) {
		
		// 세명의 학생의 세과목 점수를 입력 받고 총점 평균을 계산해서 성적표를 출력하라
		int [] kor = new int[3]; //국어 점수 저장용 배열
		int [] eng = new int[3];
		int [] mat = new int[3];
		int [] tot = new int[3];
		double [] avg = new double[3];
		int i, j = 0;
		int k= 0;
		int  l= 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("국어점수를 입력하세요");
		for(i=0; i<=2; i++) {
		j=sc.nextInt();
		kor[i]=j;
		}
		System.out.printf("3명의 국어 점수 : ");
		for(i=0; i<=2; i++)System.out.printf("%d ",kor[i]);
		
		System.out.println();
		System.out.println("영어 점수를 입력하세요");
		for(i=0; i<=2; i++) {
			k=sc.nextInt();
		eng[i]=k;
		}
		System.out.printf("3명의 영어 점수 : ");
		for(i=0; i<=2; i++)System.out.printf("%d ",eng[i]);

		System.out.println();
		System.out.println("수학 점수를 입력하세요");
			for(i=0; i<=2; i++) {
			l=sc.nextInt();
		mat[i]=l;
		}
		System.out.printf("3명의 수학 점수 : ");
		for(i=0; i<=2; i++)System.out.printf("%d ",mat[i]);
		
		System.out.println();
		
		System.out.printf("총점 : ");
		tot[i]=kor[i]+eng[i]+mat[i];
		for(i=0; i<=2; i++)System.out.printf("%d ",tot[i]);
		
		System.out.println();
		System.out.printf("평균 : ");
		avg[i]=tot[i]/3.0;
		for(i=0; i<=2; i++)System.out.printf("%d ",avg[i]);
		
		System.out.println("국어\t영어\t수학\t총점\t평균");
		for(i=0; i<=2; i++)System.out.printf("%d\t%d\t%d\t%d\t%d",kor[i],eng[i],mat[i],tot[i],avg[i]);
		
		System.out.println();
		
		
		
	}

}
