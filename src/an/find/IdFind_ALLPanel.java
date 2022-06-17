package an.find;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IdFind_ALLPanel extends JPanel{
	JTextField nameText = new Find_TextField(10);
	JTextField pnText = new Find_TextField(10);
	
	
	
	public IdFind_ALLPanel(JTextField j, JTextField j2) {
		setLayout(new FlowLayout());
		nameText = j;
		pnText = j2;
		
		JPanel name = new IdFind_NamePanel(nameText);
		JPanel pn = new IdFind_PnPanel(pnText);
		
		add(name);add(pn);
		
		
		
	}

}
