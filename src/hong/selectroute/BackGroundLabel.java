package hong.selectroute;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class BackGroundLabel extends JLabel {
	
	final private static Color BACK_COLOR = Color.WHITE;
	
	public BackGroundLabel() {
		setOpaque(true);
		setBackground(BACK_COLOR);
		setHorizontalAlignment(CENTER);
		setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 13));
	}
	
	public void leftSort() {
		setHorizontalAlignment(LEFT);
	}
}
