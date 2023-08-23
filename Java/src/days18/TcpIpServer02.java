package days18;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer02 {
	
	public static void main(String[] args) {
		
		ServerSocket ss = null; 
		try {
			ss = new ServerSocket(7777);
			System.out.println( getTime()  + " 서버가 준비되었습니다");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}  
		while(true) {
			try {
				System.out.println( getTime() + " 연결 요청을 기다립니다");
				ss.setSoTimeout( 15000 );
				// 서버 소켓이 클리이언트 요청을 기다리는 시간 설정
				// 설정된 시간이 지날때까지 요청이 없으면 SocketTimeoutException 예외가 발생합니다
				Socket s = ss.accept();
				System.out.println( getTime() + " " + s.getInetAddress() + " 이(가) 연결요청하였습니다" );
				OutputStream out = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				dos.writeUTF(" [연결완료] 204호 00번 서버로 연결이 완료되었습니다.");
				System.out.println(getTime()+"데이터를 전송했습니다.");
				dos.close();
				s.close(); 
			}catch (SocketTimeoutException  e) { 
				System.out.println(getTime() + "접속시간 초과. 서버를 종료합니다");
				System.exit(0);  // return 대신 사용할수 있는 프로그램 종료 명령
			}catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}  // [hh:mm:ss] 이 양식으로 현재 시간을 String 으로 리턴하는 메서드
}
