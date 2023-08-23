package days06;

public class Array02 {

	public static void main(String[] args) {
		
		// 배열의 선언과 저장 공간 생성 방법
		// 1. 배열 변수의 선언 후, 실제 배열 공간을 할당 받는 방법 
		int [] a1 = null;
		// null : 아무것도 없다는 뜻의 값.
		String s1 = null;  // Heap 에 공간확보가 되지 않은 상태
		String s2 = "";   // Heap 에 공간이 확보되고 그 주소가 저장된 상태 
		
		int [] b1;  // null 값도 넣지 않은 상태. 초기화되지 않은상태
		System.out.println(a1);
		// System.out.println(b1);  // 에러 . 초기화되지 않은 변수의 사용은 에러
		// 변수에 null 을 초기화한것과 아무것도 초기화하지 않은 것은 다릅니다.
		a1 = new int[4];
		
		// 2. 배열 변수의 선언과 배열의 생성을 동시에 진행
		int [] a2 = new int[4];
		// new에 의 해서 HEAP 메모리에 생성되는 모든 영역은 정수형 자료라면 0 
		// 실수형 자료라면 0.0, String 자료라면 null 값으로 초기화됩니다.
		
		System.out.println(a1[0] + " " + a1[1] + " " + a1[2] + " " + a1[3]);
		System.out.println(a2[0] + " " + a2[1] + " " + a2[2] + " " + a2[3]);
		
		double [] d = new double[4];  // 모두 0.0 으로 초기화
		String [] s = new String[4];  //  모두 null 로 초기화
		System.out.println(d[0] + " " + d[1] + " " + d[2] + " " + d[3]);
		System.out.println(s[0] + " " + s[1] + " " + s[2] + " " + s[3]);
		
		
		
		System.out.println("\n");
		// 3. 배열을 생성하면서 임의의 값으로 초기화하는 방법
		// 크기가 5 인 배열을 생성하면서, 각 요소의 값을 1,2,3,4,5 로 초기화하는 코드
		int [] a3 = new int[] {1,2,3,4,5};  // 배열의 갯수도 정해지고 각 요소에 값도 저장
		System.out.println(a3[0]+" "+a3[1]+" "+a3[2]+" "+a3[3]+" "+a3[4]);
		
		int [] a5 = {5,4,3,2,1};
		System.out.println(a5[0]+" "+a5[1]+" "+a5[2]+" "+a5[3]+" "+a5[4]);
		
		a5[0] = 100;
		System.out.println(a5[0]+" "+a5[1]+" "+a5[2]+" "+a5[3]+" "+a5[4]);
		
		
		// 4. 배열 변수 a7, a8를 동시 선언하는 코드
		int [] a7, a8;
		a7 = new int[3];
		a8 = new int[3];
		
		
		// 5. 배열변수와 일반 변수를 동시에 선언이 가능합니다
		int a9 [], a10 [], a11;
		// 배열변수(참조변수)는 변수뒤에 대괄호를 표시합니다
		a9 = new int[3];
		a10 = new int[3];
		a11 = 10;

	}

}













