package days06;

import java.util.Scanner;

public class Array05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("성적표에 출력될 학생이 몇명인가요?");
		int stdNum = Integer.parseInt( sc.nextLine());
		
		// 세명의 학생의 세과목 점수를 입력 받고 총점 평균을 계산해서 성적표를 출력하라
		int [] kor = new int[stdNum]; //국어 점수 저장용 배열
		int [] eng = new int[stdNum];
		int [] mat = new int[stdNum];
		int [] tot = new int[stdNum];
		double [] avg = new double[stdNum];
		String[] name = new String[stdNum]; //학생 이름용
		
		
//		for(int i=0;i<3;i++) {
//			System.out.printf("%d번학생의 이름입력 : ", i+1);
//			name[i]=sc.nextLine();
//			System.out.printf("%d번학생의 국어점수입력 : ", i+1);
//			kor[i]=sc.nextInt();
//			System.out.printf("%d번학생의 영어점수입력 : ", i+1);
//			eng[i]=sc.nextInt();
//			System.out.printf("%d번학생의 수학점수입력 : ", i+1);
//			mat[i]=sc.nextInt();
//		}
		//이렇게 하니까 1번학생이름밖에 못넣음;
		//해결방법 1번
//		for(int i=0;i<3;i++) {
//			System.out.printf("%d번학생의 이름입력 : ", i+1);
//			name[i]=sc.nextLine();
//			System.out.printf("%d번학생의 국어점수입력 : ", i+1);
//			kor[i]=sc.nextInt();
//			System.out.printf("%d번학생의 영어점수입력 : ", i+1);
//			eng[i]=sc.nextInt();
//			System.out.printf("%d번학생의 수학점수입력 : ", i+1);
//			mat[i]=sc.nextInt();
//			sc.nextLine(); //단기적인 방법
			
			//2번 방법
			for(int i=0;i<stdNum;i++) {
//				for(int i=0;i<kor.length;i++) { //이렇게도 가능
				System.out.printf("%d번학생의 이름입력 : ", i+1);
				name[i]=sc.nextLine();
				System.out.printf("%d번학생의 국어점수입력 : ", i+1);
//				String k = sc.nextLine();
//				kor[i]=Integer.parseInt(k); //이 두 줄을 한 줄로 줄인게 밑의 줄
				kor[i]=Integer.parseInt( sc.nextLine());
				System.out.printf("%d번학생의 영어점수입력 : ", i+1);
				eng[i]=Integer.parseInt( sc.nextLine());
				System.out.printf("%d번학생의 수학점수입력 : ", i+1);
				mat[i]=Integer.parseInt( sc.nextLine());
			}
				//숫자와 문자가 입력될 경우가 많은 경우
			
			
			
		for(int i=0; i<stdNum; i++) {
			tot[i]=kor[i]+eng[i]+mat[i];
			avg[i]=tot[i]/3.0;
		}

		System.out.println("\t\t ###성적표###");
		System.out.println("------------------------------------------");
		System.out.println("번호\t이름\t\t국어\t영어\t수학\t총점\t평균");
		System.out.println("------------------------------------------");
		for(int i=0; i<avg.length; i++) {
			System.out.printf("%d\t%s\t\t%d\t%d\t%d\t%d\t%.1f\n", i+1, name[i], kor[i],eng[i],mat[i],tot[i],avg[i]);
		}
		System.out.println("------------------------------------------");
	}

}
