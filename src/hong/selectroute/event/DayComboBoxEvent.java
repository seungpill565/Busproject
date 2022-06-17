package hong.selectroute.event;

import java.awt.event.ItemEvent;

import hong.selectroute.SelectRouteMainPanel;

public class DayComboBoxEvent extends RouteMainPanelItem {
	
	public DayComboBoxEvent(SelectRouteMainPanel main) {
		super(main);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		// 콤보박스가 선택되면 true
		if(e.getStateChange() == 1) {
			int day = (int)e.getItem();
			main.inputDay(day);
		}
		
	}
}
