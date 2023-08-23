package days08;

import java.util.Scanner;

public class Method13 {
	
	public static void main(String[] args) {
		
		int kor, eng, mat, tot;
		double ave;
		//String grade;
		
		kor = myInput(1); //점수입력
		eng = myInput(2);
		mat = myInput(3);
		
		tot= sum(kor, eng, mat); // 총점 계산
		ave=avg(kor, eng, mat); // 평균 계산
		
		prnTitle();
		prnScore(kor, eng, mat, tot, ave); 
		System.out.println("---------------------------------");
	}
	
	public static int myInput(int s) {
		if(s==1) System.out.printf("국어 : ");
		else if(s==2) System.out.printf("영어 : ");
		else System.out.printf("수학 : ");
		
		Scanner sc=new Scanner(System.in);
		return sc.nextInt();
	}
	
	public static int sum(int a, int b, int c) {
		return a+b+c;
	}
	public static double avg(int a, int b, int c) {
		return sum(a,b,c)/3.0;
	}
	
	public static void prnTitle() {
		System.out.println("\t###성적표###");
		System.out.println("---------------------------------");
		System.out.println("국어\t영어\t수학\t총점\t평균");
		System.out.println("---------------------------------");
	}
	public static void prnScore( int a, int b, int c, int d,double e) {
		System.out.printf("%d\t%d\t%d\t%d\t%.1f\n",a,b,c,d,e);
	}

}
