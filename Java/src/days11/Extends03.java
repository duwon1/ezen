package days11;

//접근지정자와 상속
class SuperA{
	private int n1=100; 
	//private : 현재 클래스 내에 있는 멤버 메서드를 통해서만 접근 가능. 완전은닉이 됨
	//자식 클래스에게도 은닉됨

	public int getN1() {return n1;}
	public void setN1(int n1) {this.n1 = n1;}
	//private 멤버를 위한 getter/setter는 반드시 같은 클래스 내부에 정의해야 이를 상속받은 자식 클래스에서도 사용이 가능
	//private 멤버변수는 getter/setter도 모두 정의해서 상속해야 정상 이용이 가능함
	
	public int n2=200; //public : 어디서든 자유롭게 접근 가능
	int n3=300;
	//접근 지정을 아무것도 하지 않은 멤버 : default로 지정됨
	//동일한 패키지 내부에서는 public으로 동작, 다른 패키지에서는 private로 동작
	
	protected int n4=400;
	// 자식 클래스 또는 같은 패키지에서는 public과 같고, 외부로부터는 private로 작동
}

class SubA extends SuperA{
	
	public void printInfo() {
//	System.out.println(n1);//에러 - The field SuperA.n1 is not visible
		int n5 = getN1();
		System.out.println("부모의 public 멤버를 이용한 private n1 접근 : "+n5);
		//public으로 생성된 멤버 메서드를 이용하면 부모의 private 멤버에도 access가능
		System.out.println("부모의 public 멤버변수 n2 접근 : "+this.n2);
		//보모의 public멤버는 자유롭게 접근 가능
		System.out.println("부모의 default 멤버변수 n3 접근 : "+this.n3);
		//부모의 protected는 자식에겐 public
		System.out.println("부모의 protected 멤버변수 n4 접근 : " +this.n4);
		//부모의 protected는 자식에겐 public	
	}
}
public class Extends03 {

	public static void main(String[] args) {
		
		SubA sub1 = new SubA();
		sub1.printInfo();
		System.out.println();
		System.out.println("SuperA Class의 n1 변수값 : "+sub1.getN1());
	
		sub1.n3=20;
		sub1.n4=30;
		System.out.println("부모의 default 멤버 n3 : "+sub1.n3);
		System.out.println("부모의 protected 멤버 n4 : "+sub1.n4);
	}
}
