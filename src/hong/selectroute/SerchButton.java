package hong.selectroute;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class SerchButton extends JButton {
	
	private Dimension dimension = new Dimension(560,50);
	
	public SerchButton() {
		super("Á¶È¸ÇÏ±â");
		setBackground(new Color(0xFFE5CC));
		setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 18));
		setPreferredSize(dimension);
	}
}
