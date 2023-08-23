package days14;

abstract class Pet{
	public abstract void crying();
}

class DogB extends Pet{
	@Override
	public void crying() {
		System.out.println("멍멍!");
	}
}
class CatB extends Pet{
	@Override
	public void crying() {
		System.out.println("애옹!");
	}
}

public class Abstract03 {

	public static void main(String[] args) {

		DogB d = new DogB();
		CatB c = new CatB();
		
//		AbstractAnimal a1 = new DogA();
//		AbstractAnimal a2 = new CatA();
//		이전 파일의 이 동작은 결국 아래 동작을 위한 준비 단계였음
		
		singing(d);
		singing(c);
		
		//상속받은 자식클래스가 많아도 메서드의 매개변수로 그 부모클래스가 위치해서 모두를 받아줄 수 있음
	}

	public static void singing(Pet p) {
		p.crying();
	}
}











