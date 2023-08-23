package days14;

public class Exception05 {

	public static void main(String[] args) {

		try {
			method01();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void method01() throws Exception {
		
			method02();
		
//		try {
//			method02();
//		} catch (Exception e) {
//		}
	}
	public static void method02() throws Exception {
		
		throw new Exception(); //예외 강제 발생
	
//		예외사항에 마우스를 올리고, 풍선도움말처럼 표시되는 곳에서 메뉴를 선택함
//		1.add throw declaration
//		2.surround with try catch
//		2번을 선택하면 현재위치에서 try catch가 추가되며, 이는 현재메서드에서 에러처리를 마무리하겠다는 뜻
//		또는 수동으로 try catch를 사용해줄 수 도 있음
//		try {
//		throw new Exception(); //예외 강제 발생
//		}catch(Exception e) {
//			
//		}
	}
}
