package lee.mpcomponents;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MPreservationPanel extends JPanel {
	
	CardLayout MPreservationCard = new CardLayout();

	MPreservationPanel_1 MPreservation_1 = new MPreservationPanel_1();		
	MPreservationPanel_2 MPreservation_2 = new MPreservationPanel_2();
	
	public MPreservationPanel() {
		
		setLayout(MPreservationCard);

				
		//add(MPreservation_1);
		add(MPreservation_2);
	}
}
