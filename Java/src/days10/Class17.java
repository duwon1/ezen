package days10;

import java.util.Scanner;

//int형 자료를 매개변수로하는 생성자와 디폴트생성자를 오버로딩하는 클래스 생성
//전달인수가 있으면 전달인수를 멤버변수 dan에 저장, 전달인수가 없으면 dan에 0저장
//멤버변수는 int dan; 한개만 생성
//멤버ㅁ메서드는 print() 하나
//print 메서드의 내용
//dan 이 0이 아니면 해당 구구단 출력
//dan이 0이면 2~9단 구구단 출력

class Gugudan{
	int dan;
	Gugudan() {
		dan=0;
	}
	Gugudan(int d){
		dan=d;
	}
	public void print() {
		
		if(dan!=0) {
			for(int i=1;i<=9;i++) {
				System.out.println(dan+"x"+i+"="+i*dan);
			}
		}else {
				for(int j=2;j<=9;j++) {
					for(int i=1;i<=9;i++) {
						System.out.printf("%dx%d=%d ",i,j,i*j);
							}
					System.out.println();
					}
			}
	
	}
}
public class Class17 {

	public static void main(String[] args) {
		Gugudan g1 = new Gugudan(8);
		Gugudan g2 = new Gugudan();
				g1.print();
				g2.print();
	}
}
