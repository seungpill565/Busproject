package hong.selectroute;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;

public class MonthComboBox extends JComboBox<Integer> {
	
	final private static int JAN = 1;
	final private static int DEC = 12;
	final private static Color BACK_COLOR = Color.WHITE;
	private Dimension dimension = new Dimension(150,30);
	
	public MonthComboBox() {
		setBackground(BACK_COLOR);
		setPreferredSize(dimension);
		
		addItem(null);
		for (int i = JAN; i <= DEC; ++i) {
			addItem(i);
		}
	}
	
}
