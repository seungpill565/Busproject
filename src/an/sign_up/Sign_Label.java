package an.sign_up;

import java.awt.Font;

import javax.swing.JLabel;

public class Sign_Label extends JLabel{
	
	public Sign_Label(String str) {
		super(str);
		setFont(new Font("휴먼편지체", Font.BOLD, 16));
	}

}
