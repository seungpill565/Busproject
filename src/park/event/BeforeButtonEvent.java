package park.event;

import java.awt.event.ActionEvent;

import park.frame.Pay;

public class BeforeButtonEvent extends PayFrameAction {

	public BeforeButtonEvent(Pay main) {
		super(main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.beforeButtonEvent();
		
	}

}
