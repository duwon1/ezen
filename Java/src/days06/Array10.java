package days06;

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
		int i;	
		// 2. 컴퓨터가 사용자에게 공개하지 않은 숫자 세개를 발생, com배열에 저장. 중복x
		
		for(i=0; i<3; i++) {
			com[i]=(int)(Math.random()*10);
			int count = 0;
			for(int j=0; j<i; j++) {
				if(com[i]==com[j]) count++;
			}
			if(count>0) { i--;}
			System.out.printf("%d ", com[i]);
		}
		
			
		// 3. 사용자에게서 세개의 숫자(0~9)를 입력받아서 user에 저장
		int s;
		int b;
		do {
			System.out.println("숫자(0~9)를 입력하세요 : ");
			for(i=0; i<3; i++) {
			user[i] = sc.nextInt();
			} //여기 이상함
			 System.out.printf("입력하신 숫자는 ");
			for(i=0; i<3; i++) System.out.printf("%d ", user[i]);
		
			System.out.println();
		
		// 4. com 과 user 배열의 각 요소들을 서로 서로 비교해서 같은 값이 있는지, 자리는 같은지 다른지 판단해서 
		//S와 B를 예시처럼 출력
			s=0;
			b=0;
			for(i=0;i<3; i++) {
				if(user[i]==com[i]) {
					s++;
				}
				
				for(int j=0; j<3; j++) {
							if(((i-j)!=0)&&(user[j]==com[i])) b++;
							
					
				}
			}
			System.out.printf("결과는 %dS %dB", s, b);
			System.out.println();
		}while(s!=3);
		
		if(s==3) System.out.println("정답입니다.");
		// 5. 맞출 때까지 ( 3S 0B) 2~4까지를 반복하기
		
		
	}

}
