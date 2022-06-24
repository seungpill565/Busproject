package park.panel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import hong.SaveInfo;
import park.combobox.SelectSeatAgeBox;

public class SelectSeatAgePanel extends JPanel {

	public SelectSeatAgePanel(SaveInfo user) {
		LayoutManager manager = new FlowLayout(FlowLayout.CENTER,5,3);
		
		for(int i=0;i<user.getSeatSize();i++) {// 좌석수만큼 콤보박스를 생성한다
			add(new SelectSeatAgeBox(user,i));
		}
		setLayout(manager);
		setBackground(Color.white);
		setBounds(10,300,450,100);
	}
}
