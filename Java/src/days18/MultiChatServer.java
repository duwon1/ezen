package days18;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class MultiChatServer {

	HashMap clients;  
	//접속중인 클라이언트 와 연결들을 관리할 리스트
	// key : 클라이언트의 이름 - 클라이어트 접속과 함께 전달된 이름:숫자로 구성됨
	// Value : 클라이언트에 연결된 이름(key값)으로 생성된 dos(DataOutputStream)객체, 
	//            key 값에 해당하는 클라이언트에게 메세지를 보낼 전송객체
	// 해쉬맵에 저장된 클라이언트들의 dos 객체를 하나씩 꺼내서 한사람이 보낸메세지를 모두에게 전송해줍니다
	
	MultiChatServer(){
		clients = new HashMap();
		Collections.synchronizedMap( clients );
		//멀티 쓰레드 환경에서 단일 해쉬멥에  멀트스레드가 동시 접근하여 값을 변경하는것을 막는 동기화 도구.
	}
	
	//-------------------------------------------------------------------------------------------
	
	class ServerReciever extends Thread{  
		// 프로그램의 특성상 ServerReciever가 사용할 자료들이 MultiCatServer에 일부 존재하므로
		// ServerReciever 를  MultiChatServer 안에 넣어서 별도의 조치없이 그 자료를 사용하게 합니다
		Socket socket;
		DataInputStream dis;
		DataOutputStream dos;
		ServerReciever( Socket s ){
			this.socket = s;
			try {
				dis  = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				// 채팅참여자 한명이 보내온 메세지를 실시간으로 받아서 바로 모든 참여자에게 전송합니다
				// 실시간 수신에 Thread 가 필요하지만 그때 송신도 같이 할 예정이므로
				// 송신을 위한 Thread 는 별도로 만들지 않습니다
			} catch (IOException e) {	//e.printStackTrace();
			}
		}
		public void run() {
			String name = "";  // 접속한 참가자의 dis 객체의 참조변수를 저장할 변수
			try {
				name = dis.readUTF();
				sendToAll("#"+name+"님이 들어오셨습니다.");  //  출력(모든 클라이언트에게)
				clients.put(name, dos);
				System.out.println("현재 서버접속자 수는 "	+ clients.size()+"입니다.");
				
				while(dis != null) // 연결된 참여자(클라이언)가 보내는 모든 메세지를 모든 사용자에게 실시간으로 전송
					//현재 스레드의 주인공이 나갈때까지 반복
					sendToAll( dis.readUTF() );  
			} catch (IOException e) {
			} catch (Exception e) {
			} finally {
				sendToAll("#"+name+"님이 나가셨습니다.");
				clients.remove(name);  //해쉬맵에서 현재 사용자 삭제
				System.out.println("["+socket.getInetAddress() +":"+socket.getPort()+"]"
												+"에서 접속을 종료하였습니다.");
				System.out.println("현재 서버접속자 수는 "+ clients.size() + "입니다.");
			}	
		}
	}
	private void sendToAll(String msg) {
		Iterator it = clients.keySet().iterator();
		while(it.hasNext()) { 
			DataOutputStream out = (DataOutputStream)clients.get( it.next() );
			try {
				out.writeUTF(msg);  // 해쉬맵에서 꺼내온 out 객체를 통해 메세지 전송
			} catch (IOException e) {
			}
		}
		System.out.println(msg);
	}
	
	public void sijack() {
		ServerSocket ss = null;  
		Socket s = null;   
		try {
			ss = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다."); 
		} catch (IOException e1) {
		}
		while(true) {
			try {
				s = ss.accept();
				System.out.println("["+s.getInetAddress()+":" +s.getPort()+"]" + "에서 접속하였습니다.");
				ServerReciever th = new ServerReciever(s);  
				th.start();
			}catch (IOException e) {
			}
		}
	}
	public static void main(String[] args) {
		MultiChatServer k = new MultiChatServer();  // 객체 생성
		k.sijack();
	}

	

}
