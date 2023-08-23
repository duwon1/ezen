package days07;

public class Array11 {

	public static void main(String[] args) {
		
		// 반복실행문을 이용한 배열의 조회 및 출력
		
		int [] a = {98,78,56,45,78};
		double [] b = {45.6, 23.4, 69.54, 87.0};
		String [] c = {"Korea", "USA", "Japan", "China", "Canada"};
		
		int i;
		for(i=0; i<a.length; i++) System.out.printf("%d ", a[i]);
		System.out.println();
		for(i=0; i<b.length; i++) System.out.printf("%.1f ", b[i]);
		System.out.println();
		for(i=0; i<c.length; i++) System.out.printf("%s ", c[i]);
		System.out.println();
		System.out.println();

		for( int k : a ) System.out.printf("%d ", k);
		// a : 사용될 배열의 이름
		// k : 배열의 각 요소들을 저장할 변수
		// a배열의 각 값들을 0번부터 마지막까지 "!하나씩!" 꺼내서 k변수에 저장하고 반복이 실행
		System.out.println();
		
		for(double k : b) System.out.printf("%.1f ", k);
		System.out.println();

		for(String k : c) System.out.printf("%s ", k);
		System.out.println();
		System.out.println();
		
		for(i=0; i<b.length; i++) {
			for(int j=i+1; j<b.length; j++) {
				if( b[i]>b[j]) {
					double temp = b[i];
					b[i] = b[j];
					b[j] = temp;
				}
			}
		}
		for( double k : b ) System.out.printf("%.1f ", k);
		
		
		for(i=0; i<c.length;i++) {
			for(int j=i+1; j<c.length; j++) {
				if(c[i].compareTo(c[j])>0) {
					String temp = c[i];
					c[i] = c[j];
					c[j] = temp;
				}
			}
		}
		System.out.println("\n");
		for (String k : c) System.out.printf("%s ", k);
	}

}
