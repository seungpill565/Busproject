package park.label;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class RvInfoRowsLabel extends JLabel {
	public RvInfoRowsLabel(String title) {
		super(title);
		setFont(new Font("휴먼 편지체",Font.BOLD,16));
		setPreferredSize(new Dimension(70,30));
		setOpaque(true);
		setForeground(Color.black);
		setBackground(new Color(0x99CCFF));
	}

}
