package hong.selectroute.event;

import java.awt.event.ActionEvent;

import hong.selectroute.SelectRouteMainPanel;
import hong.selectroute.SelectTerminalMainFrame;

public class ShowArriveTerminalEvent extends RouteMainPanelAction {
	
	public ShowArriveTerminalEvent(SelectRouteMainPanel main) {
		super(main);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.showArriveTerminals();
	}
}
