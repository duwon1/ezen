package days17;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class IO13 {

	public static void main(String[] args) throws IOException {
		
		File dir = new File("D:\\JAVA01\\Java_se\\temp");
		if( !dir.exists() )	dir.mkdirs();
		
		File fileBinary = new File(dir, "biary_data_using_buffer.dat");
		File fileText = new File(dir, "text_data_using_buffer.txt");
		
		FileInputStream fis = new FileInputStream(fileBinary);
		BufferedInputStream bisBinary = new BufferedInputStream(fis);
		
		BufferedReader brText = new BufferedReader(new FileReader(fileText));
		
		int input;
		while( (input = bisBinary.read()) != -1 )
			System.out.printf("%d  \n", input);
				
		
		System.out.println();
		while( (input = brText.read()) != -1 ) 	
			System.out.printf("%c", input);
		
		bisBinary.close();
		brText.close();
		

	}

}
