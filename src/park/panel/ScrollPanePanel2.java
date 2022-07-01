package park.panel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import hong.SaveInfo;
import park.label.RvInfoRowsLabel;

public class ScrollPanePanel2 extends JPanel{

	public ScrollPanePanel2(SaveInfo user) {
		LayoutManager manager = new FlowLayout(FlowLayout.LEFT);
		setLayout(manager);
		for(int i=0;i<user.getSeatSize();i++) {
			add(new RvInfoRowsLabel(user.getReservationId().get(i).toString()));
			add(new RvInfoRowsLabel(user.getDate()));
			add(new RvInfoRowsLabel(user.getTime()));
			add(new RvInfoRowsLabel(user.getDepart()));
			add(new RvInfoRowsLabel(user.getArrive()));
			add(new RvInfoRowsLabel(String.format("%s",(Integer.parseInt(user.getSeatNames().get(i))+1 )))); // ÁÂ¼®ÀÌ¸§
		}
		
		setBackground(Color.white);
	}
}
