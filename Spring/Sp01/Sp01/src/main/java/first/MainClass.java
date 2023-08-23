package first;

public class MainClass {

	public static void main(String[] args) {
		
		//System.out.println("Maven  Java 실행");
		Calculator c = new Sum();
		int result = c.cal( 10, 20);
		System.out.println("10+20 => " + result);
		
		c = new Sub();
		result = c.cal(10,  20);
		System.out.println("10-20 => " + result);

	}

}
