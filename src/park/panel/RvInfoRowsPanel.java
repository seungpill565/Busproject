package park.panel;

import javax.swing.JPanel;

import hong.SaveInfo;
import park.label.RvInfoRowsLabel;

public class RvInfoRowsPanel extends JPanel{
	public RvInfoRowsPanel(SaveInfo user) {
		for(int i=0;i<user.getSeatSize();i++) {
			add(new RvInfoRowsLabel(user.getReservationId().get(i).toString()));
			add(new RvInfoRowsLabel(user.getDate()));
			add(new RvInfoRowsLabel(user.getTime()));
			add(new RvInfoRowsLabel(user.getDepart()));
			add(new RvInfoRowsLabel(user.getArrive()));
			add(new RvInfoRowsLabel(String.format("%s",(Integer.parseInt(user.getSeatNames().get(i))+1 )))); // ÁÂ¼®ÀÌ¸§
		}
	}
}
