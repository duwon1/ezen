package days15;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//하나의 윈도우에 여러 레이아웃이 동시에 적용되어야 할 때 
//각각의 레이아웃을 컨테이너가 아닌 패널에 정의하고 그 패널들을 다시 컨테이너에 배치
class JPanelTest extends JFrame{
	JPanelTest(){
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		//컨테이너 자체는 BorderLayout으로 설정
		
		//패널 두개 생성
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		
		//각 패널은 아래와 같이 서로 행과 열이 다른 Grid 레이아웃으로 설정
		jp1.setLayout(new GridLayout(5,1));
		jp2.setLayout(new GridLayout(4,1));
		
		jp1.add(new JButton("JAVA"));
		jp1.add(new JButton("C++"));
		jp1.add(new JButton("ASP"));
		jp1.add(new JButton("JSP"));
		jp1.add(new JButton("PHP"));
		
		jp2.add(new JButton("HTML5"));
		jp2.add(new JButton("CSS"));
		jp2.add(new JButton("JQUERY"));
		jp2.add(new JButton("AJAX"));
		
		con.add(jp1, BorderLayout.WEST);
		con.add(jp2, BorderLayout.EAST);
		
		setTitle("Panel Practice");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class Swing12 {

	public static void main(String[] args) {
		new JPanelTest();
	}

}
