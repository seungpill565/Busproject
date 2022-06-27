package hong.selectseat.event;

import java.awt.event.ActionEvent;

import hong.selectseat.SelectSeatMainFrame;

public class BeforeButtonEvent extends SeatMainFramAction{
	
	
	public BeforeButtonEvent(SelectSeatMainFrame main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.beforeFrame();
		main.thisClose();
	}
}
