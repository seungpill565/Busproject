package an.login;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class findPanel extends JPanel{
	JButton find = new Lg_Button("아이디/비밀번호 찾기");
	
	public findPanel() {
		new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(find);
	}

}
