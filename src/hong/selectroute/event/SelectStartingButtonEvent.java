package hong.selectroute.event;

import java.awt.event.ActionEvent;

import hong.selectroute.SelectRouteMainFrame;

public class SelectStartingButtonEvent extends RouteMainFrameAction {
	
	public SelectStartingButtonEvent(SelectRouteMainFrame main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.stmFlameClose();
		
		String command = e.getActionCommand();
		main.departFrom(command);
		main.setStartingPoint(command);
	}

}
