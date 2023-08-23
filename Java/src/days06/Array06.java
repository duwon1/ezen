package days06;

public class Array06 {

	public static void main(String[] args) {
		
		// 배열에 있는 값들 중 최대값과 최소값을 찾아서 출력하세요
		int [] a= {12, 56, 36, 54, 89, 100, 145, 75, 82, 36, 94, 97};
		
//		int max = 0; //이런경우는 최대값이 양수인 경우면 가능. 전부 음수일때는 불가능
		int max = a[0];// 이렇게 하면 a 첫번째 값을 기준으로 둬서 무슨 수가 있던 문제없음
		
		for(int i=1; i<a.length; i++)
			if(max<a[i]) {
				max=a[i];
			}
		
		System.out.println("최대값 : "+max);
		
		int min = a[0];
		
		for(int i=1; i<a.length; i++)
			if(min >a[i]) {
				min=a[i];
			}
		
		System.out.println("최소값 : "+min);
		
		
		
		
		
		
	}

}
