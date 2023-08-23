package days10;

class Student2{
	private int bunho;
	private String name;
	private int [] scores;
	private int tot;
	private double avg;
	private char grade;
	
	Student2(){
		scores = new int[4];
		System.out.println("생성자 1 호출");
	}
	Student2(String name){
//		scores = new int[4];
		this();
		this.name = name;
		System.out.println("생성자 2 호출");
	}
	Student2(String name, int kor, int mat, int eng){
//		scores = new int[4];
		this(name);
		System.out.println("생성자 3 호출");
	}
	//생성자 안에서 사용되는 this()키워드는 다른 명령보다 항상 위에 있어야함
}
public class Class21 {

	public static void main(String[] args) {
		
		Student2 std1 = new Student2();
		Student2 std2 = new Student2("홍길동");
		Student2 std3 = new Student2("홍길남", 98,87,59);

	}

}
