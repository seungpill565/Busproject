package hong.selectroute.event;

import java.awt.event.ActionListener;

import hong.selectroute.SelectRouteMainPanel;

abstract public class RouteMainPanelAction implements ActionListener {
	
	SelectRouteMainPanel main;
	
	public RouteMainPanelAction(SelectRouteMainPanel main) {
		this.main = main;
	}

}
