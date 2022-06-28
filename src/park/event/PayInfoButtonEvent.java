package park.event;

import java.awt.event.ActionEvent;

import park.frame.PayInfo;

public class PayInfoButtonEvent extends PayInfoFrameAction{

	public PayInfoButtonEvent(PayInfo main) {
		super(main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.homeButtonEvent();
		
	}
	

}
