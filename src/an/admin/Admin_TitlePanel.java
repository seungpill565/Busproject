package an.admin;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Admin_TitlePanel extends JPanel{
	JLabel title = new Admin_TitleLabel("관리자 모드");
	ImageIcon admintitleimage = new ImageIcon("image/admintitle.png");
	public Admin_TitlePanel() {
		setBackground(new Color(0X864D65));
		title.setText("");
		title.setIcon(admintitleimage);
		add(title);
	}

}
