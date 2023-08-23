package JDBC01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class UpdateForm extends JFrame implements ActionListener{

	JTextField membernum;
	JTextField name;
	JTextField phone;
	JTextField birthday;
	JTextField gender;
	JTextField joindate;
    JTextField bpoint;
	
	UpdateForm(){
		
        Font f = new Font("굴림", Font.BOLD, 20);		
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
		JPanel labelPanel = new JPanel();
		JPanel textFieldPanel = new JPanel();
		labelPanel.setLayout( new GridLayout(7,1) );
		textFieldPanel.setLayout( new GridLayout(7,1) );
		
		JLabel lb1 = new JLabel("  회 원 번 호  : ");
		JLabel lb2 = new JLabel("  회 원 성 명  : ");
		JLabel lb3 = new JLabel("  전 화 번 호  : ");
		JLabel lb4 = new JLabel("  생 년 월 일  : ");
		JLabel lb5 = new JLabel("  성       별  : ");
		JLabel lb6 = new JLabel("  가   입  일  : ");
		JLabel lb7 = new JLabel("  포   인  트  : ");
		
		JButton title = new JButton("★★★ 회 원 정 보 수 정 ★★★");
		lb1.setFont(f);lb2.setFont(f);	lb3.setFont(f);	lb4.setFont(f); 
		lb5.setFont(f);	lb6.setFont(f);	lb7.setFont(f);	
		labelPanel.add(lb1); 	labelPanel.add(lb2); labelPanel.add(lb3);	
		labelPanel.add(lb4);   labelPanel.add(lb5);  labelPanel.add(lb6);  labelPanel.add(lb7);
		con.add( labelPanel, BorderLayout.WEST );
		
		membernum = new JTextField(10); name = new JTextField();	phone = new JTextField();	
		birthday= new JTextField();		gender = new JTextField();  joindate = new JTextField();
	    bpoint = new JTextField();
		
		membernum.setFont(f);	name.setFont(f);	phone .setFont(f);
		birthday.setFont(f);  	gender.setFont(f);  joindate.setFont(f); bpoint.setFont(f);
		
        // textFieldPanel 패널에 맨 첫 번째 그리드에 텍스트 필드(membernum)과 조회 버튼을 배치
		// grid 레이아웃 한 칸의 두 개의 개체를 올리려면 다른 패널에 넣어서 올림.
		JPanel mnumPanel = new JPanel();
		mnumPanel.setLayout( new FlowLayout( FlowLayout.LEFT ) );
		JButton search = new JButton("조회");
		mnumPanel.add(membernum);
		mnumPanel.add(search);
		textFieldPanel.add(mnumPanel);
		

		textFieldPanel.add(name);		textFieldPanel.add(phone);		textFieldPanel.add(birthday);		
		textFieldPanel.add(gender);     textFieldPanel.add(joindate);  textFieldPanel.add(bpoint);
		con.add(textFieldPanel, BorderLayout.CENTER);
				
		JButton jb = new JButton("수정");
		jb.setFont(f);
		con.add( jb, BorderLayout.SOUTH);				
		title.setFont(f);
		con.add( title, BorderLayout.NORTH);
		
		search.addActionListener(this);
        jb.addActionListener(this);
		
		setTitle("레코드 추가");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
		
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = new MemberDto();
		String s = e.getActionCommand();
		switch(s) {
		case "조회" :
			mdto = mdao.getMember( Integer.parseInt( membernum.getText() ));
			if( mdto == null) {
				System.out.println("해당 횐 번호의 횐님이 없읍니다");
				return;
			}else {
			   name.setText( mdto.getName());
               phone.setText( mdto.getPhone());
               birthday.setText( mdto.getBirthday());
               gender.setText( mdto.getGender());
               joindate.setText( mdto.getJoindate());
               bpoint.setText( mdto.getBpoint() + "");
			}
			break;
		case "수정" :			
			mdto.setMembernum( Integer.parseInt( membernum.getText() ) );
			mdto.setName( name.getText());
			mdto.setPhone( phone.getText());
			mdto.setBirthday( birthday.getText());
			mdto.setGender( gender.getText());
			mdto.setJoindate( joindate.getText());			
			mdto.setBpoint(Integer.parseInt( bpoint.getText()));
			
			int result = mdao.updateMember( mdto );			
			if( result == 1) {
				JOptionPane.showMessageDialog(null, "레코드 수정 성공");
				membernum.setText("");  name.setText("");
				 phone.setText("");  birthday.setText(""); gender.setText("");
				 joindate.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "레코드 수정 실패");
			}
		}
		
			
			
			
			
			
			
	}

	

}

public class MemberUpdate {

	public static void main(String[] args) {
		new UpdateForm();
	}


	
}
