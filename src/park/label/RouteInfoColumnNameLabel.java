package park.label;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class RouteInfoColumnNameLabel extends JLabel{
	
	public RouteInfoColumnNameLabel(String title) {
		super(title);
		
		setFont(new Font("πŸ≈¡√º",Font.BOLD,20));
		setPreferredSize(new Dimension(92,30));
		setOpaque(true);
		setForeground(Color.white);
		setBackground(Color.black);
		
	}
}
