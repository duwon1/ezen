package days06;

public class Array07 {

	public static void main(String[] args) {
		
		// 배열의 값들을 오름차순 또는 내림차순으로 재배치(정렬)
		int [] a= {12, 56, 36, 54, 89, 100, 145, 75, 82, 18, 94, 97};
		
//		// 이중반복문 사용
//		첫째 반복문의 제어변수 i
//		두번째 반복문의 제어변수 j
//		i=0일 때 j는 1~9로 반복시켜서 a[i]와 a[j] 둘을 비교하고 a[j]값이 더 작으면 a[i]와 a[j]의 값을 오름차순에 맞게 맞바꿈
//		
//		//i=1일 때 j는 2~9로 반복시켜서 a[i]와 a[j] 둘을 비교
//		//i=2일 때 j는 3~9로 반복시켜서 a[i]와 a[j] 둘을 비교
//		j번째가 더 작은 값이면 i번째와 j번째를 서로 맞바꿈
		int i;
		for(i=0; i<a.length; i++) {
			for(int j=i+1; j<a.length;j++) {
				if(a[i]>a[j]) {
					//서로 자리를 바꿔야함->임시변수 만들어서 자리 바꿔야 함
					int temp = a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		
		for(i=0; i<a.length; i++) {
			System.out.printf("%d  ", a[i]);
		}
		
		System.out.println();
		
		//내림차순 정렬
		for(i=0; i<a.length; i++) {
			for(int j=i+1; j<a.length;j++) {
				if(a[i]<a[j]) {
					//서로 자리를 바꿔야함->임시변수 만들어서 자리 바꿔야 함
					int temp = a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		
		for(i=0; i<a.length; i++) {
			System.out.printf("%d  ", a[i]);
		}
	}

}
