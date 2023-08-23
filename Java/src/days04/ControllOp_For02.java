package days04;

public class ControllOp_For02 {

	public static void main(String[] args) {
		
		int i;
		//1부터 100까지의 정수 출력
		int k = 1;
		System.out.println("1~100 정수 출력------------------------------");
		for(i=1; i<=100; i++) {
			System.out.printf("%d ",k);
			k++;
					}
System.out.println();

			for(i=1; i<=100; i++) 
				System.out.printf("%d ",i);
		
			System.out.println("\n1부터 100사이의 짝수 출력-------------------------------");
			for(i=2;i<=100; i+=2)
				System.out.printf("%d ", i);
			System.out.println("\n1부터 100사이의 짝수 출력-------------------------------");
			for(i=1;i<=100; i++)
				if(i%2==0)
				System.out.printf("%d ", i);
		
			System.out.println("\n1부터 100사이의 홀수 출력 #1-------------------------------");
			for(i=1;i<=100; i+=2)
					System.out.printf("%d ", i);
			System.out.println("\n1부터 100사이의 홀수 출력 #2-------------------------------");
			for(i=1;i<=100;i++)
				if(i%2==1)
					System.out.printf("%d ",i);
	}

}
