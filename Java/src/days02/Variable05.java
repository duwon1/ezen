package days02;

import java.util.Scanner;

public class Variable05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int kor, eng, mat, total ;
		double average;
		String name;
		
		System.out.println("이름을 입력하세요 : ");
		name = sc.next();
		System.out.println("국어점수를 입력하세요 : ");
		kor=sc.nextInt();
		System.out.println("영어점수를 입력하세요 : ");
		eng=sc.nextInt();
		System.out.println("수학점수를 입력하세요 : ");
		mat=sc.nextInt();
		
		total = kor+eng+mat;
		average = total/3;
		System.out.println("\t\t###성적표###");
		System.out.println("------------------------------------------------");
		System.out.println("번호\t이름\t\t국어\t영어\t수학\t총점\t평균");
		System.out.println("------------------------------------------------");
		System.out.printf("%d\t%s\t\t%d\t%d\t%d\t%d\t%.1f\n",
				1, name, kor, eng, mat, total, average);
		System.out.println("2\t"+ name + "\t\t"+kor+"\t"+eng+"\t"
				+mat+"\t"+total+"\t"+(int)(average*100)/100.0);
		System.out.println("------------------------------------------------");
			}

}
