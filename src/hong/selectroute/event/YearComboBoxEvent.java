package hong.selectroute.event;

import java.awt.event.ItemEvent;

import hong.selectroute.SelectRouteMainFrame;

public class YearComboBoxEvent extends RouteMainFrameItem {
	
	public YearComboBoxEvent(SelectRouteMainFrame main) {
		super(main);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		int year;
		
		if(e.getStateChange() == 1) {
			year = (int)e.getItem();
		} else {
			year = 0;
		}
		
		main.setYear(year);
	}

}
