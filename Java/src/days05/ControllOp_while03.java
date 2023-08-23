package days05;

import java.util.Scanner;

public class ControllOp_while03 {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		// 1. 컴퓨터가 내는 가위바위보를 랜덤하게 결정해 저장
//		double a =Math.random() ; //랜덤한 숫자를 소수점 아래의 숫자로 발생시킴
//		System.out.println((int)(a*3));
		
		while(true) {
		int comInt= (int)(Math.random()*3);
		String com;
		if(comInt==0)com = "가위";
		else if(comInt==1)com = "바위";
		else com="보";
		
		System.out.print("가위(1)/바위(2)/보(3)/종료(0) 중 하나를 입력하세요");
		int userInt = sc.nextInt();
		if(userInt==0)break;
		String user;
		if(userInt==1) user="가위";
		else if(userInt==2) user="바위";
		else user="보";
		
		System.out.println("컴퓨터 : "+com+" / User : "+ user);
		
		if( com.equals(user)) System.out.printf("무승부\n");
		else if((com.equals("가위") && user.equals("바위"))||
				 (com.equals("바위") && user.equals("보"))||
				 (com.equals("보")&& user.equals("가위"))) {System.out.println("승리"); break;
		 }else System.out.printf("패\n");
		}
	}

}
