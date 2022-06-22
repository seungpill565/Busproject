package hong.selectseat.event;

import java.awt.event.ActionEvent;

import hong.selectseat.SelectSeatMainFrame;

public class SeatButtonEvent extends SeatMainFramAction {
	
	public SeatButtonEvent(SelectSeatMainFrame main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.selectSeat(Integer.parseInt(e.toString().substring(e.toString().indexOf("on ") + 3)));
	}
	
}
