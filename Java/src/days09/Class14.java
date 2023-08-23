package days09;

class Cclass{
	private int age;
	Cclass(int i) {
		age=i;
	} // 1-2. 매개변수가 있는 생성자 정의

	Cclass(){
		age=100;
	} // 2-2. 디폴트 생성자를 오버로딩해 추가로 정의함
}

class Dclass {
	private int age;
	private String name;
	public Dclass() { //우클릭->source->generate constructor using fields->deselct로 generate
		super();
	}
	public Dclass(int age, String name) {//우클릭->source->generate constructor using fields->selct all로 generate
		super();
		this.age = age;
		this.name = name;
	}
}


public class Class14 {

	public static void main(String[] args) {
		
		Cclass c1 = new Cclass(20);
		Cclass c2 = new Cclass(30);
//		 1-1. 생성자에 전달인수를 만들고 다른 값을 전달해 객체마다 멤버변수의 초기값을 달리해 생성가능
		
		Cclass c3 = new Cclass(); //이건 에러. 이미 생성자가 생겼기 때문에 디폴트생성자는 불가능
//		2-1. 클래스 내부에 생성자가 꺼내져 매개변수를 사용할 경우, 매개변수가 없는 디폴트생성자는
//		새로 생성된 생성자로 대체돼 없는 생성자가 됨.
		
//		3. 디폴트생성자의 메서드 오버로딩을 통해 없어진 디폴트 생성자 문제를 해결가능
		
	}

}
