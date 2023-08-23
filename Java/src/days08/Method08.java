package days08;

import java.util.Scanner;

public class Method08 {

	public static void main(String[] args) {
		
		int [] a = {54,56,87,34,45,65,90};
		Scanner sc = new Scanner(System.in);
		
		System.out.print("메뉴를 선택하세요(합계:1, 평균:2, 오름차순 정렬:3, 내림차순 정렬:4) : ");
		int input =sc.nextInt();
		switch(input) {
		case 1 : sum(a); break;
		case 2 : avg(a); break;
		case 3 : sort(1, a); break;
		case 4 : sort(2, a); break;
		}
		

	}
	
	public static void sum(int [] a) {
		int s=0;
		for(int i=0; i<a.length; i++) {
			s=s+a[i];
		}
		System.out.println(s);
	}
	
	public static void avg(int [] b) {
		int s=0;
		for(int i=0; i<b.length; i++) {
			s= s+b[i];
		}
		double ave=(double)s/b.length;
		System.out.printf("%.1f", (int)(ave*100)/100.0);
	}
	
	public static void sort(int b, int[]a) {
		for(int i=0;i<a.length;i++) {
			for(int j=i+1; j<a.length;j++) {
				if(b==1) {
					if(a[i]>a[j]) {
						int temp=a[i];
						a[i]=a[j];
						a[j]=temp;
					}
				}
				else {
					if (a[i]<a[j]) {
						int temp=a[i];
						a[i]=a[j];
						a[j]=temp;
					}
				}	
			}
		}
		System.out.printf("%d, ",b);
		for(int k: a) System.out.printf("%d ",k);
	}

}


