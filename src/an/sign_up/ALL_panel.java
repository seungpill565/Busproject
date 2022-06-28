package an.sign_up;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ALL_panel extends JPanel{
	JButton in = new Sign_Button("회원가입");
	//JButton check = new Sign_Button("아이디 중복확인");
	//JButton checkpass = new Sign_Button("비밀번호 확인");
	//JButton out = new Sign_Button("나가기");
	
	JPanel signPanel = new Sign_Panel(in); 
	//JPanel radioPanel = new Radio_Panel();
	
	public class new_panel extends JPanel{
		public new_panel() {
			setLayout(new FlowLayout());
			add(in);
		}
	}
	public ALL_panel() {
		setLayout(new BorderLayout());
		add(signPanel,BorderLayout.CENTER);//add(radioPanel);
		add(new new_panel(),BorderLayout.SOUTH);
		
	}
	
	

}
