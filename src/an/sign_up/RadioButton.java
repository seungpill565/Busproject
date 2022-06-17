package an.sign_up;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class RadioButton extends JComboBox<String>{
	
	public RadioButton(String str,String s) {
		addItem(str);
		addItem(s);
	}

}
