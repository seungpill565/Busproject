package hong.selectroute.event;

import java.awt.event.ActionEvent;

import hong.selectroute.SelectRouteMainFrame;

public class NextButtonEvent extends RouteMainFrameAction {
	
	public NextButtonEvent(SelectRouteMainFrame main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.thisFrameClose();
		main.save();
		main.showSeatFrame();
	}

}
