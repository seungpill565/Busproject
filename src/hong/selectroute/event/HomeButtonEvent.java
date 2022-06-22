package hong.selectroute.event;

import java.awt.event.ActionEvent;

import hong.selectroute.SelectRouteMainFrame;

public class HomeButtonEvent extends RouteMainFrameAction {
	
	public HomeButtonEvent(SelectRouteMainFrame main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.exit(0);
	}

}
