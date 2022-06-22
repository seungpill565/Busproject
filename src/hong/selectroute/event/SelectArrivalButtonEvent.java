package hong.selectroute.event;

import java.awt.event.ActionEvent;

import hong.selectroute.SelectRouteMainFrame;

public class SelectArrivalButtonEvent extends RouteMainFrameAction {
	
	public SelectArrivalButtonEvent(SelectRouteMainFrame main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.stmFlameClose();
		
		String command = e.getActionCommand();
		main.arriveAt(command);
		main.setArrivalPoint(command);
	}

}
