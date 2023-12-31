package days07;

public class Array13 {

	public static void main(String[] args) {
		
		// 2차원 배열
// 		행과 열의 개념을 사용하는 인데스가 2개인 배열
// 		2차원 배열의 변수 선언 - 행과 열을 의미하는 []가 두개 사용
// 		1차원 배열이 일직선상의 선형데이터구조였다면,
// 		2차원 배열은 행과 열이 존재하는 table형(면) 데이터 구조라고 할 수 있음
		
		int [][] a; //참조변수
//		2차원 배열의 공간 생성
//		변수명 = new 자료형[행의 수][열의 수];
//		3행 2열의 2차원 배열 생성
//		(2개의 요소를 가지는 일차원 배열을 3개 생성 - 3행 2열의 배열)
		a = new int[3][2];
		
		int [][] a1 = new int[3][2]; //이렇게도 작성 가능
//		1차원 배열과 마찬가지로 2차원도 HEAP 메모리에 생성되므로 초기화 값은 0
		
		int [][] b = { {1, 2}, {3, 4}, {5, 6} };
//		위 두개의 배열(a1, b) 선언은 각 구성요소 값들은 다르지만 행열의 개수는 같음
		
		a1[0][0] = 100;
		a1[0][1] = 200;
		a1[1][0] = 300;
		a1[1][1] = 400;
		a1[2][0] = 500;
		a1[2][1] = 600;

		// 세번째행의 두번째 값 출력
		System.out.println(a1[2][1]);
		
		// 모두 출력
		for( int i=0; i<3; i++) {
			for(int j=0; i<2; j++) {
				System.out.printf("%d ", a1[i][j]);
			}
			System.out.println();
		}
		
	}

}
