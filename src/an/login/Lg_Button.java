package an.login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class Lg_Button extends JButton{
	
	public Lg_Button(String str) {
		super(str);
		setForeground(new Color(0XFFFFFF));
		setBackground(new Color(0x77757B));
		setFont(new Font("휴먼편지체", Font.BOLD, 13));
		
	}

}
