package hong.selectroute.event;

import java.awt.event.ActionListener;

import hong.selectroute.SelectTerminalMainFrame;

abstract public class TerminalFrameAction implements ActionListener {
	
	SelectTerminalMainFrame main;
	
	public TerminalFrameAction(SelectTerminalMainFrame main) {
		this.main = main;
	}
}
