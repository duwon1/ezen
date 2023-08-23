package days15;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

class JBorderLayout extends JFrame{
	
	JBorderLayout(){
		Container con = getContentPane();
		con.setLayout(new BorderLayout(10,10));
		//화면을 동서남북중앙으로 나눠서 배치하는 레이아웃
		//각 지역간의 간격 가로세로 10px
		
		con.add(new JButton("East Button"), BorderLayout.EAST);
		con.add(new JButton("West Button"), BorderLayout.WEST);
		con.add(new JButton("South Button"), BorderLayout.SOUTH);
		con.add(new JButton("North Button"), BorderLayout.NORTH);
		con.add(new JButton("Center Button"), BorderLayout.CENTER);
		//Center는 정의하지 않으면 자리가 남지만 이외의 영역은 정의하지 않으면 다른 영역이 그 자리를 차지함
		
		setTitle("BorderLayout Practice");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
}
public class Swing07 {

	public static void main(String[] args) {
		new JBorderLayout();
	}

}
