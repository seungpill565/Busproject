package an.login;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mainpenal extends JPanel{

	JLabel login = new Login_MainLabel("버스 예약 로그인");
	public Mainpenal() {
		setBackground(new Color(0X4D7F86));
		add(login);
	}
}
