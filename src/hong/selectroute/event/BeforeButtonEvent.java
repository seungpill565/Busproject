package hong.selectroute.event;

import java.awt.event.ActionEvent;

import an.userinfo.Info_MainFrame;
import hong.selectroute.SelectRouteMainFrame;

public class BeforeButtonEvent extends RouteMainFrameAction {
	
	public BeforeButtonEvent(SelectRouteMainFrame main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.thisFrameClose();
		main.before();
	}

}
