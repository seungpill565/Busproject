package hong.selectroute.event;

import java.awt.event.ActionEvent;

import hong.selectroute.SelectRouteMainPanel;

public class SelectStartingButtonEvent extends RouteMainPanelAction {
	
	public SelectStartingButtonEvent(SelectRouteMainPanel main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.flameClose();
		main.departFrom(e.getActionCommand());
	}

}
