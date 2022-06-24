package park.panel;

import javax.swing.JPanel;

import park.ReservationInfo;
import park.label.RouteInfoRowsLabel;

public class RouteInfoRowsPanel extends JPanel{ // 행선지 정보 행들 넣는 패널 

	public RouteInfoRowsPanel(ReservationInfo user) {
		for(int i=0;i<user.getSeatSize();i++) {
			add(new RouteInfoRowsLabel(user.getDate()));
			add(new RouteInfoRowsLabel(user.getTime()));
			add(new RouteInfoRowsLabel(user.getDepart()));
			add(new RouteInfoRowsLabel(user.getArrive()));
			//add(new RouteInfoRowsLabel(user.getSeatKeys().get(i))); // 좌석이름
		}
	}
	
}
