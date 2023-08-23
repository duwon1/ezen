package days15;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class ButtonEvent extends JFrame implements ActionListener{//단일상속만 가능해 implement하기
	//1. ActionListener implements 하기
	//2. 적용할 컨트롤에 addActionListener메서드로 감시설정하기
	//3. 해당 컨트롤에 이벤트가 발생하면 호출되는 ActionPerformed 메서드를 오버라이드 하기
	JLabel result;
	
	ButtonEvent(){
		JButton male = new JButton("male");
		JButton female = new JButton("female");
		JLabel label = new JLabel("Select your sex");
		result = new JLabel(""); //버튼 클릭에 의해 결과가 담길 최초 비어있는 라벨
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(label);
		con.add(female);
		con.add(male);
		con.add(result);
		
		male.addActionListener(this);
		female.addActionListener(this);
		//구체적인 이벤트 감시대상을 설정. 위 두개의 버튼 중 하나가 클릭되면 ActionPerformed가 호출
		
		setTitle("Button Event Test");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//리스너가 설정된 컨트롤에 이벤트가 일어나면 자동호출되는 메서드 : 이벤트가 일어난 내용이 e에 전달
		String s = e.getActionCommand(); // 이벤트가 일어난 컨트롤에 표시된 텍스트를 얻어 String 변수로 저장
//		System.out.println(s);
		result.setText(s+" selected"); //버튼 클릭한 내용을 result에 넣어주는 내용
		
	}
}
public class Swing03 {

	public static void main(String[] args) {

		new ButtonEvent();
	}

}
