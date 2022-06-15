package hong;

import java.awt.Color;

import javax.swing.JLabel;

public class BackGroundLabel extends JLabel {
	
	final private Color backGroundColor = Color.WHITE;
	
	public BackGroundLabel() {
		setOpaque(true);
		setBackground(backGroundColor);
	}

}
