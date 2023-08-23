package days17;

import java.io.IOException;

public class IO02 {

	public static void main(String[] args) throws IOException {
		
		// InputStream 클래스의 read 메소드
		// read() : 입력 스트림으로부터 가장 앞에 위치한 1 바이트를 읽어옵니다
		// read(byte []) : 입력 스트림의 가장 앞부터 매개변수로 전달된 배열의 크기까지의 바이트를 읽어옴
		// read(byte [], int startIndex, int size) : 입력 스트림의 가장 앞부터 size 크기만큼 데이터를 읽어옵니다 
		// 저장은 매개변수로 전달된 배열의 startIndex 위치부터 저장

		byte [] input = new byte[20];   //  byte  형 정수 20개짜리 배열
		System.out.print("키보드 입력을 실행하세요 : ");
		// 입력한 내용은 input 배열에 저장. 입력한 크기 또는 글자수는  size 에 저장
		int size = System.in.read( input );   // 키보드입력을  input 배열에 입력순서데로 저장하도록 read 실행
		// size 에는 입력받은 데이터들의 갯수를 저장
		System.out.printf("읽어온 바이트의 크기는 %d 입니다.\n", size);
		
		for( int i = 0 ; i < input.length ; i++ ) 
			System.out.printf("%c ", (char)input[i]);
		
		// 입력 : ABCDEFG
		// 출력
		// 읽어온 바이트의 크기는 9 입니다.
		// A B C D E F G 
		// 그리고 이상한 글자들 ...... 
		
		// 바이트수 : 입력 글자들 + 2
		// 마지막 이상한 글자들은 new byte 에 의해 초기화된 0이  char 로 형변환되어 출력된 내용
				
	}

}





