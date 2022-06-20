package an.admin;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class User_NamePanel extends JPanel{
	JTextField nametext = new Admin_textFeild(10);
	JLabel nameLabel = new Admin_userLabel("¿Ã∏ß :");
	public User_NamePanel(JTextField text) {
		this.nametext = text;
		setLayout(new FlowLayout());
		add(nameLabel);add(nametext);
	}

}
