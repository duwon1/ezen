package days13;

import java.math.BigInteger;

public class BigIntegerClass {

	public static void main(String[] args) {

//	BigInteger Class : int 와 long형 자료로 담아낼 수 없이 큰 숫자를 다룰 수 있게 만든 클래스
//	BigInteger bi =1 ; //에러 //단순숫자자료는 모두 int형
//	BigInteger bi = (long)1;//에러 //long으로 캐스팅해도 BigInteger에는 입력 불가능
	
	BigInteger bi = BigInteger.ONE;
	System.out.println(bi);
	
	for(int n =1; n<=40; n++) {
		//1!부터 40!까지 모두 출력
		BigInteger fact = BigInteger.ONE;
		for(BigInteger start = BigInteger.ONE; 
				start.compareTo(BigInteger.valueOf(n))<=0;
				start=start.add(BigInteger.ONE)) {
			fact=fact.multiply(start);
		}
		//.valueOf():일반정수를 BigInteger 자료형으로 변환하는 메서드
		//.add(): 호출객체와 전달인수 객체간의 덧셈. 호출객체는 변하지 않고 연산결과만 다른 객체에 저장하는 형식
		//.multiply(): 호출객체와 전달인수 객체간의 곱셈. 호출객체는 변하지 않고 연산결과만 다른 객체에 저장하는 형식
		System.out.printf("%d! =  %s\n", n, fact.toString());
	}
	}
}
