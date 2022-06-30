package an.login;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PwdPanel extends JPanel{
	JLabel pwl = new IdPwd_Label("비밀번호 : ");
	ImageIcon image = new ImageIcon("image/pass.png");
	
	public PwdPanel() {
		new JPanel(new FlowLayout(FlowLayout.RIGHT));
		setBackground(new Color(0x77757B));
		pwl.setText("");
		pwl.setIcon(image);
		add(pwl);
	}

}
