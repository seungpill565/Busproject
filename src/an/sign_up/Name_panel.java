package an.sign_up;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Name_panel extends JPanel{
	
	JLabel name = new Sign_Label("¿Ã∏ß :");
	JTextField nametext;
	
public Name_panel(JTextField nametex) {
	
	this.nametext = nametex;
	setLayout(new FlowLayout(FlowLayout.RIGHT));
	add(name);add(nametext);
	
}

}
