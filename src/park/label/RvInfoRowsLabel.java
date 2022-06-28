package park.label;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class RvInfoRowsLabel extends JLabel {
	public RvInfoRowsLabel(String title) {
		super(title);
		setFont(new Font("πŸ≈¡√º",Font.BOLD,16));
		setPreferredSize(new Dimension(70,30));
		setOpaque(true);
		setForeground(Color.white);
		setBackground(Color.blue);
	}

}
