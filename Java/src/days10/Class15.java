package days10;

class Eclass{

	Eclass() {
		System.out.println("Eclass 클래스의 디폴트 생성자 호출");
	}

	public Eclass(int i) {
		System.out.println("Eclass 클래스의 int 타입 매개변수를 전달받는 생성자 호출");
	}


	public Eclass(double d) {
		System.out.println("Eclass 클래스의 double 타입 매개변수를 전달받는 생성자 호출");
	}
	
}

public class Class15 {

	public static void main(String[] args) {
		
		Eclass e1 =  new Eclass();
		Eclass e2 =  new Eclass(10);
		Eclass e3 =  new Eclass(10.22);
// 위와 같은 실행이 가능하도록 Eclass의 생성자들을 만들어주세요
// 생성자에서는 각각 어떤 매개변수가 있는 생성자인지 출력되게 코딩하기
//		예) System.out.println("Eclass 클래스의 디폴트 생성자 호출");
//		System.out.println("Eclass 클래스의 int 타입 매개변수를 전달받는 생성자 호출");
//		System.out.println("Eclass 클래스의 double 타입 매개변수를 전달받는 생성자 호출");
		
	}

}
