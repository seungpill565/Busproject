package an.find;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JLabel;

public class Find_Label extends JLabel{
	
	public Find_Label(String str) {
		
		
		super(str);
		setForeground(new Color(0XFFFFFF));
		setFont(new Font("휴먼편지체", Font.BOLD, 25));
	}

}
