package days04;

public class ControllOp_For03 {

	public static void main(String[] args) {
		
		//1부터 10까지의 합
		int sum=0;
		int i;
		for(i=1;i<=10000;i++) {
			sum=sum+i;
			System.out.println("1부터 "+i+"까지의 합은 : "+ sum);
		}
	}

}
