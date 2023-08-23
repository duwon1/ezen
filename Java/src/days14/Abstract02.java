package days14;

//추상 클래스 작성방법
//클래스 생성구문 앞에 abstract 키워드를 붙여서 생성함
//추상메서드를 포함한 클래스: 추상 메서드를 하나이상 포함하면 추상클래스라고 부름
//추상메서드 : 메소드의 원형만 존재하고 실제 내용이 없는 메서드

abstract class AbstractAnimal{
	public abstract void crying();
	//메서드의 원형만 있고, 메서드의 body(몸체)구현은 없음
}

//추상 메서드 작성방법
//접근지정자 abstract 리턴값의 타입 메소드명(매개변수);
//추상클래스는 일반 클래스와 동일하게 일반 멤버변수, 일반 메소드, 생성자 등을 포함할 수 있음
//단, 추상 메소드를 포함할 수 있는 특징이 추가된 클래스
//추상클래스는 상속을 통한 다형성 구현을 위해 생성됨

class DogA extends AbstractAnimal{
	public void crying() {
		System.out.println("멍!멍!");
	};
	
}
class CatA extends AbstractAnimal{

//	@Override //annotation-자바에 사용되는 변수나 메서드에 명찰처럼 사용되는 표시
	//annotation은 명령은 아님. 다만 필요한 곳에 표시를 해서 JVM이 프로그램 구성이나 준비동작에 도움이 되도록 하는 표식
	//annotation은 Override말고도 다양한 표시가 있음
	@Override
	public void crying() {
		System.out.println("애옹~");
	}
}

//추상클래스를 상속받은 자식클래스는 반드시 물려받은 추상메서드를 오버라이드 해야 에러가 발생하지 않음
//->오버라이딩에 강제성 부여


public class Abstract02 {

	public static void main(String[] args) {
//		AbstractAnimal a = new AbstractAnimal(); //에러 추상클래스로 객체생성 안됨
		
		DogA d1=new DogA();
		CatA c1 = new CatA();
		d1.crying();
		c1.crying();
		
		AbstractAnimal a; // new AbstractAnimal()을 이용해 객체는 만들지 못하지만 참조변수 생성 가능
		//추상 클래스가 공통의 요소를 모아서 생성되고, 상속을 받은 케이스이므로 이들은 분명한 부모클래스임
		//★★★상속 다형성 규칙 중 하나★★★
		//부모 클래스의 참조변수에 자식클래스의 인스턴스 주소를 저장할 수 있음
		AbstractAnimal a1 = new DogA();
		AbstractAnimal a2 = new CatA();
		
		//★★★상속 다형성 규칙 중 둘★★★
		//자식 클래스의 인스턴스 주소를 저장하고 있는 부모 참조변수는 물려준 멤버변수와 물려준 멤버메서드만 접근이 가능함
		//자식 클래스의 인스턴스 주소를 저장하고 있는 부모 참조변수는 자식클래스가 새로 만든 멤버엔 접근이 불가능
		//자식 인스턴스의 주소를 저장하고 있는 부모참조변수로 물려준 메서드를 실행하면, 오버라이딩이 된 자식메서드가 실행됨
		a1.crying();
		a2.crying();
	}

}
