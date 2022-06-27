package park.event;

import java.awt.event.ActionListener;

import park.frame.PayInfo;

abstract public class PayInfoFrameAction implements ActionListener{
	PayInfo main;
	public PayInfoFrameAction(PayInfo main) {
		this.main = main;
	}

}
