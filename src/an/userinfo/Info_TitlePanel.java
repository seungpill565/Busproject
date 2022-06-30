package an.userinfo;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import an.admin.Admin_TitleLabel;

public class Info_TitlePanel extends JPanel{
	JLabel title = new Admin_TitleLabel("유저 모드");
	ImageIcon usertitleimage = new ImageIcon("image/usertitle.png");
	public Info_TitlePanel() {
		setBackground(new Color(0X182535));
		title.setText("");
		title.setIcon(usertitleimage);
		add(title);
	}

}
