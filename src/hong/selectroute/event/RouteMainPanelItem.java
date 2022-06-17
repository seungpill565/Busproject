package hong.selectroute.event;

import java.awt.event.ItemListener;

import hong.selectroute.SelectRouteMainPanel;

abstract public class RouteMainPanelItem implements ItemListener {
	
	SelectRouteMainPanel main;
	
	public RouteMainPanelItem(SelectRouteMainPanel main) {
		this.main = main;
	}
}
