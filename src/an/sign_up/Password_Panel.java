package an.sign_up;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Password_Panel extends JPanel{
	
	JLabel password = new Sign_Label("비밀번호 :");
	JTextField passtext;
	JButton checkpass = new Action_button("비밀번호 확인");
	
public Password_Panel(JTextField passtext,JButton checkpass) {
	this.checkpass = checkpass;
	this.passtext = passtext;
	setLayout(new FlowLayout(FlowLayout.LEFT));
	add(password);add(passtext);add(checkpass);
	
}

}
