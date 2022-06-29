package hong.selectroute.event;

import java.awt.event.ItemEvent;

import hong.selectroute.SelectRouteMainFrame;

public class YearComboBoxEvent extends RouteMainFrameItem {
	
	public YearComboBoxEvent(SelectRouteMainFrame main) {
		super(main);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(e.getStateChange() == 1) {
			main.setYear((int)e.getItem());
		}
		
	}

}
