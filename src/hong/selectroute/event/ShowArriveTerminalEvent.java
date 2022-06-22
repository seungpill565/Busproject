package hong.selectroute.event;

import java.awt.event.ActionEvent;

import hong.selectroute.SelectRouteMainFrame;

public class ShowArriveTerminalEvent extends RouteMainFrameAction {
	
	public ShowArriveTerminalEvent(SelectRouteMainFrame main) {
		super(main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.showArriveTerminals();
	}
}
