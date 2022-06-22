package an.login;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PwdPanel2 extends JPanel{
	
	JTextField ptext = new JPasswordField(10);
	public PwdPanel2(JPasswordField ptext) {
		this.ptext = ptext;
		new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		add(ptext);
		
	}

}
