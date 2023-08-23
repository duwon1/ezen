package days14;

//예외(Exception)처리
//
//에러(Error) : 잘못된 것, 에러가 존재하는 경우 실행될 수 없음
//예외(Exception) : 잘못된 것, 특정 상황 또는 조건이 만족되는 경우 프로그램이 종료되는 현상
//예외는 다양한 상황에 대해서 발생하는 현상으로 모든 예외를 대처할 수 없음
//다만, 예외가 발생한 경우 프로그램이 종료되지 않고 저장과 같은 기능을 제공할 수 있어야함
//(예외가 발생해도 프로그램이 강제종료되지 않고 사용자에게 선택권 또는 처리기회를 주는 것을 뜻함)
//예외처리: 예외가 발생한 경우 프로그램이 강제 종료되지 않도록 방지하는 것

public class Exception01 {

	public static void main(String[] args) {

		//예외처리 방법
		//#1. 예외상황이 발생될 가능성이 있는 곳을 try{} catch{}로 감쌈
		//try 구문에 예외 발생 예상명령, catch구문에 예외발생시 처리하고 지나갈 명령을 넣음
		//예외가 발생돼 영향을 받을 명령어들도 try{}에 함께 넣어줌
		for(int i = 1 ; i<=10; i++) {
			int k = (int)(Math.random()*10);
			try {
			double result = 100/k;
			System.out.println(100+"÷"+k+"="+result);
			}catch(ArithmeticException e) { //예상되는 예외의 클래스 객체를 써줌
				System.out.println("0으로 나눴습니다");
			}catch(Exception e) {//예상되는 예외의 종류를 모르겠다면 모두를 섭렵하는 Exception으로 써줌
				e.printStackTrace(); //시스템 메세지로 에러내용을 표시하는 메서드 : 지금은 콘솔창에 표시함
			}
			//try에서 예외가 발생하면 예외의 발생한 예외의 종류와 catch에 제시한 예외종류가 일치하는지 봅니다
			//차례대로 비교해 일치하는 게 있다면 해당 구문 명령을 실행하고 없으면 그냥 지나감
			//Exception은 모든 예외와 일치할 수 있는 최상위 부모클래스이므로 가장 마지막에 써서 이도저도 해당되지 않을 때 실행되게 함
			
			//ArithmeticException : 수학적 예외
		}
	}

}
