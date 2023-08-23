package days03;

import java.util.Scanner;

public class ControllOp_IF02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("정수를 입력하세요: ");
		int a = sc.nextInt();
		int b = a%2;
		
		if( b==0) {
			System.out.println("입력한 정수는 짝수(even)입니다");
			b = 1;
		}else {
			System.out.println("입력한 정수는 홀수(odd)입니다");
		}
		
		int kor =70, eng=98, mat=95;
		double avg = (kor+eng+mat)/3.0;
		//평균이 80이상이면 합격 아님 불합
		
		if(avg>=80)
			System.out.println("합격입니다");
		else 
			System.out.println("불합격입니다");
		
		//평균 60이상이거나 영어 80이상이면 합격
		if((avg>=60)||(eng>=80))
			System.out.println("합격");
		else
			System.out.println("불합격");
	
	
	//년도 하나를 입력받아서 변수에 저장하고 입력한 년도가 윤년인지 평년인지를 출력하도록 if문을 작성
	System.out.printf("년도를 입력하세요 : ");
	int year = sc.nextInt();
	if((year%4==0)&&(year%100!=0)||(year%400==0))
		System.out.println("윤년입니다.");
	else
		System.out.println("평년입니다.");
	
	

}
}
