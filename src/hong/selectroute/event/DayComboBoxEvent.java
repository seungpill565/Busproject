package hong.selectroute.event;

import java.awt.event.ItemEvent;

import hong.selectroute.SelectRouteMainFrame;

public class DayComboBoxEvent extends RouteMainFrameItem {
	
	// 날짜를 선택할 수 있는 콤보박스
	
	public DayComboBoxEvent(SelectRouteMainFrame main) {
		super(main);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		// 콤보박스가 선택되면 true
		if(e.getStateChange() == 1) {
			main.setDay((int)e.getItem());
		}
		
	}
}
