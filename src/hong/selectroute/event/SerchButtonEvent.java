package hong.selectroute.event;

import java.awt.event.ActionEvent;

import hong.selectroute.SelectRouteMainFrame;

public class SerchButtonEvent extends RouteMainFrameAction {
	
	// 경로, 날짜에 맞는 버스를 조회할 수 있는 버튼 이벤트
	
	public SerchButtonEvent(SelectRouteMainFrame main) {
		super(main);
	}
	
	@Override
	// 출발지, 도착지, 날짜를 입력해야 한다 안하면 경고메세지 뜨도록.
	public void actionPerformed(ActionEvent e) {
		if(main.checkRoute() && main.checkDate()) {
			
			if(main.checkMonth()) {
				main.getRouteID();
				main.showBus();
				main.getprice();			
				
			}
		}
	}

}
