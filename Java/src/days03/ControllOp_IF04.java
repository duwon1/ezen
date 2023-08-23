package days03;

public class ControllOp_IF04 {

	public static void main(String[] args) {
		
		int a = 85;
		
		if(a>=90)
			System.out.println("A");
		else if (80<=a&&a<90)
			System.out.println("B");
		else if (70<=a&&a<80)
			System.out.println("C");
		else if (60<=a&&a<70)
			System.out.println("D");
		else //else에는 조건을 쓰면 안됨!
			System.out.println("F");
		
		//-------------------------------------------------------
		
		if(a>=90)
			System.out.println("A");
		else if (80<=a) //굳이 if 조건의 반대는 적을 필요가 없음
			System.out.println("B");
		else if (70<=a)
			System.out.println("C");
		else if (60<=a)
			System.out.println("D");
		else //else에는 조건을 쓰면 안됨!
			System.out.println("F");
		
		//잘못 사용한 예-------------------------------------------------------
		if(a<60) System.out.println("F");
		else if(a>=60)System.out.println("D");
		else if(a>=70)System.out.println("C");
		else if(a>=80)System.out.println("B");
		else System.out.println("A");

		//올바른 예-------------------------------------------------------
		if(a<60) System.out.println("F");
		else if(a<70)System.out.println("D");
		else if(a<80)System.out.println("C");
		else if(a<90)System.out.println("B");
		else System.out.println("A");
		
	}

}
