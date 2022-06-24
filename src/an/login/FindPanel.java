package an.login;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FindPanel extends JPanel{
	JButton find = new Lg_Button("아이디/비밀번호 찾기");
	
	public FindPanel() {
		new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(find);
	}

}
