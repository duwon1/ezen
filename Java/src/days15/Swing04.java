package days15;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class JImageTest extends JFrame implements ActionListener{
	JLabel result;
	
	JImageTest(){
	//이미지 파일을 불러와서 자바 Swing 화면에 표시하려면 이미지 파일을 아이콘형태로 변환해 사용해야 함
		ImageIcon ii1 = new ImageIcon("images/korea.gif");
		ImageIcon ii2 = new ImageIcon("images/germany9060.gif");
		ImageIcon ii3 = new ImageIcon("images/usa9060.gif");
		
		//버튼을 텍스트를 표함해 이미지까지 표시해 생성
		JButton korea = new JButton("Korea", ii1);
		JButton germany = new JButton("Germany", ii2);
		JButton usa = new JButton("USA", ii3);
		result = new JLabel("");
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(korea);
		con.add(germany);
		con.add(usa);
		con.add(result);
		
		korea.addActionListener(this); //이벤트 감시대상 //this는 Container con을 뜻한다고 함
		germany.addActionListener(this);
		usa.addActionListener(this);
		
		setTitle("Image Icon Practice");
		setSize ( 600, 180);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//액션리스너를 이용해 버튼이 클릭되면 클릭된 버튼의 나라이름이 result 라벨에 쓰여지게 하기
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		result.setText("You selected "+s);
	}
}
public class Swing04 {

	public static void main(String[] args) {
		
		new JImageTest();

	}

}
