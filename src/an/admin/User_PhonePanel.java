package an.admin;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class User_PhonePanel extends JPanel{
	JTextField pntext = new Admin_textFeild(10);
	JLabel pnLabel = new Admin_userLabel("전화번호 :");
	public User_PhonePanel(JTextField text) {
		this.pntext = text;
		setLayout(new FlowLayout());
		add(pnLabel);add(pntext);
	}

}
