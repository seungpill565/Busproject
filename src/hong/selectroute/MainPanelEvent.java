package hong.selectroute;

import java.awt.event.ActionListener;

import hong.MainPanel;

abstract public class MainPanelEvent implements ActionListener {
	
	MainPanel mainPanel;
	
	public MainPanelEvent(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

}
