package lee.mpcomponents;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class MPcontentsPanel extends JPanel {
	
	
	MPprofilePanel MPprofile = new MPprofilePanel();
	MPleavePanel MPleave = new MPleavePanel();
	MPreservationPanel MPreservation = new MPreservationPanel();
	
	//카드레이아웃
	CardLayout MPcontentsCard = new CardLayout();
	
	public MPcontentsPanel() {

		
		setLayout(MPcontentsCard);	
		
		add("내정보", MPprofile);
		add("예매내역", MPreservation);
		add("계정탈퇴", MPleave);
		
		setBounds(230, 110, 510, 460);
		setVisible(true);
	}
}
