package days02;

public class Println02 {

	public static void main(String[] args) {
		
		System.out.println("\t\t\t\t###성적표###");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("번호\t성명\t\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("1\t홍길동\t\t89\t87\t89\t"+(89+87+89)+"\t"+(89+87+89)/3.0);
		System.out.println("2\t홍길서\t\t7\t100\t89\t"+(7+100+89)+"\t"+(7+100+89)/3.0);
		System.out.println("3\t홍길남\t\t54\t79\t66\t"+(54+79+66)+"\t"+(54+79+66)/3.0);
		System.out.print("-----------------------------------------------------------------------\n");
//		 System.out.println 으로 출력되는 실수는 소수점 조절이 안됨
//		 System.out.println 으로 출력되는 수치 데이터는 소수점 정렬도 하기가 어려움
//		 단순출력은 print로도 가능
		
		
		
		
	}

}
