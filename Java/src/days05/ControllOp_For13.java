package days05;

public class ControllOp_For13 {

	public static void main(String[] args) {
		
		// 이중 반복문
		// 반복 실행문들이 중첩되어서 실행되는 구조
		int i, j; // 반복실행제어를 위한 변수도 별도로 두개가 필요
		for(i=1; i<=10; i++) {
			for(j=1; j<=10;j++) {	// 특히 들여쓰기 중요함
				//System.out.print("#");
				System.out.printf("(%d,%d)",i,j);
			}
			System.out.println();
		}
		
		
		
		
		
	}

}
