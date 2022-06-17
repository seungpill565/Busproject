package hong.selectroute;

import java.awt.Color;

import javax.swing.JComboBox;

public class MonthComboBox extends JComboBox<Integer> {
	
	final private static int JAN = 1;
	final private static int DEC = 12;
	final private static Color BACK_COLOR = Color.WHITE;
	
	private int month;
	
	public MonthComboBox() {
		setBackground(BACK_COLOR);
		
		addItem(null);
		for (int i = JAN; i <= DEC; ++i) {
			addItem(i);
		}
	}
	
	public void setMonth(int month) {
		this.month = month;
	}

}
