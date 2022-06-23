package lee.mpcomponents;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

import hong.SaveInfo;

public class MPcontentsPanel extends JPanel {
	
	SaveInfo saveInfo;
	
	MPprofilePanel MPprofile;
	MPleavePanel MPleave = new MPleavePanel();
	MPreservationPanel MPreservation;
	
	//카드레이아웃
	CardLayout MPcontentsCard = new CardLayout();
	
	public MPcontentsPanel(SaveInfo saveInfo) {
		this.saveInfo = saveInfo;
	
		MPprofile = new MPprofilePanel(saveInfo);
		MPreservation = new MPreservationPanel(saveInfo);
		
		setLayout(MPcontentsCard);	
		
		add("내정보", MPprofile);
		add("예매내역", MPreservation);
		add("계정탈퇴", MPleave);
		
		setBounds(230, 110, 510, 460);
		setVisible(true);
	}
}
