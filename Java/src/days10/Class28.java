package days10;

class StaticD{
	//private 으로 지정된 static멤버는 클래스의 내부에서만 사용가능
	private static int count;
	//private으로 지정된 static 변수를 이용(접근)하고자 한다면,
	//public으로 지정된 멤버메서드(static,인스턴스)를 만들고 이용해야함

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		StaticD.count = count;
	}
	
	public void setCount1(int count) {StaticD.count=count;}
	public int getCount1() {return StaticD.count;}
}

public class Class28 {

	public static void main(String[] args) {
//private로 감춰진 static멤버변수는 클래스 외부에서 접근이 차단됨
//		StaticD.count=50; //에러
		StaticD.setCount(15);
		System.out.printf("StaticD.count=%d\n",StaticD.getCount());
		
		StaticD d1 = new StaticD();
		d1.setCount1(30);
		System.out.printf("StaticD.count=%d\n",d1.getCount());
	}
}
