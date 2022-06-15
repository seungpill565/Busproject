package hong;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class SelectBusMainFrame extends JFrame {
	
	BackGroundLabel backGroundLabel = new BackGroundLabel();
	CenterPanel centerPanel = new CenterPanel();
	
	public SelectBusMainFrame() {
		
		setTitle("ø¨Ω¿¡ﬂ");
		
		add(centerPanel);
		
		setBounds(300, 100, 600, 700);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new SelectBusMainFrame();
	}
}
