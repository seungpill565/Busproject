package hong.selectroute.event;

import java.awt.event.ActionListener;

import hong.selectroute.SelectRouteMainFrame;

abstract public class RouteMainFrameAction implements ActionListener {
	
	SelectRouteMainFrame main;
	
	public RouteMainFrameAction(SelectRouteMainFrame main) {
		this.main = main;
	}

}
