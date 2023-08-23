package days15;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//윈도우에 텍스트필드1 버튼1  버튼2 텍스트필드2 순서로 배치
//버튼1의 표면에서 "▶"글자 표시, 버튼2의 표면에는 "◀"글자를 표시
//버튼1을 클릭하면 텍스트필드1의 글자가 텍스트필드2로 옮겨지게
//버튼2를 클릭하면 텍스트필드2의 글자가 텍스트필드1로 옮겨지게
//글자가 없는 상태에서 버튼을 클릭하면 아무 일도 안일어나게...
//윈도클래스 이름은 TextFieldEx로 제작
//윈도우의 가로 세로 크기는 적절히 조절

class TextFieldEx extends JFrame implements ActionListener{
	TextField t1;
	TextField t2;
	TextFieldEx(){
		t1= new TextField(15);
		t2= new TextField(15);
		
		JButton b1 = new JButton("▶");
		JButton b2 = new JButton("◀");
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(t1); con.add(b1); con.add(b2); con.add(t2); 
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setTitle("TextField Practice");
		setSize(500,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if(s.equals("▶")) {
			if(!(t1.getText().equals(""))) {
				String s2 = t1.getText();
				t2.setText(s2);
				t1.setText("");
			}
		}else {
			if(!(t2.getText().equals(""))) {
				String s2 = t2.getText();
				t1.setText(s2);
				t2.setText("");
			}
		}
		
		//내가 한 버전
//		String s1= t1.getText();
//		String s2= t2.getText();
//		t1.setText("");
//		t2.setText("");
//		t1.setText(s2);
//		t2.setText(s1);
	}
	
}
public class Swing11 {

	public static void main(String[] args) {
		new TextFieldEx();
	}

}
