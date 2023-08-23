package days14;

import javax.swing.JOptionPane;

class ThreadE extends Thread{
	
	private boolean state = true; //run 메서드 내부에서 실행종료를 판단할 변수. true-계속 실행
	public void setState(boolean s) {
		state=s;
		//main에서 시간제한 카운트가 다 끝나기전 이 메서드를 호출해서 state가 false로 바뀌면 run메서드 안의 반복실행은 종료
	}
	
	public void run() {
		//아래 반복문이 실행되다가 다 실행되기 전 main의 입력이 발생하면 반복실행문을 중단시킬 예정
		for(int i=10; (i>0)&&(state==true);i--) {
			System.out.println(i+"초 남았습니다");
			try {
				sleep(1000);
			}catch(Exception e) {}
		}
	}
}
public class Thread04 {

	public static void main(String[] args) {
		
		ThreadE e = new ThreadE();
		e.start();
		String input = JOptionPane.showInputDialog("Type the Answer");
		//다이얼로그 박스에 입력이 되면 다음 명령이 실행되고 입력이 없으면 계속 대기함
		// 이 아래 명령이 실행된다는 건 입력이 되었다는 뜻
		e.setState(false);
		System.out.println("The Answer you typed is "+input);

	}

}
