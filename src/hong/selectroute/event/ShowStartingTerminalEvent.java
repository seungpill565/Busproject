package hong.selectroute.event;

import java.awt.event.ActionEvent;

import hong.selectroute.SelectRouteMainFrame;

public class ShowStartingTerminalEvent extends RouteMainFrameAction {
	
	public ShowStartingTerminalEvent(SelectRouteMainFrame main) {
		super(main);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.showStartingTerminals();
	}
}
