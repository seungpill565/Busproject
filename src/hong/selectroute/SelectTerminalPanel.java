package hong.selectroute;

import java.awt.GridLayout;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectTerminalPanel extends JPanel {
	
	HashSet<String> terminals = new HashSet<>();
	
	public SelectTerminalPanel() {
		
		setLayout(new GridLayout(3, 4, 10, 10));
		
	}
}
