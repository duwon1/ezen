package days09;

class Human{
	String name;
	int age;
	String phone;
	String address;
}

public class Class03 {

	public static void main(String[] args) {
		
		Human h1;
		h1= new Human();
		Human h2 = new Human();
		Human h3 = new Human();
		
		String [] name = new String[3];
		int [] age= new int[3];
		String []phone = new String[3];
		String [] address = new String[3];
		//멤버변수에 해당하는 항목이 많을수록 배열의 개수가 늘어남
		
		//클래스를 사용해 자료처리의 단위가 변경됨
		//프로그램이나 자료 중심의 처리 -> 개발자 중심의 처리
		
		h3.name = "홍길남";
		h3.age = 30;
		h3.phone ="010-1111-2222";
		h3.address="서울시 마포구 신촌로";
		System.out.println("이름: "+h3.name+"나이 : "+h3.age
				+"\n전화번호 : "+h3.phone+"\n주소 : "+h3.address);
		
		name[0] ="홍길서";
		age[0]=31;
		phone[0]="010-7777-8888";
		address[0]="서울시 마포구 대흥동";
		System.out.println("이름: "+name[0]+"나이 : "+age[0]
				+"\n전화번호 : "+phone[0]+"\n주소 : "+address[0]);
		
		for( int i=0; i<name.length; i++) {
			name[i]="abcd"; //직접 입력하거나 사용자로부터 입력받거나
			age[i]=29; 
			phone[i]="010-9999-8888"; 
			address[i]="서울시 마포구 창천동"; 
		}
		h1.name = "홍길남"; //직접 입력하거나 사용자로부터 입력 받거나
		h1.age = 30;
		h1.phone ="010-1111-2222";
		h1.address="서울시 마포구 신촌로";

		h2.name = "홍길남";
		h2.age = 30;
		h2.phone ="010-1111-2222";
		h2.address="서울시 마포구 신촌로";
		
		//반복되는 코드는 메서드로 만들어 호출함
		//앞에서 공부한 일반적인 static메서드 아닌 클래스 전용 메서드를 생성해서 사용함
	}

}
