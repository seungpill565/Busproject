package an.sign_up;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class ErrorLabel extends JLabel{
	
	public ErrorLabel(String str) {
		super(str);
		setForeground(Color.black);
		setForeground(new Color(0XFFFFFF));
		setFont(new Font("휴먼편지체", Font.BOLD, 15));
	}

}
