package days15;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class JGridLayout extends JFrame{
	
	JGridLayout(){
		
		Container con = getContentPane();
		con.setLayout(new GridLayout(3, 5, 20, 20));//3행 5열 가로 세로 간격 20px씩의 배치
		//화면의 배치를 행과 열의 개수로 배치하고 조절
		
		for(int i =1; i<=15; i++)
			con.add(new JButton("Button"+i));
		
		setTitle("GridLayout Practice");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
}
public class Swing08 {

	public static void main(String[] args) {
		new JGridLayout();
	}

}
