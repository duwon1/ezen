package days18;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class ClientSender extends Thread{
	Socket socket;
	DataOutputStream dos;
	String name;
	public ClientSender(Socket s, String name) {
		this.socket = s;
		this.name = name;
		try {
			this.dos = new DataOutputStream( socket.getOutputStream() );
		} catch (IOException e) { 	}
	}
	public void run() {
		Scanner sc = new Scanner(System.in);
		if( dos != null) {
			try {
				dos.writeUTF(name); // 최초 접속시 이름을 서버로 보냄
				while(dos != null)	 dos.writeUTF("["+name+"]" + sc.nextLine() );
			} catch (IOException e) {	}
		}
	}
}
class ClientReceiver extends Thread {
	Socket socket;
	DataInputStream dis;
	public ClientReceiver(Socket s) {
		this.socket = s;
		try {
			this.dis = new DataInputStream( socket.getInputStream() );
		} catch (IOException e) { 	}
	}	
	public void run() {
		while(dis != null) {
			try { 	
				System.out.println( dis.readUTF() );
			} catch(IOException e) {  }
		}
	}
}
public class MultiChatClient {

	public static void main(String[] args) {
		
		String serverIp = "192.168.0.44";
		Scanner sc = new Scanner(System.in);
		System.out.print("채팅방에서 사용할 이름을 입력하세요 : ");
		String name = sc.nextLine();
		try {
			Socket s = new Socket(serverIp, 7777);
			System.out.println("서버에 연결되었습니다.");
			ClientSender cs = new ClientSender(s, name);
			ClientReceiver cr = new ClientReceiver(s);
			cs.start();
			cr.start();	
		} catch (UnknownHostException e) {
			System.out.println("해당 아이피의 서버(호스트)를 찾을수 없습니다");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("해당 아이피의 서버(호스트)와 연결에 실패했습니다");
			e.printStackTrace();
		}

	}

}
