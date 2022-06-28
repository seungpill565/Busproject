package an.sign_up;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class ErrorLabel extends JLabel{
	
	public ErrorLabel(String str) {
		super(str);
		setForeground(Color.red);
		setFont(new Font("휴먼편지체", Font.BOLD, 15));
	}

}
