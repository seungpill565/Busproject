package an.login;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class pwdPanel2 extends JPanel{
	
	JTextField ptext = new IdPwd_TextFeild(10);
	public pwdPanel2(JTextField ptext) {
		new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		add(ptext);
		
	}

}
