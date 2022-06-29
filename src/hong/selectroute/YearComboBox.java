package hong.selectroute;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JComboBox;

public class YearComboBox extends JComboBox<Integer> {
	private static int thisYear = Calendar.getInstance(Locale.KOREA).get(Calendar.YEAR);
	final private static Color BACK_COLOR = Color.WHITE;
	private Dimension dimension = new Dimension(110,30);
	
	public YearComboBox() {
		setBackground(BACK_COLOR);
		setPreferredSize(dimension);
		
		addItem(null);
		addItem(thisYear);
		addItem(thisYear + 1);
	}
}
