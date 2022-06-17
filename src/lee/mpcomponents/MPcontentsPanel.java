package lee.mpcomponents;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class MPcontentsPanel extends JPanel {
	
	
	MPprofilePanel MPprofile = new MPprofilePanel();
	MPleavePanel MPleave = new MPleavePanel();
	MPreservationPanel MPreservation = new MPreservationPanel();
	
	
	public MPcontentsPanel() {

		
		CardLayout MPcontentsCard = new CardLayout();
		setLayout(MPcontentsCard);	
		
		
		
		add(MPprofile);
		add(MPreservation);
		add(MPleave);
		
		setBounds(270, 110, 580, 460);
		setVisible(true);
	}
}
