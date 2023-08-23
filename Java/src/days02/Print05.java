package days02;

public class Print05 {

	public static void main(String[] args) {
		
		System.out.printf("\t\t\t###성적표###\n");
		System.out.printf("--------------------------------------------------------\n");
		System.out.printf("%3d%10s%7d%7d%7d%7d%9.1f\n", 	
				1, "홍길동", 89, 87, 89, 89+87+89, (89+87+89)/3.0 );
		System.out.printf("%3d%10s%7d%7d%7d%7d%9.1f\n", 	
				2, "홍길남", 7, 100, 89, 7+100+89, (7+100+89)/3.0 );
		System.out.printf("%3d%10s%7d%7d%7d%7d%9.1f\n", 	
				3, "홍길서", 100, 100, 100, 300, 100.0 );
		System.out.printf("--------------------------------------------------------\n");
		
		
	}

}
