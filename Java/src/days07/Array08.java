package days07;

public class Array08 {

	public static void main(String[] args) {
		// 다섯세트가 출력되도록 프로그램을 변경해주세요
		
		// 1~45 사이의 임의의 난수를 a 배열에 여섯개 저장한 후,
		// 오름차순으로 정렬해서 출력하세요.(로또 번호)
		
		int[] a = new int[6];
		int[] b = new int[5];
		int i;
		
		
		for(int set=1; set<=5; set++) {
			
			for(i=0; i<6; i++) {
				a[i]=(int)(Math.random()*45)+1;
				int count = 0;
				for(int j=0; j<i;j++) {
					if(a[j]==a[i])count++;
				}
				if(count > 0) i--;//같은 값이 나온다면 전 차례로 돌아가서 다시 뽑는다는 뜻
			}
			
			int j;
			for(i=0; i<a.length; i++) {
				for(j=i+1;j<a.length;j++)
				if(a[i]>a[j]) {
					int temp = a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
			for(i=0; i<a.length; i++) {
				System.out.printf("%2d ", a[i]);
			}
			System.out.println();
		}
	}

}
