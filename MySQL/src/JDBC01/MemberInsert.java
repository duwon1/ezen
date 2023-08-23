package JDBC01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class InsertForm extends JFrame implements ActionListener{

	JTextField name;
	JTextField phone;
	JTextField birthday;
	JTextField gender;
	
	InsertForm(){
		Font f = new Font("굴림", Font.BOLD, 20);
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp1.setLayout( new GridLayout(4,1) );
		jp2.setLayout( new GridLayout(4,1) );		
		JLabel lb1 = new JLabel("  성        명   : ");
		JLabel lb2 = new JLabel("  전 화 번 호  : ");
		JLabel lb3 = new JLabel("  생 년 월 일  : ");
		JLabel lb4 = new JLabel("  성        별  : ");
		JButton title = new JButton("★★★ 회 원  추 가 ★★★");		
		lb1.setFont(f);		lb2.setFont(f);		lb3.setFont(f);		lb4.setFont(f);	title.setFont(f);
		jp1.add(lb1);			jp1.add(lb2);			jp1.add(lb3);			jp1.add(lb4);	
		con.add( jp1, BorderLayout.WEST );		
		name = new JTextField();	phone = new JTextField();		birthday = new JTextField();
		gender = new JTextField();		
		name.setFont(f); 	phone.setFont(f);  birthday.setFont(f); 	gender.setFont(f);
		jp2.add(name);		jp2.add(phone);		jp2.add(birthday);		jp2.add(gender);
		con.add(jp2, BorderLayout.CENTER);
		
		JButton jb = new JButton("추가"); 			jb.setFont(f);
		con.add( jb, BorderLayout.SOUTH);		
		con.add( title, BorderLayout.NORTH);
		jb.addActionListener(this);
		setTitle("레코드 추가");		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		setVisible(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MemberDto mdto = new MemberDto();
		mdto.setName( name.getText());
		mdto.setPhone( phone.getText());
		mdto.setBirthday( birthday.getText());
		mdto.setGender( gender.getText());
		
		
		// 나이 계산
		Calendar today = Calendar.getInstance();
		int todayYear = today.get( Calendar.YEAR );
		int birthYear = Integer.parseInt(birthday.getText().substring(0,4));
		mdto.setAge(todayYear - birthYear); 
		
		MemberDao mdao = MemberDao.getInstance();
		int result = mdao.insertMember( mdto );		
		if( result==1 ) {
			JOptionPane.showMessageDialog(null, "레코드 추가 성공");
			name.setText("");  phone.setText("");  birthday.setText(""); gender.setText("");
		}else { 
			JOptionPane.showMessageDialog(null, "레코드 추가 실패");
		}
	}	
}
public class MemberInsert {

	public static void main(String[] args) {
		new InsertForm();
	}

}
