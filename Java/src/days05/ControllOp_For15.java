package days05;

public class ControllOp_For15 {

	public static void main(String[] args) {
		
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				System.out.printf("#");
			}
			System.out.println();
		}
		System.out.println("\n//--------------------------------------------------------\n");
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=i;j++) {
				System.out.printf("#");
			}
			System.out.println();
		}
		System.out.println("\n//--------------------------------------------------------\n");
		//방법1
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=11-i;j++) {
				System.out.printf("#");
			}
			System.out.println();
		}
		System.out.println("\n//--------------------------------------------------------\n");
		//방법2
		for(int i=10;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.printf("#");
			}
			System.out.println();
		}
		System.out.println("\n//--------------------------------------------------------\n");
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				if(j>=i)
				System.out.printf("#");
				else System.out.printf(" ");
			}
			System.out.println();
		}
		System.out.println("\n//--------------------------------------------------------\n");
		for(int i=10;i>=1;i--) {
			for(int j=1;j<=10;j++) {
				if(j>=i)
					System.out.printf("#");
				else System.out.printf(" ");
			}
			System.out.println();
		}
		System.out.println("\n//--------------------------------------------------------\n");
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=i+9;j++) {
				if(j>=11-i)
					System.out.printf("#");
				else System.out.printf(" ");
			}
			System.out.println();
		}
		
		
		
	}

}
