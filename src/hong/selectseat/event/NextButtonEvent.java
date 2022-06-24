package hong.selectseat.event;

import java.awt.event.ActionEvent;

import hong.selectseat.SelectSeatMainFrame;

public class NextButtonEvent extends SeatMainFramAction{
	
	public NextButtonEvent(SelectSeatMainFrame main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.nextFrame();
	}
}
