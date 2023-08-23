package days05;

public class ControllOp_For15_1 {

	public static void main(String[] args) {
		
		System.out.println("\n//--------------------------------------------------------\n");
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=i+9;j++) {
				if(j>=11-i)
					System.out.printf("#");
				else System.out.printf(" ");
			}
			System.out.println();
		}
		
		
		//i=2	j<11 	j>=9
	}

}
