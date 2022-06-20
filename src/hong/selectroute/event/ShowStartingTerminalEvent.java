package hong.selectroute.event;

import java.awt.event.ActionEvent;

import hong.selectroute.SelectRouteMainPanel;
import hong.selectroute.SelectTerminalMainFrame;

public class ShowStartingTerminalEvent extends RouteMainPanelAction {
	
	public ShowStartingTerminalEvent(SelectRouteMainPanel main) {
		super(main);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.showStartingTerminals();
	}
}
