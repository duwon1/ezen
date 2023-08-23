package days17;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class IO09 {

	public static void main(String[] args) throws IOException {
		
		File d = new File("D:\\JAVA01\\java_se\\temp");
		if( !d.exists() ) d.mkdir();
		
		File fileBinary = new File( d, "binaryData.dat");
		File fileText = new File(d, "textData.txt");
		
		// 파일로 부터 이진데터를 읽어 오기 위한 스티림 객체 생성
		FileInputStream fisBinary = new FileInputStream( fileBinary );
		FileReader fisText = new FileReader( fileText );
		// 파일의 존재와 오픈의 오류는 디스크 상의 문제와 파일 존재유무에 따른 것이므로, 명령으로 해결할 수 없습니다
		// 따라서 파일 입출력( 또는 화면입출력)은 항상 예외처리가 따라다닙니다.
		// 이진데이터 읽어와서 출력
		// binary 형식으로 써넣은 내용은  binary 형식으로 읽어서 실제 구분할 수 있는 데이터를 얻을수 있습니다
		int dataBinary;
		dataBinary = fisBinary.read();
		System.out.println(dataBinary);
		dataBinary = fisBinary.read();
		System.out.println(dataBinary);
		fisBinary.close();
		
		// text 데이터는 한글자씩 읽어옵니다. 그래서 반복실행문을 이용합니다
		// 텍스트 파일의 내용을 한 글자씩 읽어들이는 경우 입력 데이터의 저장 형식은 반드시 int 타입으로 문자값을 
		// 전달 받아야합니다.
		// 파일에 끝에 도달하면 -1 값이 읽혀져 오는데,  char 은 부호가 없는 자료형이므로 -값을 처리할 수 없고, 
		// 파일의 끝으로 인식되지 않기 때문입니다.
		// char 형으로 읽어 낸다면, 무조건 양수로만 취급하여 반복을 빠져나올 수 없습니다.
		int dataText;
		dataText = fisText.read();
		while( dataText != -1 ) {   // 읽어낸 한글자가 파일의 끝을 가리키는 -1 이 아니라면  계속 반복
			System.out.print((char)dataText);
			dataText = fisText.read();
		}
		//while( ( data_text = fisText.read() ) != -1 )
		//		System.out.print((char)dataTtext);
		fisText.close();
		
	}

}







