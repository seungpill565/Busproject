package hong.selectroute;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class ColumnNameLabel extends JLabel {
	
	private LineBorder lineBorder = new LineBorder(Color.BLACK);
	private Dimension dimension = new Dimension(105,30);
	
	public ColumnNameLabel(String date) {
		super(date);
		setOpaque(true);
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setHorizontalAlignment(CENTER);
		setBorder(lineBorder);
		setFont(new Font("±¼¸²Ã¼", Font.BOLD, 15));
		setPreferredSize(dimension);
	}
}
