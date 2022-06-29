package an.login;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Login_TitlePanal extends JPanel{

	JLabel login = new Login_TitleLabel("버스 예약 로그인");
	ImageIcon titleimage = new ImageIcon("image/logintitle.png");
	public Login_TitlePanal() {
		setBackground(new Color(0X4D7F86));
		login.setText("");
		login.setIcon(titleimage);
		add(login);
	}
}
