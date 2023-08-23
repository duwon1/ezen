package days14;

class Animal{
	//멤버변수1
	int age;
	//멤버메서드1
	public void crying() {
		System.out.println("울음 소리~");
	}
}
class Dog extends Animal{
	//멤버변수1-상속
	//멤버메서드1-상속
	//멤버메서드 재정의(overriding)
	public void crying() {
		System.out.println("멍멍!");
	}
}
class Cat extends Animal{
	//멤버변수1-상속
	//멤버메서드1-상속
}

//추상클래스
//상속을 통한 다형성(여러 형태의 "자식 클래스의 객체 생성 &활용 &메서드오버라이딩&type casting)의 구현에 
//강제성(메서드 오버라이딩)을 부여하기 위한 클래스
//
//상속의 문제점 : 강제성의 부재
//상속을 통해 다형성(부모클래스를 상속받아 여러 형태의 자식 클래스를 생성하고 활용함)을
//구현하고자 하여도, 하위클래스에서 메소드 오버라이딩을 구현하지 않으면 다형성을 완벽히 구현할 수 없음
public class Abstract01 {

	public static void main(String[] args) {

		Dog d = new Dog();
		d.crying();
		
		Cat c = new Cat();
		c.crying();
	}
}
