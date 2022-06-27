package park.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import park.frame.Pay;

abstract public class PayFrameAction implements ActionListener{

	Pay main;
	
	public PayFrameAction(Pay main) {
		this.main = main;
		
	}

}
