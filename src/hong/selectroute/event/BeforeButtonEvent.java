package hong.selectroute.event;

import java.awt.event.ActionEvent;

import hong.selectroute.SelectRouteMainFrame;

public class BeforeButtonEvent extends RouteMainFrameAction {
	
	public BeforeButtonEvent(SelectRouteMainFrame main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.thisFrameClose();
	}

}
