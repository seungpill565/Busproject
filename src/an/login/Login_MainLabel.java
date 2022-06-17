package an.login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Login_MainLabel extends JLabel{

	public Login_MainLabel(String str) {
		super(str);
		setForeground(new Color(5, 0, 153));
		setFont(new Font("휴먼편지체", Font.BOLD, 25));
		
	}
	
}
