package days05;

public class ControllOp_For14 {

	public static void main(String[] args) {
		
		int i, j;
		/*
		// 1. 구구단 1단부터 10단까지를 출력
		 for(i=1; i<=10; i++) {
			 for(j=1;j<=10;j++) {
				 System.out.printf("%d x %d = %2d ", i, j, i*j);
			 }
			 System.out.println();
		 }
		*/
	/*
		// 2. 구구단 2단부터 9단까지 , 한개 단이 세로로 표시
		 for(i=1; i<10; i++) {
			 for(j=2;j<10;j++) {
				 System.out.printf("%d x %d = %2d ", j, i, i*j);
			 }
			 System.out.println();
		 }
		*/
		
		// 3. 2 3 4 5단은 상단에 6 7 8 9는 하단에
		for(i=1; i<=9; i++) {
			for(j=2;j<=5;j++) {
				System.out.printf("%d x %d = %2d ", j, i, i*j);
			}
			System.out.println();
		}
		System.out.println();
		for(i=1; i<=9; i++) {
			for(j=6;j<=9;j++) {
				System.out.printf("%d x %d = %2d ", j, i, i*j);
			}
			System.out.println();
		}
	}

}
