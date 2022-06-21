package hong.selectroute.event;

import java.awt.event.ActionEvent;

import hong.selectroute.SelectRouteMainFrame;

public class SerchButtonEvent extends RouteMainFrameAction {
	
	// 경로, 날짜에 맞는 버스를 조회할 수 있는 버튼 이벤트
	
	public SerchButtonEvent(SelectRouteMainFrame main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.getRouteID();
		main.showBus();
	}

}
