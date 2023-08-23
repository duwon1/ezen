package days10;

import java.util.Scanner;

class Student{
	private int bun;
	private String name;
	private int [] scores;
	private double avg;
	Scanner sc = new Scanner(System.in);
	public void prnTitle() {
		
	}
	public void prnScore() {
		
	}
	
	Student(){
//		System.out.print("과목을 입력하세요 : ");
//		int k = sc.nextInt();
//		scores = new int[k+1];
		scores = new int[4];  //멤버변수에 참조변수만 존재한다면 생성자에서 메모리 할당 명령이 실행됨
		name = "김하나";
		scores[0] = 89;
		scores[1] = 95;
		scores[2] = 33;
		// 번호는 객체가 생성될 때마다 부여되는 연속번호 입력방법을 공부하고 넣겠습니다
	};
	Student(String name){
		scores = new int[4];  //멤버변수에 참조변수만 존재한다면 생성자에서 메모리 할당 명령이 실행됨
		this.name=name;
		scores[0] = 89;
		scores[1] = 97;
		scores[2] = 45;
	};
	Student(String name, int sc1, int sc2, int sc3){
		this.name=name;
		scores= new int [4];
		scores[0] = sc1;
		scores[1] = sc2;
		scores[2] = sc3;
	};
	
	Student( Student s ){
		this.name=s.name;
		scores= new int [4];
		this.scores[0] = s.scores[0];
		this.scores[1] = s.scores[1];
		this.scores[2] = s.scores[2];
		
	}
	
	public void copy1( Student s ) {
		this.name=s.name;
		this.scores[0] = s.scores[0];
		this.scores[1] = s.scores[1];
		this.scores[2] = s.scores[2];
	}
	

}
//아래 생성자들이 모두 실행가능하도록 생성자를 제작
//모든 생성자에서 scores에 과목 점수 정수 세개를 저장할 배열을 만들고 주소를 저장하도록 코딩하기
//디폴트 생성자와 이름만 전달되는 생성자에서 각 점수는 임의의 값을 대입하세요

public class Class16 {
	public static void main(String[] args) {
		
		Student s1 = new Student();
		Student s2 = new Student("홍길서");
		Student s3 = new Student("홍길남, 98,69,87");
		Student s4 = new Student(s3);
		
		Student s5 = new Student();
		s5.copy1(s1);
		
	}

}
