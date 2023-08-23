package days07;

public class Array16 {

	public static void main(String[] args) {
		
		// 자바의 2차원 배열은 각 행에 있는 열의 개수가 서로 다를 수 있음
		// 2차원 배열의 선언
		int [][] a; //참조 변수 선언
		
		a = new int[3][]; // 새로운 공간을 행개수만 지정함
		
		// 열에 해당하는 1차원 배열을 각각의 참조변수 ( a[0], a[1], a[2])에 new로 할당함
		// 각각 개수가 다르게
		a[0] = new int [3];
		a[1] = new int [4];
		a[2] = new int [5];
		
		int k=1;
		for( int i =0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				a[i][j] = k++;
			}
		}
		
		System.out.println();
		System.out.println();
		for( int i =0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				System.out.printf("%2d ", a[i][j]);
			}
			System.out.println();
			System.out.println();
			
			for( int [] row : a) {
				for(int Val : row) {
					System.out.printf("%2d ", Val);
				}
				System.out.println();
			}
		}
		
	}

}
