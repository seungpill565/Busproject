package park.label;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class RouteInfoRowsLabel extends JLabel{

	public RouteInfoRowsLabel(String title) {
		super(title);
		setFont(new Font("πŸ≈¡√º",Font.BOLD,16));
		setPreferredSize(new Dimension(85,30));
		setOpaque(true);
		setForeground(Color.white);
		setBackground(Color.blue);
		
	}
	
}
