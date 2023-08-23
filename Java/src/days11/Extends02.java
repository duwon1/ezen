package days11;

//상속을 제공해주는 클래스:슈퍼(super)클래스, 부모클래스, 상위클래스
//상속을 받는 클래스 : 서브(sub)클래스, 자식클래스, 하위클래스

class Car{ //부모클래스 선언
	int 엔진;
	int 배기량;
	int 도어개수;
}

class K7 extends Car{ //자식클래스 선언
	public void printInfo() { //메서드에서 부모에게서 상속받은 멤버변수를 사용할 수 있음
		System.out.printf("엔진 : %d\n", this.엔진);
		System.out.printf("배기량 : %d\n", this.배기량);
		System.out.printf("도어개수 : %d\n", this.도어개수);
	}
}

public class Extends02 {

	public static void main(String[] args) {

		K7 k = new K7();
		k.엔진=6;
		k.배기량=3000;
		k.도어개수=5;
		k.printInfo();
	}

}
