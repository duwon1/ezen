package days14;

import java.io.File;
import java.io.IOException;

public class Exception08 {

	static int count =0;
	public static void main(String[] args) {

		File f1= createFile("abc.txt");
		File f2= createFile("");
		File f3= createFile("");
		
		
	}
	
	private static File createFile(String fileName) {
		File f = null;
		// 전달된 String 데이터로 파일 이름정해서 정해진 저장장소에 파일을 저장합니다
		try {
			if((fileName==null)||(fileName.equals(""))) {
				throw new IOException("파일이름이 유효하지 않습니다");
			}
			
		}catch(IOException e) {
			
			fileName="제목없음"+ ++count+".txt";
			//count 변수는 현재위치에서만 증가함. 정상 파일이름이 전달된 경우 증가하지 않음
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {//예외가 발생하든 안하든 반드시 마지막에 실행하는 영역
		f= new File(fileName); //객체만 생성
		try {
			f.createNewFile(); //객체를 이용해서 저장장치에 실제 파일 생성
		}catch(IOException e) {
			System.out.println(fileName+"파일 생성에 실패했습니다.");
		}
		}
		return f;
	}

}
