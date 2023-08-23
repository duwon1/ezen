package days08;

public class Method14 {

	public static void main(String[] args) {
		
		int [] a = {65, 87,89, 12, 45,36, 57, 45};
		int tot = sum(a);
		double avg = average(a);
		prn(a, tot, avg); //배열안의 숫자들을 출력 후 합계 평균 출력

	}
	
	public static int sum(int [] a) {
		int tot=0;
		for(int i=0; i<a.length;i++) {
			tot+=a[i];
		}
		return tot;
	}

	public static double average(int [] a) {
		int tot=sum(a);
		return tot/(double)a.length;
	}
	
	public static void prn(int []a, int b, double c) {
		for(int k : a)			System.out.printf("%d ",k);
		System.out.println();
		System.out.printf("총합: %d, 평균 : %.1f", b, c);
	}
}
