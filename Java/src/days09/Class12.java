package days09;

//생성자(Constructor)
//클래스의 객체가 생성될 때, 멤버필드의 초기화 등의 목적으로 사용되는 메서드
//new에 각각의 객체가 생성될 때, 서로 다른 메모리를 할당해서 서로 겹치지 않게 하는 기능도 포함됩니다
//
//생성자의 특징
//1. 멤버메서드임(특별한 멤버메서드-처음 객체생성시만 호출, 중간에 호출되지 않음)
//2. 클래스의 이름과 동일한 이름을 갖는 메서드
//3. 리턴값이 없는 메서드
//4. 따로 정의(생성)하지 않아도 이미 클래스 내부에 존재하는 메서드
//5. 생성자는 각각의 객체가 생성될 때마다 호출되는 메서드
//6. 주로 하는 일은 new와 함께 객체가 저장될 Heap메모리를 할당하고 그안에 멤버변수를 만드는 일을 함

class Aclass{
	private int age;
	Aclass(){//public은 생략 가능 return이 없기 때문에 return자료형(void, int, double등)은 쓰지 않음
		age = 100; //멤버변수의 초기값을 변경해 운영하도록 할 수 있음
		System.out.println("객체가 생성되었습니다. Aclass 생성자가 호출되었습니다");
		
	}
	// 생성자도 별도의 기능이 있는 특별한 메소드일 뿐, 생성자가 클래스 내부에 기술된다고 해서 다른 메서드에 영향을 미치지 않음
	// 기존처럼 다른 메서드는 자유롭게 생성 사용가능
	public int getAge() { return age;}
	public void setAge(int age) { this.age=age;}
}
public class Class12 {

	public static void main(String[] args) {
		
		Aclass a1 =new Aclass();
		// 클래스의 참조변수에 실제로 생성된 클래스 형태의 메모리가 할당됨
		// 새롭게 new와 생성자에 의해 할당된 객체(메모리)를 앞으로 뉴인스턴스라고 부름
		// 여기서 Aclass()라는 생성자가 호출됨
		// 객체가 만들어질때만 호출되기 때문에 다른 메서드처럼 호출객체와 함께 사용되지 않음
		// a.Aclass(); X
		
		System.out.println("A1 객체의 age값은 "+a1.getAge()+"입니다");
	}
}
