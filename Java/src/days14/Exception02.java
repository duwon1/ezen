package days14;

public class Exception02 {

	public static void main(String[] args) {

		System.out.println(1);
		System.out.println(2);
		try {
			
			System.out.println(3);
			System.out.println(0/0);//예외가 발생한 지점에서 바로 catch쪽으로 이동함
			System.out.println(4);//예외처리 구간에서 발생된 예외명령 이후는 실행되지 않음
			
		}catch (ArithmeticException e) {//종류별 예외 처리 1
			
			e.printStackTrace(); //java.lang.ArithmeticException: /by zero
			System.out.println("예외메세지 : "+e.getMessage());
			
		}catch(Exception e) {//종류별 예외 처리 2
			System.out.println("Exception");
		}
		System.out.println(5);
	}
}
