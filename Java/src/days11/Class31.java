package days11;

class InitBlock{
	private int number;
	private static int num =1;
//	일반 초기화 블럭 : 객체 생성 시 실행 (생성자와 성격이 비슷)
//	단순 값으로 초기화하는 경우 대입연산자를 통해서 처리할 수 있지만, 
//	실행문이 포함된 초기화를 진행하는 경우 아래와 같이 초기화과정 정의
	{
		number = 100;
		System.out.println("인스턴스 변수 초기화 용 초기화 블럭1");
	}
	InitBlock(){
		System.out.println("생성자 호출");
		num=55;
	}
//	static 초기화 블럭 : static 멤버를 초기화하기 위한 영역 
//	단순 값으로 초기화하는 경우 대입연산자를 통해서 처리할 수 있지만, 
//	실행문이 포함된 초기화를 진행하는 경우 아래와 같이 초기화과정 정의
	static {
		System.out.println("StaticF의 static블럭 실행");
		num=55;
	}
//	static 블럭은 객체 생성명령을 만나면 생성자 실행 이전에 실행됨
//	
//	일반 초기화블럭에서는 스태틱 멤버에 접근이 자유롭게 가능
//	스태틱 초기화 블럭에서 인스턴스 멤버접근은 제한됨
}
public class Class31 {

	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		InitBlock f = new InitBlock();
		//실행 순서: static초기화 블럭->인스턴스 초기화 블럭(객체생성시 실행)->생성자
	}

}
