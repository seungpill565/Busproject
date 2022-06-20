package an.admin;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class User_PassPanel extends JPanel{
	JTextField passtext = new Admin_textFeild(10);
	JLabel passLabel = new Admin_userLabel("비밀번호 :");
	public User_PassPanel(JTextField text) {
		this.passtext = text;
		setLayout(new FlowLayout());
		add(passLabel);add(passtext);
	}

}
