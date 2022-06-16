package hong;

import java.awt.Color;

import javax.swing.JComboBox;

public class DayComboBox extends JComboBox<Integer> {
	
	final private static int FIRST_DAY = 1;
	final private static int LAST_DAY = 31;
	
	public DayComboBox() {
		setBackground(Color.WHITE);
		addItem(null);
		
		for(int i = FIRST_DAY; i <= LAST_DAY; ++i) {
			addItem(i);
		}
	}

}
