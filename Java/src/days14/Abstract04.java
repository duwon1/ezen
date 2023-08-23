package days14;

//추상 클래스의 단점
//추상 메소드 구현의 강제성이 아래의 경우 단점이 될 수 있음
//추상 메소드의 개수가 과도하게 많으면 상속에 부담을 주게 됨
//자식 클래스에서 사용하지 않을 추상메소드라도, 객체 생성을 위해 반드시 구현(overriding)해야함

abstract class AbstractA{
	abstract void test1();
	abstract void test2();
	abstract void test3();
	abstract void test4();
	abstract void test5();
	abstract void test6();
	abstract void test7();
}

class Sub1 extends AbstractA{
	@Override
	void test1() {	}
	void test2() {	}
	void test3() {	}
	void test4() {	}
	void test5() {	}
	void test6() {	}
	void test7() {	}
}

//이 추상클래스를 자주 사용할 예정이라면, 모든 추상메서드가 구현된 Adapter클래스를 생성하고,
//그 어댑터 클래스를 상속받아 사용하면 필요없는 메서드를 강제 구현하지 않고 필요한 것만 구현해 사용가능

class Adapter extends AbstractA{
	void test1() {	}
	void test2() {	}
	void test3() {	}
	void test4() {	}
	void test5() {	}
	void test6() {	}
	void test7() {	}
}

class Sub2 extends Adapter{
	public void test1() {
		System.out.println("test1 overriding~!");
	}
}
public class Abstract04 {
	
	public static void main(String[] args) {
		//어댑터 클래스를 상속받은 클래스도 추상클래스의 자식클래스가 됨
		AbstractA obj = new Sub2();
		obj.test1();
		// 조상과 손주 간 다형성을 구현해 물려주고 오버라이딩 된 메서드를 조상 레퍼런스가 사용가능

	}

}
