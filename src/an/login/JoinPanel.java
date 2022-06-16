package an.login;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JoinPanel extends JPanel{
	
	JButton join = new Lg_Button("회원가입");
	public JoinPanel(JButton join) {
		this.join = join;
		new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(join);
	}

}
