package days11;

//클래스들 간의 Extends(상속)
//다수개의 클래스들이 중복되는 멤버변수 및 멤버메서드를 갖고 있는 경우
//부모자식관계를 생성해 "코드의 중복을 방지"하는 것을 1차 목표로 사용
//2차 목표는 "코드의 재활용"이며, 코드의 중복이 발생하고 있는 클래스에서 
//중복되는 멤버들을 별도의 클래스로 생성하고 상속 구현

//코드의 중복이 발생하고 있는 클래스들
class PersonA{
	String name;
	int age;
	String stdNum; //학번
}
class PersonB{
	String name;
	int age;
	String empNum; //사번
}

//상속의 구현
class Person{
	String name;
	int age;
}//중복되는 멤버변수들이나 메서드 등 그들의 생성코드를 구성요소로 한 부모클래스 생성

// 부모의 멤버들을 상속할 자식클래스 생성
class PersonC extends Person{
//	부모의 멤버들을 상속한 클래스에는 별도의 언급이 없어도 부모의 멤버변수/메서드가 있는 것으로 인식
	String stdNum;
}
class PersonD extends Person{
	String empNum;
}

public class Extends01 {

	public static void main(String[] args) {
		
		PersonC c = new PersonC();
		PersonD d = new PersonD();
		
		c.name = "홍길동";
		c.age = 30;
		
		d.name="홍길서";
		d.age=28;
		
		System.out.println(c.name);
		System.out.println(c.age);
		System.out.println(d.name);
		System.out.println(d.age);
	}
}
