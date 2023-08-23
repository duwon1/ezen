package days15;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//배치 관리자
class JFlowLayout extends JFrame{
	
	JFlowLayout(){

//		배치관리자 없이 버튼을 컨테이너에 무작정 올린 형태 (FlowLayout 적용이 안된 상태)
//		JButton btn1 = new JButton("Button1");
//		JButton btn2 = new JButton("Button2");
//		Container con = getContentPane();
//		con.add(btn1);
//		con.add(btn2);
//		con.add( new JButton("Button3"));
		//모든 구성요소가 겹쳐져서 화면을 꽉 채우고 표시함. 가장 마지막 add된 것만 화면에 표시
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 10));
		//50 : 콘트롤끼리의 가로 방향 간격 10: 세로 방향 간격
		// FlowLayout.RIGHT, FlowLayout.LEFT :정렬방식
		
		for(int i = 1; i<=15; i++)
			con.add(new JButton("Button"+i));
		//버튼 생성과 동시에 바로 적재
		//버튼을 위한 레퍼런스 변수가 없어서 이후 제어는 불가
		//적재 모습만 보여주기 위한 예제
		
		
		setTitle("Deployment Manager Practice");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
public class Swing06 {

	public static void main(String[] args) {

		new JFlowLayout();
	}

}
