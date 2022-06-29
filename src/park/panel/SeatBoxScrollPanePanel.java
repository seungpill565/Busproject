package park.panel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import hong.SaveInfo;
import park.combobox.SelectSeatAgeBox;

public class SeatBoxScrollPanePanel extends JPanel {

	SelectSeatAgePanel panel;
	public SeatBoxScrollPanePanel(SaveInfo user) {
		LayoutManager manager = new FlowLayout(FlowLayout.CENTER,5,3);
		setLayout(manager);
		
		for(int i=0;i<user.getSeatSize();i++) {// 좌석수만큼 콤보박스를 생성한다
			add(new SelectSeatAgeBox(user,i));
		}
	
//		setPreferredSize(new Dimension(450,30));
//		if(user.getSeatSize()>5)
//			setPreferredSize(new Dimension(450,60));
//		else if(user.getSeatSize()>10)
//			setPreferredSize(new Dimension(450,90));
//		else if(user.getSeatSize()>15)
//			setPreferredSize(new Dimension(450,120));
//		
	//	setBounds(10,350,450,70);
	}
	
}
