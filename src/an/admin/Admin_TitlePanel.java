package an.admin;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Admin_TitlePanel extends JPanel{
	JLabel title = new Admin_TitleLabel("관리자 모드");
	public Admin_TitlePanel() {
		setBackground(new Color(0X864D65));
		add(title);
	}

}
