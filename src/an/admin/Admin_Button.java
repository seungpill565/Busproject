package an.admin;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class Admin_Button extends JButton{
	
	public Admin_Button(String str) {
		super(str);
		EmptyBorder b1 = new EmptyBorder(5,3,5,3);
		setBorder(b1);
		setFont(new Font("휴먼편지체", Font.BOLD, 25));
		setForeground(new Color(0XFFFFFF));
		setBackground(new Color(0x77757B));
	}

}
