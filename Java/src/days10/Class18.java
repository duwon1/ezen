package days10;

//this 키워드의 용도 #1
//
//this 변수는 레퍼런스(참조) 변수
//멤버변수는 new 생성자()에 의해 새로운 공간 객체별로 각각 만듦
//반면 멤버 메서드는 한개만 만들어지며, 각 객체들이 공유&호출해서 사용
//이때 메서드 내에는 누가 자신을 호출했는지 구분하기 위해 this라는 참조변수를 준비해놓고 있음
//호출한 객체의 참조값이 this에 저장됨
//this 변수는 따로 기술하지 않은 숨어있는 변수

class ThisA{
	private int num;
	
	public void init(int num/*, ThisA this*/) {
		this.num  = num;
	}
	
	public void setNum(int num/*, ThisA this*/) {
		this.num = num;
	}
	public int getNum(/*ThisA this*/) {
		return num;
	}


	public void prn() {
		System.out.println("멤버변수 num의 값 : " +num);
	}

	public void copy1(ThisA c/*, ThisA this*/) { // c<-a4 this<-a6
		this.num=c.num;
		
	}

	public ThisA copy2() {
		ThisA tmp= new ThisA();//새로운 객체 생성
		tmp.num=this.num;   //전달된 a3의 num값을 새 객체의 num에 복사
		return tmp;   //완성된 복사본의 참조값을 리턴
	}
	
	ThisA(){};//아래 생성자가 만들어지면서 디폴트생성자가 대체됨
	// 다른 곳에서 호출하던 디폴트생성자가 없어지면서 에러를 발생할 수 있으니 간단하게 디폴트 생성자를 오버로딩해줌
	
	ThisA(ThisA t){  //t<-a7, this<-a8
		this.num=t.num;
		//메서드 자체가 이미 생성자이기 때문에 별도의 new ThisA()는 필요치 않고 멤버변수값만 복사함
		
	}
}

public class Class18 {

	public static void main(String[] args) {
		
		ThisA t1 = new ThisA();
		t1.init(100);
		t1.prn();
		ThisA t2 = new ThisA();
		t2.init(200);
		t2.prn();
		
		ThisA a3= new ThisA();
		ThisA a4= new ThisA();
		a3.setNum(300); // a3->this  300-> 매개변수 num
		a4.setNum(400);// a4->this  400-> 매개변수 num
		System.out.println("a3의 멤버변수 num : "+ a3.getNum()); //a3->this
		System.out.println("a4의 멤버변수 num : "+ a4.getNum()); //a4->this

		ThisA a5 = a3;
		a3.setNum(500);
		a5.prn();
		a3.prn();
		
		ThisA a6=new ThisA(/*ThisA this*/); //this<-a3
		a6.copy1(a4); //공간할당(new ThisA)이 된 상태에서 멤버변수값만 카피
		a4.setNum(600);
		a6.prn();
		a4.prn();
		
		ThisA a7 = a3.copy2(); // 새로운 공간생성 후 멤버 변수값 카피하고 그 객체의 참조값 리턴
		a3.setNum(800);
		a7.prn();
		a3.prn();
		
		ThisA a8 = new ThisA(a7);
		
	}

}
