package days03;

import java.util.Scanner;

public class ControllOp_IF01 {

	public static void main(String[] args) {
		
//		정수를 하나 입력받아서 짝수이면 "짝수입니다", 홀수면 "홀수입니다" 라고 출력하기
		Scanner sc =new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		int a = num %2;
		boolean b= a ==0;
		// true/false 가 선택 저장될 연산 ==, !=, > .. 등 이지만
		// 짝수입니다/홀수입니다 를 선택저장할 연산이 현재 없음
		// if를 쓰면 가능
		
		// if = 관계(비교)연산 결과에 의해서 지정한 명령의 실행유무를 결정하는 명령
		if(a==0) {
		System.out.println("짝수입니다");
		}
		// 관계연산 또는 그 결과값은 () 괄호안에, 실행할 지 안할 지의 명령들은 {} 괄호 안에 넣어줌
		if(a!=0) {
		System.out.println("홀수입니다");
		}
		
//		if문의 특징
//		()안의 연산결과 또는 값이 true이면 {}안의 명령을 실행, false이면 실행x
//		()안의 값이 true이면 실행할 명령이 두개 이상일 수 있어서 {}로 경계 구분
//		()안의 값이 true일 때 실행할 명령이 한개라면, {} 생략 가능
//		만약 ()안에 일부러 true를 썼다면 -> if(true) {} ->{}안의 내용은 무조건 실행
//		반대의 경우 if(false) {}면 실행없이 건너뜀
//		()안에는 비교연산과 논리연산이 조합된 복합연산식 표현이 가능
//		ex) if((x==0))&&(y!=0)||(z==0)){}
//		()안에 비교연산 대신 true/false 값을 갖고 있는 boolean 변수도 들어갈 수 있음
		
		boolean result = a ==0;
		if(result) System.out.println("짝수입니다");
		if( num%2==0)System.out.println("짝수입니다");
		if(result==true)System.out.println("짝수입니다");
		
		if(result==false)System.out.println("홀수입니다");
		if(!result)System.out.println("홀수입니다");
		//a==0의 결과가 false일 때 if에 귀속된 명령상태
		if(a%2!=0)System.out.println("홀수입니다");
		if(!(a%2==0))System.out.println("홀수입니다");
		if(a!=0)System.out.println("홀수입니다");
		
	
		
		
		
	}

}
