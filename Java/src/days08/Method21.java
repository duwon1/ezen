package days08;

import java.util.Scanner;

public class Method21 {

		public static void main(String[] args) {
			
			int [] mdays = {0,31,28,31,30,31,30,31,31,30,31,30,31};
			Scanner sc = new Scanner(System.in);
			
			int y = inputYear(sc);
			int m = inputMonth(sc);
			int input = 0;
			
			
			
			while(true) {
				if( (y%4==0)&&(y%100!=0)||(y%400==0) )  mdays[2] = 29;
				else mdays[2] = 28;
				
				int days = sumDaysYear( y); //입력한 년도의 전년도까지의 날짜 합 계산
				days += sumDaysMonth(m, mdays); //입력한 월의 전월까지의 날짜 합 계산
				days +=1; //날짜는 1일자 기준합산
				int temp = days % 7;
				
				prnCalendar( y, m, mdays, temp);
			
				System.out.printf("\n[1.이전달]\t[2.다음달]\t[3.종료] ");
				input = sc.nextInt();
				if(input==3) break;
				
				if( input == 1 ) {
					if( m == 1 ) {
						y--; m=12;					
					}else
						m--;
				}else if(input == 2){
					if( m == 12 ) {
						y++; m=1;				
					}else
						m++;
				}
				System.out.println("\n\n");
				
			}
			System.out.println("프로그램을 종료합니다");
			
		}

		private static void prnCalendar(int y, int m, int[] mdays, int temp) {
			System.out.println("-------------------------------------------");
			System.out.printf("\t\t%d년 %d월\n", y, m);
			System.out.println("-------------------------------------------");
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			System.out.println("-------------------------------------------");
			
			for(int i=1; i<=temp; i++) System.out.printf("\t");
			for(int day=1; day<=mdays[m]; day++) {
				System.out.printf("%2d\t", day);
				if((day+temp)%7==0) System.out.println();
			}
			System.out.println("\n------------------------------------------");
			
			
		}

		private static int sumDaysMonth(int m, int[] mdays) {
			int sumM=0;
			for(int i=0; i<m; i++) {
				sumM+=mdays[i];
			}
			
			
			return sumM;
		}

		private static int sumDaysYear(int y) {
			int sumy=(y-1)*365;
			for(int i=1; i<y;i++) {
				if( (i%4==0)&&(i%100!=0)||(i%400==0)) sumy++;
			}
			return sumy;
		}

		private static int inputMonth(Scanner sc) {
			System.out.printf("월을 입력하세요 : ");
			int m=sc.nextInt();
			return m;
		}

		private static int inputYear(Scanner sc) {
			System.out.printf("연도를 입력하세요 : ");
			int y=sc.nextInt();
			return y;
		}
}