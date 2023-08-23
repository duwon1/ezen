package days03;

public class Operator04 {

	public static void main(String[] args) {
		
		// 논리연산자  &&(AND), ||(OR), !(NOT)
		// 둘이상의 관계(비교)연산식 결과(true/false)값 또는 boolean 값을 연산하여 하나의 boolean 값을 결과로 얻는 연산
		// 피연산자 : boolean   ,  연산의 결과 :  boolean
				
		// && : 두항이 모두true 이어야 결과가 true, 둘중 하나가 false 이면 결과는 false 입니다
		// || : 두항이 모두 false 이어야 결과가 false, 둘중 하나가 true 이면 결과는 true 입니다
		// ! : 단항연산 - 피연산자의 true/false 값을 반대로 바꾸는 연산
		
		boolean b1;
		b1 = true && false;
		System.out.printf("%b && %b -> %b\n", true, false, b1);
		
		int a = 80;
		boolean b2 = a>50;
		boolean b3 = a<=100;
		
		b1 = b2 && b3;
		System.out.printf("b2 && b3 -> %b\n",b1);
		b1 = (a>50) && (a<=100);  //  50 < a <= 100 X
		System.out.println("a>50 이면서 a < 100 : " + b1);
		
		// a 변수의 값이 70보다 크거나 40보다 작으면  true, 아니면  false 출력
		b1 = (a>70)||(a<40);
		System.out.println("70 > a 이거나 a < 40 : " + b1);
		a = 50;
		b1 = (a>70) || (a<40);
		System.out.println("70 > a 이거나 a < 40 : " + b1);
		
		// AND 연산자 (&&)
		// 좌항과 우항의 관계(비교)식 결과 또는 boolean 값이 모두 true인 경우 true가 결과값
		// 좌항과 우항 중 하나라도 false 경우 false가 결과값
		// 좌항의 비교연산 결과가 false인 경우 우항의 식을 비교하지 않습니다.
		System.out.printf("F && F = %b\n", false && false);
		System.out.printf("T && F = %b\n", true && false);
		System.out.printf("F && T = %b\n", false && true);
		System.out.printf("T && T = %b\n", true && true);
		
		// OR 연산자 (||)
		// 좌항과관계식 결과 또는 boolean 값이 하나라도 결과가 true인 경우 true가 결과
		// 좌항과 우항 모두 false 경우 false가 결과
		// 좌항의 결과가 true인 경우 우항의 식을 비교하지 않습니다.
		System.out.printf("F || F = %b\n", false || false);
		System.out.printf("T || F = %b\n", true || false);
		System.out.printf("F || T = %b\n", false || true);
		System.out.printf("T || T = %b\n", true || true);
		
		// NOT 연산자(!)
		// 단항연산자, 피연산자의 논리값의 반대값을 결과로 냄  false->true   true->false
		b1 = false;
		System.out.printf("Not(!)%b = %b\n", b1, !b1);
		System.out.printf("Not(!)%b = %b\n", true, !true);
		
		// 점수가 80점이상이면서 90이하이면  true , 아니면 false 출력
		int number =85;
		boolean result = (number>=80) && (number<=90);
		System.out.printf("80이상이면서 90이하 result = %b\n", result);
		
		// 점수가 100이상이거나 50미만 이면 true, 아니면 false   (이거나, 또는 )
		number = 150;
		result = (number>=100) || (number<50);
		System.out.printf("100이산 또는 50미만 result = %b\n", result);
		
		int kor=35 , eng=98, mat=95;
		double avg;
		// 평균이 80이상이면서 영어점수가 75점 이상이고, 국어점수가 80이상이면 true  출력, 아니면  false 출력
		avg = (kor+eng+mat)/3.0;
		result = (avg>=80)&&(eng>=75)&&(kor>=80);
		System.out.printf("평균 80이상, 영어점수 75점 : %b\n", result);
		
		// 국어:50이상, 영어:60이상, 수학:70이상이면  true, 아니면 false  출력
		result = (kor>=50)&&(eng>=60)&&(mat>=70);
		System.out.printf("국어:50이상, 영어:60이상, 수학:70이상 : %b\n", result);
		
		// 세과목중 한과목이라도 40 미만이라면   true , 모두 40이상 false  출력
		result = (kor<40)||(eng<40)||(mat<40);
		// result = !(  (kor>=40)&&(eng>=40)&&(mat>=40) );
		System.out.printf("세과목 중 한과목 또는 그 이상과목 40 미만 :  %b\n", result);
		
		// 평균 60이상  모든과목 40이상 이라면   true, 아니면 false  출력  (논리연산의 대상이 네개)
		result = (avg>=60)&&(kor>=40)&&(mat>=40)&&(eng>=40);
		System.out.printf("평균 60이상 그리고 모든과목 40이상 :  %b\n", result);
		
		// 평균 60미만이거나  한과목이라도  40미만이라면   true, 아니면 false  출력 (논리연산의 대상이 네개)
		result = (avg<60)||(kor<40)||(mat<40)||(eng<40);
		System.out.printf("평균 60미만 또는 한과목이라도  40미만 :  %b\n", result);
		
		// 평균이 70이상이거나   영어와 수학이 모두 80이상이면   true (And 와 Or 의 혼합 연산)
		result = (avg>=70)||(  (eng>=80)&&(mat>=80)  );
		System.out.printf("평균 80이상 또는 영어수학 모두 80이상 :  %b\n", result);
		
		
		// 국어점수가 짝수라면  true, 홀수라면  false;
		int n = kor % 2;
		result = n == 0;
		// result = (kor%2) == 0;
		System.out.printf("국어점수 짝수 ? : %b\n", result);
		// 연산의 우선순위
		// 1. (    ) 괄호
		// 2. 피연산자 앞에 있는 ++, --
		// 3. 곱셈, 나눗셈, 나머지
		// 4. 덧셈, 뺄셈
		// 5. 관계연산 ,  논리연산
		// 6. =
		
		// year변수에 저장된 년도가 윤년이면 true, 평년이면 false 를 출력
		int year1 = 2020, year2 = 2023;
		// 윤년의 조건 
		// 해당 년도가 4의 배수 이면서, 100의 배수가 아니거나, 400의 배수인 해
		
		int x = year1 % 4;
		int y = year1 % 100;
		int z = year1 % 400;
		
		result = (x==0)||(y!=0)&&(z==0);
		System.out.println("2020년은 윤년? : " + result);
		
		result = ( year2 % 4 == 0) && ( year2 % 100 != 0 ) || ( year2 % 400==0 );
		// result = ( year2 % 4 == 0) && !( year2 % 100 == 0 ) || ( year2 % 400==0 );
		System.out.println("2022년은 윤년? : " + result);
	}

}











