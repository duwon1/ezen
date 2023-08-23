package days10;

class Mymath{
	int a, b;
	static int c =0;
	//인스턴스 메서드에서 static 멤버변수에 접근 가능 o
	Mymath(){	c++;	}
	//인스턴스 메서드에서는 인스턴스 멤버변수에 접근 가능 o
	public void init() {
		a=c*20;
		b=c*30;
	}
	public int add() {	return a+b;}
	public int subtract() {return a-b;}
	public int multiply() {return a*b;}
	public double divide() {return a/(double)b;	}
	
	//static 메서드에서는 인스턴스 변수에 접근이 불가능해 직접 변수 만들기
	//static 메서드에서는 static 변수에 접근 가능
	public static int add(int d, int e) {return (d+e)*c;}
	public static int subtract(int d, int e) {return (d-e)*c;}
	public static int multiply(int d, int e) {return (d*e)*c;}
	public static double divide(int d, int e) {return (d/(double)e)*c;}
}

public class Class27 {

	public static void main(String[] args) {

		Mymath mm = new Mymath(); //객체 생성 시 static 변수 c는 1 증가
		mm.init(); //mm 객체의 a에는 20, b에는 30이 저장
		
		System.out.println("mm.add()->"+mm.add());
		System.out.println("mm.subtract()->"+mm.subtract());
		System.out.println("mm.multiply()->"+mm.multiply());
		System.out.println("mm.divide()->"+mm.divide());
	
		System.out.println("Mymath.add(10,30)-> "+Mymath.add(10, 30));
		System.out.println("Mymath.subtract(10,30)-> "+Mymath.subtract(10, 30));
		System.out.println("Mymath.multiply(10,30)-> "+Mymath.multiply(10, 30));
		System.out.println("Mymath.divide(10,30)-> "+Mymath.divide(10, 30));
		
		System.out.println(add(30,50));
	}
	public static int add(int a, int b) {
		return a+b;
	}
	//Class27 내부에는 인스턴스 메서드와 static 메서드 자유롭게 추가 가능
	//다만, static으로 만들어진 main 메서드 안에서 호출해서 사용하려면 반드시 static으로 생성해야함
}
