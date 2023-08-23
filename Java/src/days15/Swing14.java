package days15;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Calendars extends JFrame{
	
	JTextField [] jt = new JTextField[42];
	
	Calendars(){
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		
		jp1.setLayout(new GridLayout(1,7)); //일 월 화 수 목 금 토 맨윗줄 요일이 표시될 부분
		jp2.setLayout(new GridLayout(6,7)); //달력이 표시될 부분
		jp3.setLayout(new FlowLayout()); //현재 달력의 년 월이 표시될 부분
		
		Font f = new Font("굴림", Font.BOLD,20);
		JButton b1 = new JButton("일");
		b1.setFont(f);
		JButton b2 = new JButton("월");
		b2.setFont(f);
		JButton b3 = new JButton("화");
		b3.setFont(f);
		JButton b4 = new JButton("수");
		b4.setFont(f);
		JButton b5 = new JButton("목");
		b5.setFont(f);
		JButton b6 = new JButton("금");
		b6.setFont(f);
		JButton b7 = new JButton("토");
		b7.setFont(f);
		
		jp1.add(b1).setForeground(Color.RED);
		jp1.add(b2);
		jp1.add(b3);
		jp1.add(b4);
		jp1.add(b5);
		jp1.add(b6).setForeground(Color.BLUE);
		
		con.add(jp1, BorderLayout.NORTH);
		setTitle("Swing Calendar");
		setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
public class Swing14 {

	public static void main(String[] args) {
		new Calendars();
	}

}
