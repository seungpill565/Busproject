package an.login;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class PwdPanel2 extends JPanel{
	
	JTextField ptext = new IdPwd_TextFeild(10);
	public PwdPanel2(JTextField ptext) {
		new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		add(ptext);
		
	}

}
