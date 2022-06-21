package hong.selectroute.event;

import java.awt.event.ActionEvent;

import hong.selectroute.SelectRouteMainFrame;

public class SelectBusButtonEvent extends RouteMainFrameAction {
	
	public SelectBusButtonEvent(SelectRouteMainFrame main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.busFrameClose();
		// e.toString().indexOf("on ") + 3 하면 버스id 시작하는 index가 나옴
		// e.toStrig().substring으로 으로 위의 index값을 넣으면 버스id의 값이 String 으로 나옴
		main.setBusID(Integer.parseInt(e.toString().substring(e.toString().indexOf("on ") + 3)));
	}
}
