package days12;

//Object클래스의 equals 메서드 : 객체간의 비교를 위해서 사용되는 메서드
//Object가 상속한 메서드들 중 toString과 함께 가장 많이 오버라이딩 되는 메서드

class Point{
	private int x;
	private int y;
	Point(int x, int y){this.x=x; this.y=y;}
	public String toString() {return"x: "+this.x+", y : "+this.y;}
	
	//오버라이딩 되는 메서드의 조건 : 리턴값의 유형, 매개변수의 유형-개수-순서가 같아야 함
	//"부모클래스의 참조변수에 자식클래스의 인스턴스 참조값을 아무런 제약없이 저장할 수 있다"
	// equals의 매개변수는 모든 클래스의 부모클래스의 Object형 매개변수가 존재해야 하고
	//그렇게 되면 어떤 자료형이든 전달인수로 전달이 가능함
	//메서드의 호출 형태 : p1.equals(p2);
	public boolean equals(Object obj) { 
		//메서드의 호출 형태 : p1.equals(p2);
		//this <-p1    obj<-p2
		//"자식 인스턴스를 저장한 부모클래스 참조변수는 물려준 멤버만 접근이 가능하다"
		//"물려주지 않은 멤버변수 x,y에 접근이 안됨"
		//또한 현재 상태는 obj(Object)와 this(Point)를 갖고 비교해야 하는 상황
		//원활한 비교를 위해 obj(Object)를 Point형으로 변환할 필요가 있음
		//부모참조변수에 저장된 값을 자식참조변수에 옮겨담을 땐 강제캐스팅이 필요함
		if(!(obj instanceof Point)) return false;
		//전달된 비교대상 객체가 Point로 캐스팅될 수 없는 개체라면 비교하지 말고 바로 false 리턴
		Point p =(Point)obj;
		boolean result =(p.x==this.x) && (p.y==this.y);
		return result;
	}
}

public class Extends09_Object03 {
	
	public static void main(String[] args) {

		// 일반적인 기본자료형들의 비교( == )
		int n1 = 10;
		int n2 = 10;
		if(n1==n2)System.out.println("n1 변수와 n2 변수는 같습니다.");
		else System.out.println("n1변수와 n2 변수는 다릅니다.");
		
		//String 자료형의 비교(==)
		String s1 = "Hello";
		String s2 = "Hello";
		if(s1==s2)System.out.println("s1 변수와 s2 변수는 같습니다.");
		else System.out.println("s1 변수와 s2 변수는 다릅니다.");
		//String s1 = "Hello"; 이 명령에 의해 Heap에 "Hello" String 데이터가 저장될 공간이 잡히고
		//s1에 그 공간의 주소(참조값)이 저장됨.
		//그 다음에 String s2="Hello";가 실행되면, new가 없으므로 혹시 Heap 안에 "Hello"가
		//저장되어 있는지 한번 정도 검색을 하고 발견되면 그 주소(참조값)를 s2에 저장함.
		//발견되지 않으면, 다시말해 다른 text이면 그때 새로운 공간을 할당함
		//결국 s1==s2는 text들의 비교가 아니라 참조변수가 저장하고 있는 참조값(주소)들의 비교였던 것임
		
		String s3 = new String("Hello");
		String s4 = new String("Hello");
		if(s3==s4)System.out.println("s3 변수와 s4 변수는 같습니다.");
		else System.out.println("s3 변수와 s4 변수는 다릅니다.");
		// new에 의해서 새로운 공간이 생기고 같은 text를 가졌다고 할 수 있지만
		//비교는 s3이 저장한 참조값하고 s4가 저장한 참조값이 비교가 되어 두 변수는 다릅니다 라는 결과를 출력
		
		//결론 : (==)이 연산자는 클래스 멤버인 글자들의 비교가 아니라, 레퍼런스 주소들의 비교

		if (s3.equals(s4))
			System.out.println("s3 변수와 s4 변수는 같습니다.(equals)");
		else System.out.println("s3 변수와 s4 변수는 다릅니다.(equals)");
		//참조값이 다른 객체라도 equals를 이용한다면 실제 저장된 멤버값들을 비교하여 같은 지 같지 않은지를 확인 가능
		
		Point p1 = new Point (20,30);
		Point p2 = new Point (20,30);
		if(p1==p2)System.out.println("p1 변수와 p2 변수는 같습니다.(==)");
		else System.out.println("p1 변수와 p2 변수는 다릅니다.(==)");

		if(p1.equals(p2))System.out.println("p1 변수와 p2 변수는 같습니다.(equals)");
		else System.out.println("p1 변수와 p2 변수는 다릅니다.(equals)"); //Point는 내가 만든 클래스라 안된다고함 
		
		//equals 메서드는Object클래스의 메서드로서 최초는 레퍼런스값(주소)들의 비교를 정의
		//String 클래스는 이미 equals 메서드를 text값들이 비교되도록 오버라이딩 되어 있고
		//기타 다른 사용자 정의 클래스(Point)에서는 별도로 equals를 실제값으로 비교하도록 오버라이딩 해줘야 함
	
		p1.equals(s1);
	}
}



