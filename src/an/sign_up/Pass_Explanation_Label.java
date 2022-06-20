package an.sign_up;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Pass_Explanation_Label extends JLabel{
	
	public Pass_Explanation_Label(String str) {
		super(str);
		setForeground(new Color(0Xcc0000));
		setFont(new Font("휴먼편지체", Font.BOLD, 17));
	}

}
