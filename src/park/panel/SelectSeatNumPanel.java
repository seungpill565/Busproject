package park.panel;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import park.ReservationInfo;
import park.combobox.SelectSeatNumBox;

public class SelectSeatNumPanel extends JPanel {

	public SelectSeatNumPanel(ReservationInfo test) {
		LayoutManager manager = new FlowLayout(FlowLayout.LEFT);
		
		for(int i=0;i<test.seatName.size();i++) {// 좌석수만큼 콤보박스를 생성한다
			add(new SelectSeatNumBox(test,i));
			
		}
		setLayout(manager);
		setBounds(10,100,450,250);
		
	}
}
