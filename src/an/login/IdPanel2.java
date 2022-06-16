package an.login;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class IdPanel2 extends JPanel{
	JTextField itext = new IdPwd_TextFeild(10);
	
	public IdPanel2(JTextField itext) {
		new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(itext);
		
	}

}
