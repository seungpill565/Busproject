package an.login;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Login_buttonPanel extends JPanel{
	JButton login = new Lg_Button("로그인");
	JButton up = new Lg_Button("회원가입");
	JButton join = new Lg_Button("아이디/비밀번호 찾기");
	
	public Login_buttonPanel(JButton j, JButton j2, JButton j3) {
		login = j;up=j2;join=j3;
		
		setLayout(new GridLayout(1,3));
		
		add(login);add(up);add(join);
	}
	

}
