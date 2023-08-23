package days07;

public class Method07 {
	
	public static void sortAsc(int [] a) {
		for(int i=0; i<a.length; i++) {
			for(int j=i+1; j<a.length; j++) {
				if(a[i]>a[j]) {
					int tmp = a[i];
					a[i]=a[j];
					a[j]=tmp;
				}
			}
		}
		for(int k : a) 	System.out.printf("%d  ", k);		
	}
	
	public static void sortDesc(int [] a) {
		for(int i=0; i<a.length; i++) {
			for(int j=i+1; j<a.length; j++) {
				if(a[i]<a[j]) {
					int tmp = a[i];
					a[i]=a[j];
					a[j]=tmp;
				}
			}
		}
		for(int k : a) 	System.out.printf("%d  ", k);		
	}
	
	public static void main(String[] args) {
		
		int [] a = {50, 60, 70,40,20,30,54,34,65,120};
		// a 배열을 오름차순 또는 내림차순으로 정렬해서 출력하는 아래 메서드를 작성하기
		sortAsc(a); //오름차순 정렬 후 출력
		System.out.println();
		sortDesc(a);
		
	}
}
