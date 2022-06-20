package hong.selectroute.event;

import java.awt.event.ActionEvent;

import hong.selectroute.SelectRouteMainPanel;

public class SelectArriveButtonEvent extends RouteMainPanelAction {
	
	public SelectArriveButtonEvent(SelectRouteMainPanel main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.flameClose();
		main.arriveAt(e.getActionCommand());
	}

}
