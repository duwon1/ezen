package days11;

//메서드 오버라이딩
//
//1. 각각의 클래스에서 발견되는 공통 변수, 메서드 등을 하나의 클래스로 만들어 다른 클래스에게 물려주는 것이 "상속"임
//2. 부모클래스 정의되는 변수, 또는 메서드들은 모든 자식클래스에서도 정상적으로 동작해야 하므로 부모자식에 공통으로 
//적용할 수 있는 사항들이 정의되곤 함
//3. 하지만 가끔은 상속받은 메서드들이 자식 클래스의 생성 목적이나 용도에 따라 어룰리지 않는 메서드일 가능성이 있음
//4. 이를 위해서 자식클래서에 물려받은 부모클래스의 메서드를 재정의해 사용하는데 이것이 "메서드 오버라이딩"임

class Animal{
	int leg;
	int name;
	
	public void crying() {
		System.out.println("소리를 냅니다");
	}
}

class Dog extends Animal{
	public void sound() {
		System.out.println("멍멍~!!");
	}
	
	//자식 클래스는 부모클래스에서 물려받은 메서드를 자신의 용도에 맞게 재정의(overriding)할 수 있음
	//메서드 오버라이딩은 자식클래스에서 부모클래스의 메서드 내용을 다시 정의하는 문법임
	//메서드 오버라이딩으로 메서드를 재정의해서 자식클래스의 객체에서 사용하면 
	//물려받은 메서드는 무시되고 새로 재정의한 메서드 실행
	public void crying() {//반드시 메서드의 이름과 리턴 자료형등이 같아야 함
		//부모의 재정의되기 전 crying() 메서드를 일부러 호출하는 것도 가능
		super.crying();
		System.out.println("멍멍~!");
	}
}

class Cat extends Animal{
	public void crying() {
		System.out.println("야옹~!");
	}
}
public class Extends08 {

	public static void main(String[] args) {
		
		Dog d = new Dog();
		d.crying();
		d.sound();
		Cat c = new Cat();
		c.crying();
	}

}

//메서드 오버라이딩
//1. 메서드 이름이 동일해야함
//2. 메서드 매개변수 타입, 개수, 순서 ,리턴값 등이 다를 경우 다른 메서드로 인식
//3. 부모클래스의 메서드 원형(리턴, 매개변수 타입, 개수, 순서 등)이 일치해야함
//4. 상속관계에서만 사용 가능
//5. 접근지정자는 축소될 수 없음(public->private X)
//6. 부모클래스 메서드가 final로 정의되었다면 오버라이딩 할 수 없음
//7. super.crying()처럼 super키워드를 이용해 오버라이딩 되기 전 부모메서드를 호출,실행할 수 있음
//8. 클래스의 외부에서는 super라는 말을 쓸 수 없으므로, 생성된 객체에 super을 붙여서 사용X
// ex)Cat 클래스의 객체 c를 이용해 c.super.crying()<-에러
