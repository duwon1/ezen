package days09;

class Tiger{
	String name;
	int age;
	String phone;

	public void input(String name, int age, String string2) {
		this.name=name;
		this.age=age;
		this.phone = string2;
	}
	public void output() {
		System.out.println("제 이름은 "+ name+", 나이는 "+ age+ "입니다");
	}
	
	public void copy(Tiger t1) { //매개변수의 참조변수를 복사 ->주소값 복사가 아니라 후에 변경해도 동일x
		this.name=t1.name;
		this.age=t1.age;
		this.phone=t1.phone;
		
	}
	
	public Tiger copy2() {  //return값=tiger
		Tiger temp = new Tiger();
		temp.name=this.name; //호출객체는 t2니까
		temp.age=this.age; 
		temp.phone=this.phone;
		return temp;
	}
}

public class Class11 {

	public static void main(String[] args) {

		Tiger t1=new Tiger();
		Tiger t2=new Tiger();
		t1.input("야옹이",10, "010-1234-2345");
		t2.input("냥냥이",11, "010-3333-2345");
		
// 참조변수들 간의 복사		
		t1.output();
		t2.output();
		System.out.println();
		Tiger t3;
		t3=t2; //이러면 t2가 t3한테 그냥 값을 준게 아니라 t2의 주소값을 복사해 t3한테 줬기 때문에 t2의 변화를 t3한테도 똑같이 적용함
		t3.output();
		t2.input("어흥이", 15, "010-9999-8888");
		t2.output(); 
		t3.output();
		
		System.out.println();
		
		Tiger t4= new Tiger();
		t4.copy(t1); //t1의 멤버변수들의 값을 모두 복사하는 메소드 만들거임
		t1.output(); 
		t4.output();
		t1.input("야옹이", 100, "010-2222-1111");
		t1.output(); 
		t4.output();
		System.out.println("\n\n");

		Tiger t5 = t2.copy2();
		t2.output(); 
		t5.output();
		System.out.println();
		t2.input("야옹이", 200, "010-2222-1111");
		t2.output(); 
		t5.output();
		
	}
}
		
		
		
		
//		int [] arr = {1,2,3,4,5};
//		int [] arr2 = arr;
//		arr[3]=400;
//		for(int k : arr) System.out.printf("%d ", k);
//		System.out.println();
//		for(int k : arr2) System.out.printf("%d ", k);
//		System.out.println();
//		
//		callByReferenceEx(arr); //메소드한테 call by reference로 arr의 주소값에 접근이 가능해져서 arr도 arr2도 바뀜
//		System.out.println();
//		for(int k : arr) System.out.printf("%d ", k);
//		System.out.println();
//		for(int k : arr2) System.out.printf("%d ", k);
//		System.out.println();
//		
//	}
//
//	private static void callByReferenceEx(int[] arr) {
//		arr[4]=500;
//		for(int k : arr) System.out.printf("%d ", k);
//	}
//}
