package days17;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;




public class IO08 {

	public static void main(String[] args) throws IOException {
		
		File dir = new File("D:\\JAVA01\\Java_se\\temp");
		if( !dir.exists() ) dir.mkdirs();  // 경로 없으면 생성	
		
		File fileBinary = new File(dir, "binaryData.dat");
		File fileText = new File(dir, "textData.txt");
		
		// 파일 처리
		// File 에 데이터를 출력하는 클레스 FileOutputStream(이진데이터파일객체), 
		// FileWriter(문자데이터파일객체)
		// 파일 출력 스트림 객체는 해당 파일이 존재하지 않는 경우  파일을 생성하여 스트림을 구성합니다
				
		// 파일에 이진 데이터를 출력할 수 있는 객체 생성 & 해당 파일도 생성
		FileOutputStream fosBinary = new FileOutputStream( fileBinary );

		// 파일에 문자 데이터를 출력할 수 있는 객체 생성 & 해당 파일 생성
		FileWriter fosText = new FileWriter(fileText);
		
		// 파일에 간단 내용을 출력합니다.
		fosBinary.write(111);
		fosBinary.write(222);
		fosText.write("Hello ");
		fosText.write("World");
		
		fosBinary.close();
		fosText.close();
		// 열었던 파일을 가능한 꼭 닫아주세요.  
		// 닫지 않아도 운영체제의 운영특성상 닫히겠지만, 간혹 안닫힌 파일이 쌓여서 오류를 일으키는 경우가 있습니다.
	}

}
