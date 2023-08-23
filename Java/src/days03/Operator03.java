package days03;

public class Operator03 {

	public static void main(String[] args) {
		
		// 관계연산자(비교연산자)
		// >(초과), <(미만), >=(이상≥), <=(이하≤), ==(같다), !=(같지않다)
		// 좌향과 우향의 크기를 비교해 true/false 값이 결과가 되는 연산
		// 관계식이 올바른 경우 true, 관계식이 틀린 경우 false 가 연산의 결과가 됨
		// n++ -> 단항연산		n1 < n2 -> 이항연산(다항연산)
		
		int n1 = 10;
		int n2 = 5;
		boolean result;
		
		result = n1 > n2;
		// n1 변수의 값이 n2 변수의 값보다 크면 true, 작으면  false 값이 저장
		System.out.printf("%d > %d -> %b\n", n1, n2, result);
		result = n1 < n2;
		System.out.printf("%d < %d -> %b\n", n1, n2, result);
		result = n1 >= n2;
		System.out.printf("%d >= %d -> %b\n", n1, n2, result);
		result = n1 <= n2;
		System.out.printf("%d <= %d -> %b\n", n1, n2, result);
		result = n1 == n2;
		System.out.printf("%d == %d -> %b\n", n1, n2, result);
		result = n1 != n2;
		System.out.printf("%d != %d -> %b\n", n1, n2, result);
		
		// 문자 (char) 데이터의 비교 : 각 데이터가 갖는 아스키 코드 값으로 비교
		char c1 = 'A', c2 = 'B';
		
		result=c1>c2;
		System.out.printf("%c>%c -> %b\n", c1, c2, result);
		result=c1<c2;
		System.out.printf("%c<%c -> %b\n", c1, c2, result);
		result='C'=='C';
		System.out.printf("%c==%c -> %b\n", 'C', 'C', result);
		result='C'!='C';
		System.out.printf("%c!=%c -> %b\n", 'C', 'C', result);
		
		// String data 비교
		String s1 = "1234";
		String s2 = "987";
//		result = s1>s2; 에러
//		result = s1 == s2; //동작은 에러가 없지만 글자들의 비교가 일어나지 않음
//		result = s1 != s2; //동작은 에러가 없지만 글자들의 비교가 일어나지 않음
		
		int r = s1.compareTo(s2);
		System.out.printf("%s > %s => %d\n", s1, s2, r); // 앞글자와 뒷글자의 첫글자(같으면 계속 뒤로감)를 빼서 뺄셈을 함
		
		result = s1.equals(s2);
		System.out.printf("%s == %s => %b\n", s1, s2, result); 
		
		s2 = "1234";
		result = s1.equals("1234");
		System.out.printf("%s == %s => %b\n", s1, s2, result); 
		
		// String 을 대상으로 할 수 있는 비교연산은 ==와 != 둘 밖에 없으며, 이마저도 우리가 원하는 결과로 연산되지 않음
		//그래서 ==와 != 연산이 에러없이 가능은 하지만 이도 사용은 안함
		
		// s1 과 s2는 String 자료형이고, 다른 기본 자료형과 다르게 이 두변수가 직접 문자들을 저장x
		// 문자들은 별도의 장소에 저장되고, 변수는 저장위치값만 저장함
		// 따라서 변수들간의 비교(s1>s2)는 저장위치정보의 비교이므로 연산이 의미가 있지도 않고 가능하지도 않음
		
		// String 자료간의 비교는 별도로 만들어져 있는 도구 이용
		// String의 대소를 판단하는 compareTo()
		// String의 같다 다르다를 판단하는 equals()
		
		// compareTo()를 사용한 결과는 앞선항의 글자에서 뒷항의 글자를 뺀 결과가 정수형태로 나옴
		// 앞글자가 크면 양수, 뒷글자가 크면 음수, 같으면 0
		
		
		
	}

}
