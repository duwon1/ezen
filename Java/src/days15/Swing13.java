package days15;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
//컨테이너의 레이아웃 : 5행 1열의 GridLayout
//
//1행 : JPanel p1 배치 ->p1 에는 GridLayout으로 TextField 한개 배치
//2행 : JPanel p2 배치 ->p2 에는 GridLayout으로 버튼 네개(7,8,9,+)
//3행 : JPanel p3 배치 ->p3 에는 GridLayout으로 버튼 네개(4,5,6,-)
//4행 : JPanel p4 배치 ->p4 에는 GridLayout으로 버튼 네개(1,2,3,x)
//5행 : JPanel p5 배치 ->p5 에는 GridLayout으로 버튼 네개(C,0,=,÷)
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class Calculator extends JFrame implements ActionListener{
	JTextField jt;
	
	int firstNumber;
	int secondNumber;
	String operator;
	
	Calculator(){
		Container con = getContentPane();
		con.setLayout(new GridLayout(6,1));
		
		//폰트 객체 생성
		Font f = new Font("굴림", Font.BOLD, 20);
		
		JPanel j0 =new JPanel();
		JPanel j1=new JPanel();
		JPanel j2=new JPanel();
		JPanel j3=new JPanel();
		JPanel j4=new JPanel();
		JPanel j5=new JPanel();
		
		
		j0.setLayout(new GridLayout(1,1));
		jt = new JTextField(15);
		jt.setFont(f);//폰트 적용
		jt.setHorizontalAlignment(SwingConstants.RIGHT); //오른쪽 정렬
		jt.setEditable(false);//편집불가능으로 설정
		jt.setText("0");//최초텍스트 0
		
		j0.add(jt);
		con.add(j0);
		
		j1.setLayout(new GridLayout(1,4));
		JButton b7 = new JButton("7");	
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		JButton bplus = new JButton("+");
		b7.setFont(f);
		b8.setFont(f);
		b9.setFont(f);
		bplus.setFont(f);
		j1.add(b7);
		j1.add(b8);
		j1.add(b9);
		j1.add(bplus);
		con.add(j1);
		
		j2.setLayout(new GridLayout(1,4));
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton bminus = new JButton("-");
		b4.setFont(f);
		b5.setFont(f);
		b6.setFont(f);
		bminus.setFont(f);
		j2.add(b4);
		j2.add(b5);
		j2.add(b6);
		j2.add(bminus);
		con.add(j2);

		j3.setLayout(new GridLayout(1,4));
		JButton b1 = new JButton("1");	
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton bmul = new JButton("x");
		b1.setFont(f);
		b2.setFont(f);
		b3.setFont(f);
		bmul.setFont(f);
		j3.add(b1);
		j3.add(b2);
		j3.add(b3);
		j3.add(bmul);
		con.add(j3);

		
		j4.setLayout(new GridLayout(1,4));
		JButton bC = new JButton("C");	
		JButton b0 = new JButton("0");
		JButton beq = new JButton("=");
		JButton bdi = new JButton("÷");
		bC.setFont(f);
		b0.setFont(f);
		beq.setFont(f);
		bdi.setFont(f);
		j4.add(bC);
		j4.add(b0);
		j4.add(beq);
		j4.add(bdi);
		con.add(j4);

		
		j5.setLayout(new GridLayout(1,4));
		JButton bb = new JButton("<-");	
		JButton b10 = new JButton("sqr");
		JButton b11 = new JButton("1/x");
		JButton b12 = new JButton("X*X");
		bb.setFont(f);
		b10.setFont(f);
		b11.setFont(f);
		b12.setFont(f);
		j5.add(bb);
		j5.add(b10);
		j5.add(b11);
		j5.add(b12);
		con.add(j5);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		
		bb.addActionListener(this);
		bC.addActionListener(this);
		
		bplus.addActionListener(this);
		bminus.addActionListener(this);
		bdi.addActionListener(this);
		bmul.addActionListener(this);
		beq.addActionListener(this);
		
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);

		setTitle("Calculator");
		setSize( 400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//0~9버튼을 클릭하면 최초값 0은 지워지고 클릭되는 숫자들이 쌓게 코딩하기
		//switch를 이용하기
		String s = e.getActionCommand();
		String oldText="";
		oldText = jt.getText();
		DecimalFormat df=new DecimalFormat("#.####");

		switch(s) {
			case "0" : 	case "1" : 	case "2" : case "3" : case "4" : case "5" : case "6" : 
			case "7" : case "8" : case "9" : 
				if(oldText.equals("0"))oldText="";
				jt.setText(oldText +s);
				break;
			case "C":
				jt.setText("0");
				break;
			case "<-":
				//현재 텍스트의 글자개수를 얻는 메서드 : length()
				//현재 텍스트의 일부 글자를 추출하는 메서드 : substring()
				//"123456"->"12345"
				//"<-"버튼을 클릭하면 맨 오른족 글자를 제외한 나머지 글자를 취해서 다시 jt에 넣기
//				int strNum = oldText.length();
//				String newText = oldText.substring(0,strNum);
				if(oldText.length()==1)jt.setText("0"); //이걸안해주면 1개남았을때 지워지고 오류남
				else {
					String newText =oldText.substring(0,oldText.length()-1);
					jt.setText(newText);
				}
				break;
			case "+":	case "-":	case "x":	case "÷":  
				operator = s;
				firstNumber = Integer.parseInt(jt.getText());
				jt.setText("0");
				break;
			case "=" :
				secondNumber = Integer.parseInt(jt.getText());
				switch(operator) {
				case "+":
					jt.setText(String.valueOf(firstNumber+secondNumber)); break;
				case "-":
					jt.setText(String.valueOf(firstNumber-secondNumber)); break;
				case "x":
					jt.setText(String.valueOf(firstNumber*secondNumber)); break;
				case "÷":
					jt.setText(String.valueOf(df.format(firstNumber/(double)secondNumber))); 
					break;
				
				}
				break;
			case "sqr": 
				secondNumber = Integer.parseInt(jt.getText());
				if(secondNumber==0) return;
				double d = Math.sqrt(secondNumber);
				jt.setText(String.valueOf(df.format(d))); break;
				
				
				
			case "1/x": 
				firstNumber = Integer.parseInt(jt.getText());
				if(firstNumber==0) return;
				double d1 =1.0/firstNumber;
				jt.setText(String.valueOf(df.format(d1))); break;
				
			case "X*X" :
				firstNumber = Integer.parseInt(jt.getText());
				jt.setText(String.valueOf(firstNumber*firstNumber)); break;
		}
	}
}
public class Swing13 {

	public static void main(String[] args) {
		new Calculator();
	}

}
