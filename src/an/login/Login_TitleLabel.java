package an.login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Login_TitleLabel extends JLabel{

	public Login_TitleLabel(String str) {
		super(str);
		setForeground(new Color(0XFFFFFF));
		setFont(new Font("휴먼편지체", Font.BOLD, 25));
		
	}
	
}
