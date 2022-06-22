package hong.selectroute.event;

import java.awt.event.ItemListener;

import hong.selectroute.SelectRouteMainFrame;

abstract public class RouteMainFrameItem implements ItemListener {
	
	SelectRouteMainFrame main;
	
	public RouteMainFrameItem(SelectRouteMainFrame main) {
		this.main = main;
	}
}
