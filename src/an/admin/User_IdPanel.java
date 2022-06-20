package an.admin;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class User_IdPanel extends JPanel{
	JTextField idtext = new Admin_textFeild(10);
	JLabel idLabel = new Admin_userLabel("¾ÆÀÌµð :");
	public User_IdPanel(JTextField idtext) {
		this.idtext = idtext;
		setLayout(new FlowLayout());
		add(idLabel);add(idtext);
	}

}
