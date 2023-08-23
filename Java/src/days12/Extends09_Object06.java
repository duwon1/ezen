package days12;

import java.util.Vector;

//상품구매시스템
//클래스 만들어서 운영할 대상 : 판매할 상품, 구매자
//판매할 상품 : 컴퓨터 TV Audio
//각 클래스에는 적절한 멤버변수와 멤버메서드를 만들어서 운영하되
//공통의 요소들이 있다면 부모클래스를 만들고 그를 상속받아서 사용

//부모클래스
class Product{
	int price;
	int bonusPoint;
	Product(int p){
		this.price=p;
		this.bonusPoint=p/10; //정수로 만들기 위해서 
	}
}

//자식클래스
class Computer extends Product{
	Computer(){
		super(1500000);
	}
	public String toString() {
		return "Computer";
	}
}
class TV extends Product{
	TV(){
		super(2500000);
	}
	public String toString() {
		return "TV";
	}
}
class Audio extends Product{
	Audio(){
		super(1000000);
	}
	public String toString() {
		return "Audio";
	}
}


//구매자
class Buyer{
	int money = 10000000;
	int bonusPoint=0;
	Vector itemList = new Vector(); //구매상품을 저장할 리스트 클래스
	//Vector란 배열의 확장형 리스트 구조. -객체들을 저장할 수 있는 배열이라고 이해하면 됨
	//사용자가 만든 클래스의 객체(메모리를 할당 받은 레퍼런스값) 등이 저장되는 다형성 객체 저장 리스트
	//추가된 순서로 번호(index)도 설정이 돼 나중에 번호로 검색 가능
	
	//벡터에 데이터 저장하는 방법
//	Computer c = new Computer();
//	itemList.add(c);
	//add: Vector 클래스의 멤버 메서드
	//Vector 클래스의 add 멤버메서드 형태: public boolean add(Object obj){}
	//매개변수가 Object형이어서 어떤 객체든 전달이 가능함
	
	//전달인수 별로 오버로딩하여 구현
//	public void buy(Computer c) {	}
//	public void buy(TV t) {	}
//	public void buy(Audio a) {	}

	//매개변수로 Object 자료형 사용
//	public void buy(Object obj){}
	
	//매개변수로 Product 자료형 사용
	public void buy (Product p) {
		//제품의 가격보다 구매자 보유잔액이 더 큰지 확인
		if(p.price > this.money) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		//제품의 가격만큼 구매자의 잔액 차감
		this.money-=p.price;
		//제품의 보너스포인트만큼 구매자의 보너스포인트 합산
		this.bonusPoint+=p.bonusPoint;
		//구매상품을 itemList에 저장
		itemList.add(p);
		System.out.println( p.toString()+"을 구매하셨습니다.");
		//자식클래스에서 오버라이딩 된 toString()이 실행됨
				
		
	}
	public void summary() {
		//구입한 상품들을 하나의 String 값으로 정리해서 출력
		//지출 총액이 얼마인지 출력
		int sum=0; //지출 총액을 합산할 변수
		String item = ""; //구입한 상품들을 화면에 나열하기 위해 준비한 String 변수
		
		// itemList가 비어있다면 "구매한 상품이 없습니다"라고 출력하고 메서드 종료
		//itemList.isEmpty() : 벡터가 비어있으면 true, 하나라도 채워져있으면 false를 리턴
		if(itemList.isEmpty()) {
			System.out.println("구매하신 제품이 없습니다");
			return;
		}
		
		//itemList.size() : 벡터에 저장된 객체의 개수를 리턴해주는 메서드
		for(int i= 0; i<itemList.size();i++) {
			// Vector에서 저장요소를 꺼내는 멤버메서드 : itemList.get(0); itemList.get(1);
			Product p = (Product)itemList.get(i);
			sum +=p.price;
			item += " "+p.toString();
		}
		System.out.println("구매 Summary-------------");
		System.out.println("지출총액 : "+sum);
		System.out.println("잔액 : "+money);
		System.out.println("구매목록 : "+item);
		
	}
	
	//환불메서드
	// itemList.remove(상품) :itemList에서 상품 삭제
//										-remove하려는 상품이 존재하여 잘 지워졌다면 true 리턴
//	잔액이 상품 가격만큼 늘어남
//	보너스포인트 줄어듦
//	itemList에서 상품 삭제
//	제일 먼저 itemList가 비어 있으면 구매한 내역이 없음
//	환불하려는 상품이 없으면 해당상품이 없음
//	마지막 "해당상품이름"이 환불되었습니다. 출력
	public void refund( Product p) {
		if(itemList.isEmpty()) {
			System.out.println("구매하신 제품이 없습니다");
			return;
		}
		if(itemList.remove(p)) {
			this.money+=p.price;
			this.bonusPoint-=p.bonusPoint;
			System.out.println(p+"을/를 반품하셨습니다.");
		}else {
			System.out.println("구입하신 물품 중에 해당 제품이 없습니다.");
		}
		
	}
}

public class Extends09_Object06 {

	public static void main(String[] args) {

		Buyer b = new Buyer();
		Computer c = new Computer();
		TV t = new TV();
		Audio a = new Audio();
		
		b.buy( c );
		b.buy( t );
		b.buy( a );
		
		b.summary();
		
		b.refund(a);
		b.summary();
	}

}
