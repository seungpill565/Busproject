package an.login;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class IdPanel extends JPanel{
	JLabel id = new IdPwd_Label("¾ÆÀÌµð : ");
	
	public IdPanel() {
		new JPanel(new FlowLayout(FlowLayout.RIGHT));
		add(id);
		
	}

}
