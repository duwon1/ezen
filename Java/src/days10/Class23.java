package days10;

//static변수는 클래스내부에 존재하지만, 객체 생성과 상관없이 프로그램 시작전 한번만 생성되고, 
//프로그램 종료시까지 변수가 갖는 값을 일관되게 유지 또는 변경관리함
//가장 쉽게 활용하는 법: 일정 interval의 일련번호, 생성된 객체의 개수, 일관된 지표를 나타내는 기준값
class StaticB{
	int bunho;
	static int count =0;
	StaticB(){
		//같은 클래스 내부에서는 static변수도 클래스 이름을 붙이지 않고 사용함
		count++; // 생성자에서 실행되므로, 객체가 생성될때마다 ++ 연산이 실행됨
		bunho = count;
	}
}


public class Class23 {

	public static void main(String[] args) {
		System.out.printf("count 값 %d\n", StaticB.count);
		StaticB b1=new StaticB();
		System.out.printf("b1.bunho = %d\n", b1.bunho, StaticB.count);

		StaticB b2= new StaticB();
		System.out.printf("b2.bunho = %d\n", b2.bunho, StaticB.count);
		
		StaticB b3=new StaticB();
		System.out.printf("b3.bunho = %d\n", b3.bunho, StaticB.count);

	}
}
