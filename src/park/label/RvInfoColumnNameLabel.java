package park.label;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class RvInfoColumnNameLabel extends JLabel{

	public RvInfoColumnNameLabel(String title) {
	
		super(title);
		
		setFont(new Font("휴먼 편지체",Font.BOLD,16));
		setPreferredSize(new Dimension(77,30));
		setOpaque(true);
		setForeground(Color.white);
		setBackground(Color.black);
	}
}
