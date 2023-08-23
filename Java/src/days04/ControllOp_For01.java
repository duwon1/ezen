package days04;

public class ControllOp_For01 {

	public static void main(String[] args) {
		
		System.out.println("겁나 쉬운 자바 프로그래밍~~!!");
		System.out.println("겁나 쉬운 자바 프로그래밍~~!!");
		System.out.println("겁나 쉬운 자바 프로그래밍~~!!");
		
		//for 명령 : 반복 실행 명령
		// 사용형태
		/*
		for( ; ; ) {
			
		}
		*/
//		( ) 안에 반복의 횟수를 지정하는 문구를 양식에 맞춰서 입력
//		{} 안에 지정한 횟수만큼 반복할 명령(들)을 입력
//		
//		괄호 안에 ;으로 구분해서 세가지 내용을 기술함
//		 작성되는 세가지 내용은 반복횟수를 제어할 구성요소들로 채움
//		또한 반복되는 횟수는 특정 변수에 의해 제어됨
//		
//		첫번째 요소 : 반복을 제어할 "변수"의 최초값 대입 또는 변수의 생성하고 값을 대입하는 곳
//		두번재 요소 : 다음 반복을 계속할 지 안할지에 대한 관계(비교)연산식
//				(결과 true/false)-비교연산식의 결과가 true이면 반복을 계속하고,
//				false이면 반복을 멈추고 for영역을 빠져나옴
//		세번째 요소 : 반복 제어 변수의 증감 연산을 기술함
		System.out.println();
		
		int i;
		for(i=1;i<=10 ;i++ ) {
			System.out.println("겁나 쉬운 자바 프로그래밍~~!!");
		}
		System.out.println("i:"+i);
		//첫번째 요소 : i변수가 1을 최초로 갖고 반복이 시작됨
		//두번째 요소 : i값이 10보다 작거나 같은 경우 현재의 반복실행을 진행
		//세번째 요소 : 반복이 특정횟수를 실행하고 끝날수 있게 매 반복마다 계산할 i변수의 증감연산 실행
		// 1증가 i++ , 1감소 i--, 2증가 i=i+2 또는 i+=2, 2감소 i=i-2또는 i-=2
		// 매 반복마다 i++이 실행돼 i<=10이 false가 되는 순간 반복 멈춤
		System.out.println();
		
		// 열번 반복이 반드시 1부터 10일 필요x
		for(i=11;i<=20;i++)
			System.out.println("1. 자바 최고~!");
		//if와 마찬가지로 실행명령이 한개라면 중괄호 생략 가능
		System.out.println();
		for(i=101;i<=110;i++)
			System.out.println("2. 자바 최고~!");
		System.out.println();
		for(i=10;i>=1;i--)
			System.out.println("3. 자바 최고~!");
		System.out.println();
		for(i=0;i<=9 ;i++ ) System.out.println("4.겁나 쉬운 자바 프로그래밍~~!!");
		System.out.println();
		for(i=0;i<10 ;i++ ) System.out.println("5.겁나 쉬운 자바 프로그래밍~~!!");
		
		System.out.println();
		
		for( int k=1; k<=10; k++) {//이건 지엽변수라 중괄호 넘어가면 끝
			System.out.println("6.겁나 쉬운 자바 프로그래밍~~!!");
		}
		//변수는 자신을 선언한 영역(중괄호)를 벗어나면 변수도 소멸
		//반복실행에 사용한 변수가 반복실행 밖에서 그 최종값을 활용할 일이 없다면 for문 안에 지엽변수 생성&초기화해서 사용
		//반대의 경우는 반복문 밖에서 반드시 변수 선언하고 사용해야 함
		System.out.println(i);//정상실행
//		System.out.println(k);//에러남
	}

}
