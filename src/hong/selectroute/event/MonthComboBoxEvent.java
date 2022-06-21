package hong.selectroute.event;

import java.awt.event.ItemEvent;

import hong.selectroute.SelectRouteMainFrame;

public class MonthComboBoxEvent extends RouteMainFrameItem {
	
	// 월을 선택할 수 있는 콤보박스
			
	public MonthComboBoxEvent(SelectRouteMainFrame main) {
		super(main);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// 선택 되면 true
		if(e.getStateChange() == 1) {
			int month = (int)e.getItem();
			
			// main에 있는 addDays 메서드에 선택된 값을 int로 전달
			main.addDays(month);
			main.setMonth(month);
		} else {
			// 월마다 일이 계속 추가되므로 main에 있는 메서드로 계속 제거도 해줘야한다.
			main.resetDays();
		}
		
	}
	
}
