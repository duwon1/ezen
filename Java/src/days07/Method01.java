package days07;


//Method : Function 이라고도 부르며 간헐적으로 반복되는 코드들을 별도로 정의(작성)해놓고, 
//정해놓은 이름으로 그 코드들을 이름불러 실행하는 단위실행코드들.
//Java 에선 Function보다 Method라고 주로 부름

//특징
//1. 명령들이 모여서 기능을 정의하는 단위.
//2. 일련의 실행코드(명령)들을 묶어서 재활용하는 것이 제 1목적
//3. 메서드는 각 메서드마다 고유한 이름이 있음
//4. 메서드가 이름이 불려져 실행되라는 명령(Call-호출)을 받으면, 그 메서드의 몸체를 이루는 코드들이 실행되는 형식
//5. 자바의 메서드는 이름 옆에 항상 괄호()를 달고 나옴

//메서드의 생성 : 반드시 클래스의 내부에서만 만들 수 있음
//main 메서드 위쪽 또는 아래쪽에 만들 수 있음

public class Method01 {
	
	//메서드 생성 가능 위치

	public static void main(String[] args) {
		System.out.println("프로그램이 시작되었습니다---------------");
		System.out.println("main 메서드가 실행되고 있어요---------------");
		
		System.out.println("\n@ abc 메서드가 호출됩니다. ");
		abc(); //abc 메서드의 호출
		// 메서드가 호출되면 호출된 메서드의 몸체로 포커스가 이동되어 그 몸체를 모두 실행하고 원래 자리로 되돌아옴
		System.out.println("@ abc 메서드를 실행하고 돌아왔습니다");
		
		System.out.println("아직 main 메서드가 실행중입니다---------------");
		abc();
		System.out.println("main 메서드 실행중-------------");
		abc();
		System.out.println("프로그램 종료-----------");
		
	}
	
	//메서드 생성 가능 위치
	
//	메서드의 정의
	public static void abc() {
		System.out.println("첫번째 Print 메서드가 실행되고 있어요~~!!");
		System.out.println("두번째 Print 메서드가 실행되고 있어요~~!!");
		System.out.println("세번째 Print 메서드가 실행되고 있어요~~!!");
		System.out.println("네번째 Print 메서드가 실행되고 있어요~~!!");
		
	}
//	public static void : 메서드 정의할 때 앞에 붙이는 문법 요소같은 것
//	개발자가 정의한 메서드는 이름도 개발자 맘대로 필요한 이름으로 정의함
//	개발자가 정의한 메서드는 주로 main에서 간혹 다른 메서드에서 호출함

}
