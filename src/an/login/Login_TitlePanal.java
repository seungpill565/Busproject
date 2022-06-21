package an.login;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Login_TitlePanal extends JPanel{

	JLabel login = new Login_TitleLabel("버스 예약 로그인");
	public Login_TitlePanal() {
		setBackground(new Color(0X4D7F86));
		add(login);
	}
}
