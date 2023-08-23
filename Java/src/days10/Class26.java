package days10;
//instance 변수는 static 변수값으로 초기화 o
//instance 변수를 instance 변수로 초기화o
//static 변수를 static 변수값으로 초기화o
//static 변수를 instance 변수값으로 초기화 x
//-------------------------------------------
//instance 메서드는 static 변수 사용o
//instance 메서드는 instance 변수 사용o
//static 메서드는 static 변수 사용o
//static 메서드는 instance 변수 사용x
//-------------------------------------------
//instance 메서드안에서 static 메서드 호출o
//instance 메서드안에서 instance 메서드 호출 o
//static 메서드 안에서 static 메서드 호출 o
//static 메서드 안에서 instance 메서드 호출x
class MemberCall{
	
	int iv = 10;	//인스턴스 변수 : 객체가 생성될 때 생성되는 변수
	static int sv=20;// static 변수 : 프로그램이 시작될 때 생성되는 변수
	
	int iv2=sv; //인스턴스 변수는 스태틱 변수값으로 초기화 가능
//	static int sv2=iv; //에러. 스태틱 변수값은 인스턴스 변수값으로 초기화 불가
	//맨처음 생성돼서 끝까지 남은 변수에 언제 만들어질지 모르는 인스턴스 값으로 초기화는 불가능
	
	//억지로 인스턴스 변수로 static변수를 초기화하려면
//	MemberCall mc = new MemberCall();
//	static int sv2=mc.iv; //안됨
	static int sv2=new MemberCall().iv;
	//위와 같은 방법으로 레퍼런스 변수없는 new 인스턴스를 만들어서 멤버변수 사용
	//그러나 이 방법을 억지로 사용하고 그렇진 않음


	static void staticMethod() {
		System.out.println(sv); //static 메서드는 static 변수 사용가능
//		System.out.println(iv); //에러. static 메서드는 인스턴스 변수 사용불가
		System.out.println(new MemberCall().iv);
		//억지로 인스턴스 필드 쓰려면 객체를 만들고 사용 가능 -권장x
		staticMethod2(); //스태틱 메서드에서 스태틱 메서드 호출 가능
//		instanceMethod2();//에러 - 스태틱 메서드에서는 인스턴스 메서드 호출 불가능
		new MemberCall().instanceMethod2(); // 이렇게 하면 가능은 함 (권장x)
	}
	static void staticMethod2() {}
	void instanceMethod1() {
		System.out.println(sv);//인스턴스 메서드는 스태틱 변수 사용 가능
		System.out.println(iv);//인스턴스 메서드는 인스턴스 변수 사용 가능
		staticMethod2(); //인스턴스 메서드는 스태틱 메서드 호출 가능
		instanceMethod2();//인스턴스 메서드는 인스턴스 메서드 호출 가능
		}
	
	void instanceMethod2() {}
}

public class Class26 {

	public static void main(String[] args) {

	}

}
