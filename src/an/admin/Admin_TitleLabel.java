package an.admin;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Admin_TitleLabel extends JLabel{
	
	public Admin_TitleLabel(String str) {
		super(str);
		setForeground(new Color(0XFFFFFF));
		setFont(new Font("휴먼편지체", Font.BOLD, 25));
	}

}
