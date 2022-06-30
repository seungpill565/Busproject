package an.sign_up;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Combo_Panel extends JPanel{
	JLabel check = new Sign_Label("°ü¸®ÀÚ/¼Õ´Ô");
	JComboBox<String> combo = new Combo();
	public Combo_Panel(JComboBox<String> combo) {
		this.combo = combo;
		setLayout(new FlowLayout());
		setBackground(new Color(0X4D7F86));
		add(check);add(combo);
		
	}

}
