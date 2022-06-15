package hong.selectbus;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class CenterPanel extends JPanel {
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	BackGroundLabel backGroundLabel = new BackGroundLabel();
	HomeButton homeButton = new HomeButton();
	
	final private Color backGroundColor = Color.WHITE;
	//final private double weightx = 1.0;
	//final private double weighty = 1.0;
	
	public CenterPanel() {
		
		
		setLayout(gbl);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;


	}
	
}
