package days17;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IO10 {

	public static void main(String[] args) throws IOException {
		// 1. 선거에 있어서 "최고득표자"가 2인 이상인 때에는 국회의 재적의원 과반수가	출석한 공개회의에서 다수표를 얻은 자를 
		// "당선자"로 한다. 이 헌법시행 당시의 법령과 조약은 이 헌법에 위배되지 아니하는 한 그 효력을 지속한다.
		//
		// 2. 국회의 회의는 공개한다. 다만, 출석의원 50%이상의 찬성이 있거나 의장이 국가의 안전보장을 위하여 필요하다고 
		// 인정할 때에는 공개하지 아니할 수 있다.
				
		// abc.txt 에 위의 텍스트를 써넣으세요(경로는 D:\JAVA01\Java_se\temp)
		// 한번의 명령으로 써넣으셔도 돼고 파일 출력 명령을 두번 또는 세번에 나눠서 실행하셔도 됩니다. 
		// 문단 간격(두줄 띠움)유지해서 출력해주세(FileWriter 를 이용합니다)
		
		File d = new File("D:\\JAVA01\\Java_se\\temp");
		if( !d.exists() ) d.mkdir();
		
		File fileText = new File( d, "abc.txt");
		FileWriter fwText = new FileWriter( fileText );
		
		fwText.write("1. 선거에 있어서 \"최고득표자\"가 2인 이상인 때에는 국회의 재적의원 과반수가 출석한 공개회의에서 다수표를 "
				+ "얻은 자를 당선자로 한다. 이 헌법시행 당시의 법령과 조약은 이 헌법에 위배되지 아니하는 한 그 효력을 지속한다.\n\n");
		fwText.write("2. 국회의 회의는 공개한다. 다만, 출석의원 50%이상의 찬성이 있거나 의장이 국가의 안전보장을 위하여 "
				+ "필요하다고 인정할 때에는 공개하지 아니할 수 있다.");

		fwText.close();
	}

}




