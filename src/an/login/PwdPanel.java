package an.login;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PwdPanel extends JPanel{
	JLabel pwl = new IdPwd_Label("비밀번호 : ");
	
	public PwdPanel() {
		new JPanel(new FlowLayout(FlowLayout.RIGHT));
		add(pwl);
	}

}
