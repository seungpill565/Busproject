package an.sign_up;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Main_Label extends JLabel{
	
public Main_Label(String str) {
	super(str);
	setForeground(new Color(5, 0, 153));
	setFont(new Font("휴먼편지체", Font.BOLD, 25));
}
}
