package lee.mpcomponents;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class MPprofilePanel extends JPanel {

	MPprofilePanel_1 MPpforile_1 = new MPprofilePanel_1();
	MPprofilePanel_2 MPpforile_2 = new MPprofilePanel_2();
	
	
	public MPprofilePanel() {
		CardLayout MPprofileCard = new CardLayout();
		setLayout(MPprofileCard);
		
		
		
		add(MPpforile_1);
		add(MPpforile_2);
		
	}
	
	
}
