package hong.selectbus;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;


public class SelectBusMainFrame extends JFrame {
	
	BackGroundLabel backGroundLabel = new BackGroundLabel();
	CenterPanel centerPanel = new CenterPanel();
	
	public SelectBusMainFrame() {
		
		setTitle("ø¨Ω¿¡ﬂ");
		
		add(centerPanel, "Center");
		add(backGroundLabel, "East");
		add(backGroundLabel, "West");
		add(backGroundLabel, "North");
		add(backGroundLabel, "South");
		
		setBounds(300, 100, 600, 700);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new SelectBusMainFrame();
	}
}
