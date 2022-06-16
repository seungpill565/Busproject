package an.sign_up;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Radio_Panel extends JPanel{
	JRadioButton client  ;
	JRadioButton manager ;
	ButtonGroup bg;
	public Radio_Panel(JRadioButton client, JRadioButton manager,ButtonGroup bg) {
		this.client = client;
		this.manager = manager;
		this.bg = bg;
		bg.add(client); bg.add(manager);

		add(manager); add(client);	
	}

}
