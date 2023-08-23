package days07;

import java.util.Scanner;

public class Array10 {

	public static void main(String[] args) {
		
//		야구 게임 프로그램
//		컴퓨터가 나에게 알려주지 않은 숫자를 질문과 답변을 통해 맞춰감
//		사용자에게 알려주지 않은 숫자 : 6 5 7 같은 한자시 숫자 세개를 준비하고
//		질문 : 3 6 7 같은 한자리 숫자 세개를 입력받아 비교
//		답변 : 같은 숫자가 자리수까지 같으면 S 숫자만 같으면 B
//		숫자 하나는 0~9까지... 세개의 숫자 중 중복 숫자 없음
//		컴퓨터가 갖고 있는 숫자 : 5 6 8
//		사용자 질문 : 4 5 8
//		답변 -> 1S 1B
		
		Scanner sc = new Scanner(System.in);
		//1. 컴퓨터 숫자 배열, 사용자 숫자 배열 생성
		int [] com= new int[3];
		int [] user= new int[3];
		// 2. 컴퓨터가 사용자에게 공개하지 않은 숫자 세개를 발생, com배열에 저장. 중복x
		
		int i=0;	
		int j;
		while ( i<com.length) {
			com[i]=(int)(Math.random()*10);
			// 방금 결정된 숫자가 i번째이고, 0번째부터 i-1번째까지의 숫자와 중복된 값이 있는 지 검사
			for(j=0; j<i; j++) {
				if(com[i]==com[j]) break; // 검사도중 같은 값이 나오면 바로 반복 종료
			} 
			// 같은 값이 있었다면 0~i-1 까지 가다가 중간에 멈췄을 것이고 
			// 같은 값이 없었다면 j는 i와 같은 값에서 종료되었을 것임
			
			if( i==j ) i++; //현재 숫자와 이전 숫자사이에 같은 값이 없었다면 다음 숫자를 위해 i가 1증가
			//이부분 지금 뭔소리인지 모르겠음
		}
//		System.out.println(com[0]+" "+com[1]+" "+com[2]);
		
		// 3. 사용자에게서 세개의 숫자(0~9)를 입력받아서 user에 저장
		// 입력 방법 #1 -> 불편함
//		System.out.println("반드시 한자리숫자를 입력하세요 : ");
//		user[0] = Integer.parseInt(sc.nextLine());
//		System.out.println("반드시 한자리숫자를 입력하세요 : ");
//		user[1] = Integer.parseInt(sc.nextLine());
//		System.out.println("반드시 한자리숫자를 입력하세요 : ");
//		user[2] = Integer.parseInt(sc.nextLine());
		
		
		// 입력 방법 #2
//		System.out.print("세자리 숫자를 중복되지 않게 입력 : ");
//		int num = Integer.parseInt(sc.nextLine());
//		user[0] = num/100; // 123/100->1
//		user[1] = (num%100)/10; // 23/10 -> 2
//		user[2] = (num%10); // 123%10 -> 3
		
		// 입력 방법 #3
		int s, b;
		do {
			System.out.print("세자리 숫자를 중복되지 않게 입력 : ");
			String num = sc.nextLine(); //456
			user[0] = num.charAt(0) - '0'; // String에서 char 하나를 뽑아냄 '4' - '0' -> 4 =>char을 int로 바꾸는 방법임
			user[1] = num.charAt(1) - '0'; // '5' - '0' -> 4 =>char을 int로 바꾸는 방법임
			user[2] = num.charAt(2) - '0'; // '6' - '0' -> 4 =>char을 int로 바꾸는 방법임
			
			System.out.println(user[0]+" "+user[1]+" "+user[2]);
			
			// 4. com 과 user 배열의 각 요소들을 서로 서로 비교해서 같은 값이 있는지, 자리는 같은지 다른지 판단해서 
			//S와 B를 예시처럼 출력
			s=0;
			b=0;
			for(i=0; i<com.length; i++) {
				for(j=0; j<user.length; j++) {
					if ( com[i]==user[j]) {
						if(i==j) s++;
						else b++;
					}
				}
			}
			System.out.println(s + " Strike "+b+ " Ball");
		
		}while(s!=3);  
		System.out.println("맞췄습니다. 프로그램을 종료합니다.");
		// 5. 맞출 때까지 ( 3S 0B) 3~4까지를 반복하기
		
		
	}

}
