package days14;

import java.util.Scanner;

public class Exception07 {

	public static void main(String[] args) {

//		sc.nextLine()을 이용해 순수하게 숫자만으로 이루어진 정수를 입력받고
//		Integer.parseInt()를 이용해서 정수로 변환하고 while과 try-catch를 제작
//		입력값에 문자가 섞이거나 하면 에러가 발생되어 "잘못입력했습니다"라고 출력
//		Integer.parseInt()메서드는 숫자로 변환될 입력이 아라비아기호(문자)가 아닌 다른 문자 등이 입력되면
//		에러가 발생 NumberFormatException
		
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.println("정수를 입력하세요 : ");
		while(true) {
		try {
		num= Integer.parseInt(sc.nextLine());
		break;
		}catch(NumberFormatException e){
			System.out.println("잘못입력했습니다. 다시 입력하세요 : ");
		}
		}
		System.out.println("입력한 정수는 : "+num);
	}
}
