package hong.selectroute.event;

import java.awt.event.ActionEvent;

import hong.selectroute.SelectRouteMainPanel;

public class HomeButtonEvent extends RouteMainPanelAction {
	
	public HomeButtonEvent(SelectRouteMainPanel main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.exit(0);
	}

}
