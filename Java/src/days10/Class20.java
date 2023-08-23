package days10;

//this의 용도 #2
//오버로딩 되어 있는 생성자들 간 서로를 재호출 하기위한 이름으로 사용
//호출하는 형태(매개변수의 형태)대로 생성자가 오버라이딩 되어 있어야 사용가능

class ThisB{
	private int num1;
	private int num2;
	private int num3;
	
	public ThisB(int i) { //생성자1
		num1=i;
		System.out.println("ThisB 클래스의 생성자1이 호출되었습니다");
	}
	
	ThisB(int n1, int n2){ //생성자2
//		num1=n1; //위의 생성자를 쓰고싶음
//		ThisB(n1); //이건 에러
		this(n1); //매개변수 한개를 갖고 있는 자신의 형제 생성자(생성자1), 오버로딩된 생성자를 호출
		num2=n2;
		System.out.println("ThisB 클래스의 생성자2가 호출되었습니다");
	}
	
	ThisB(int n1, int n2, int n3){
		this(n1, n2); //매개변수 두개를 갖고있는 오버로딩된 생성자(생성자2)를 호출
		num3=n3;
		System.out.println("ThisB 클래스의 생성자3이 호출되었습니다");
	}
}

public class Class20 {

	public static void main(String[] args) {
		
		ThisB b1= new ThisB(10);
		System.out.println();
		ThisB b2 = new ThisB(10,20);
		System.out.println();
		ThisB b3 = new ThisB(10,20,30);
	}

}
