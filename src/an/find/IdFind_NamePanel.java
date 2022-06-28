package an.find;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IdFind_NamePanel extends JPanel{
	
	JLabel nameLabel = new Find_Label("¿Ã∏ß :     ");
	JTextField nameText = new Find_TextField(10);
	
	
	public IdFind_NamePanel(JTextField j) {
		nameText = j;
		
		setLayout(new FlowLayout(FlowLayout.LEADING));
		
		add(nameLabel); add(nameText);
	}

}
