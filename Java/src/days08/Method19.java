package days08;

import java.util.Scanner;

public class Method19 {

	public static void main(String[] args) {
		
//		return 값으로 사용되는 참조변수, 참조값
		
		//2차원 배열의 공간할당
//		 int [][] scores;
//		int s = getStudentNumber();
//		int k = getSubjectNumber();
//		scores = new int[s][k+1];
		
		// 1차원 배열의 공간할당
//		int s = getStudentNumber();
//		int [] kor = new int[s];
//		int [] eng = new int[s];
//		int [] mat = new int[s];
		
		Scanner sc=new Scanner(System.in);

		int [] kor= memoryAllocation(sc); //scanner과 같은 참조값도 메서드와 주고받음
		
		for(int k : kor)
			System.out.printf("%d ", k);
		
	}
	
// 리턴값이 참조값이 되는 메서드
	public static int[] memoryAllocation(Scanner sc) { //위에서 sc를 넣었으니 이렇게 하면 Scanner sc를 넣어서 받으면 됨
		int s = sc.nextInt();
		System.out.print("학생 수 입력 : ");
		int [] m= new int[s]; // 입력받은 학생수 만큼 1차원 배열이 만들어짐
		m[0]=90;
		m[1]=80;
		m[2]=70;
		return m;
	}
	
	}


