package days07;

public class Method06 {

	public static void main(String[] args) {
		
		int a=10, b=20, c=40, d=30;
		prnMax1(a, b, c, d);
		
		int [] arr = {50, 60, 70,40,20,30,54,34,65,12};
		prnMax2(arr);  // 전달인수로 배열의 참조값(주소값)을 전달
		
		
	}
	//전달인수로 참조값을 전달해서 하나의 배열을 두개의 메서드가 공유해서 사용
	//Call by reference라고 부름
	//이렇게 전잘되는 배열은 배열의 요소가 몇개여도 개수에 상관없이 전달 가능
	public static void prnMax2(int [] c) {
		int max = c[0];
		for(int i=0; i<c.length; i++)
			if(max<c[i]) max = c[i];
		System.out.println("최대값 : "+max);
	}
	
	public static void prnMax1(int a, int b, int c, int d) {
		int max1, max2;
		if(a>b)max1=a;
		else max1=b;
		
		if(c>d)max2=c;
		else max2=d;
		
		if(max1>max2) System.out.println("최대값 : "+max1);
		else System.out.println("최대값 : "+max2);
	}

}
