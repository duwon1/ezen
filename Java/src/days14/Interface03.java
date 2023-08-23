package days14;


interface InterSuper1{
	void InterSuper1_Test();
}
interface InterSuper2{
	void InterSuper2_Test();
}

//인터페이스를 implements한다는 것은 부모인터페이스에 있는 추상메서드를 자식클래스에서 내용을 채우고,
//더이상 추상메서드가 아닌 완벽한 메서드로 완성한다는 뜻. 반드시 오버라이드를 해야함
//
//그러나 인터페이스들끼리의 상속은 상속받는 곳도 인터페이스이기 때문에 (아직 implements하기 전)
//구현의 implements 의미보단 상속 extends의 의미로 물려주는 관계가 가능함
//☆☆☆☆☆인터페이스끼리의 extends는 추상메서드의 override의무는 면제됨
//☆☆☆☆☆또한 인터페이스들끼리 다중상속(extends)이 가능함

interface InterSub extends InterSuper1, InterSuper2{
//	상속받았기 때문에 (구현하지 않고 물려받았기 때문에 ) 아래와 같이 추상메서드가 존재
//	public abstract void InterSuper1_Test(); InterSuper1에서 상속받은 추상메서드
//	public abstract void InterSuper2_Test(); InterSuper2에서 상속받은 추상메서드
	public abstract void InterSub_Test(); //InterSub 인터페이스 자체의 추상메서드
}

//InterSub를 implements한 클래스는 InterSub가 보유하고 있는 세개의 추상메서드를 모두 오버라이딩 해야함

class SubC2 implements InterSub{
	public void InterSuper1_Test() {	}
	public void InterSuper2_Test() {	}
	public void InterSub_Test() {	}
}

//두개 이상의 인터페이스를 implements한 클래스는 그들에게 있는 추상메서드를 모두 오버라이딩 함
class SubC1 implements InterSuper1,InterSuper2{
	public void InterSuper1_Test() {	}
	public void InterSuper2_Test() {	}
}
public class Interface03 {

	public static void main(String[] args) {
		
		SubC2 c2 = new SubC2();//원래 자식객체
		SubC1 c1 = new SubC1();//원래 자식객체
		// InterSub(추상메서드 3개 보유)를 implement한 자식객체를 InterSuper1 참조변수에 저장 
		InterSuper1 s1 = new SubC2(); 
		s1.InterSuper1_Test();// 사용가능

		// InterSub(추상메서드 3개 보유)를 implement한 자식객체를 InterSuper2 참조변수에 저장 
		InterSuper2 s2 = new SubC2(); 
		s2.InterSuper2_Test(); //이것만 사용가능
		
		// InterSub(추상메서드 3개 보유)를 implement한 자식객체를 InterSuper3 참조변수에 저장 
		InterSub s3 = new SubC2(); 
		s3.InterSub_Test(); //세개의 멤버메서드 모두 사용 가능
		s3.InterSuper1_Test();//세개의 멤버메서드 모두 사용 가능
		s3.InterSuper2_Test();//세개의 멤버메서드 모두 사용 가능
	
		
//		s1.InterSub_Test(); //에러
//		s1.InterSuper1_Test(); //에러
//		s2.InterSub_Test(); //에러
//		s2.InterSuper1_Test(); //에러
		
		//InterSuper1 과 InterSuper2를 다중상속한 SubC1의 객체를 InterSuper1 부모참조변수와 InterSuper2 참조변수에 저장
		InterSuper1 s4 = new SubC1();
		InterSuper2 s5 = new SubC1();
//		InterSub s3 = new SubC1();//error - SubC1은 InterSub를 상속하지 않았으므로 에러
		
		//InterSuper1과 InterSuper2각자가 물려준 메서드 호출 가능
		s4.InterSuper1_Test();
		s5.InterSuper2_Test();
		//각자가 물려주지 않은 메서드는 호출 불가능
//		s4.InterSuper2_Test(); //에러
//		s5.InterSuper1_Test(); //에러
		
//		c1 : InterSuper1과 InterSuper2를 implement한 SubC1의 객체
//		c2 : InterSuper1, InterSuper2와 InterSub를 implement한 SubC2의 객체
		test1(c2);
		test1(c1);
		
		test2(c2);
		test2(c1);
		
		test3(c2);
		//test3(c1); //c1은 SubC1클래스의 객체이며, InterSub인터페이스를 상속(구현)하지 않았음
	}
	public static void test1(InterSuper1 i1) {
		i1.InterSuper1_Test();
	}
	public static void test2(InterSuper2 i2) {
		i2.InterSuper2_Test();
	}
	public static void test3(InterSub i3) {
		i3.InterSub_Test();
		i3.InterSuper1_Test();
		i3.InterSuper2_Test();
	}
}
