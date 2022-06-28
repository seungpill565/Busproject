package park.event;

import java.awt.event.ActionEvent;

import park.frame.Pay;

public class PayButtonEvent extends PayFrameAction{

	public PayButtonEvent(Pay main) {
		super(main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.payButtonEvent();
		
	}

}
