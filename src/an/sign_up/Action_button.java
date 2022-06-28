package an.sign_up;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class Action_button extends JButton{
	
	public Action_button(String str) {
		super(str);
		EmptyBorder b1 = new EmptyBorder(5,3,5,3);
		setBorder(b1);
		setBackground(new Color(0XFFFFFFF));
		setFont(new Font("휴먼편지체", Font.BOLD, 15));
	}

}
