package hong.selectseat.event;

import java.awt.event.ActionListener;

import hong.selectseat.SelectSeatMainFrame;

abstract public class SeatMainFramAction implements ActionListener {
		
	SelectSeatMainFrame main;
	
	public SeatMainFramAction(SelectSeatMainFrame main) {
		this.main = main;
	}
}
