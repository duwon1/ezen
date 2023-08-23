package days09;

class Cat{
	private String name;
	private int age;
	private String phone;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	// 여기까지는 마우스로 getter setter 생성
	
	public void input(String name, int age, String string2) {
		this.name=name;
		this.age=age;
		this.phone = string2;
	}
	public void output() {
		System.out.println("제 이름은 "+ name+", 나이는 "+ age+ "입니다");
		
		
	}
}
public class Class10 {

	public static void main(String[] args) {
		Cat c1 = new Cat();
		Cat c2 = new Cat();
		c1.setName("냥냥이");
		c1.setAge(10);
		c1.setPhone("010-9999-8888");
		c2.input("야옹이", 5, "010-1234-2345");
		
		c1.output(); // 출력 내용 : 제 이름은 XXX, 나이는 X 살입니다.
		System.out.println("제 이름은 "+ c2.getName()+", 나이는 "+ c2.getAge()+ "입니다");
	}

}
