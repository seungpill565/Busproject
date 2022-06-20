package an.login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class IdPwd_Label extends JLabel{
	
	public IdPwd_Label(String str) {
		super(str);
		setForeground(new Color(0XFFFFFF));
		setFont(new Font("휴먼편지체", Font.BOLD, 13));
		
		setHorizontalAlignment(SwingConstants.CENTER);
	}

}
