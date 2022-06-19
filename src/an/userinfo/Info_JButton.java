package an.userinfo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class Info_JButton extends JButton{
	
	public Info_JButton(String str) {
		super(str);
		EmptyBorder b1 = new EmptyBorder(5,3,5,3);
		setBorder(b1);
		setFont(new Font("휴먼편지체", Font.BOLD, 25));
		setForeground(new Color(0X33FFFF));
		setBackground(new Color(0xFFFFFF));
	}

}
