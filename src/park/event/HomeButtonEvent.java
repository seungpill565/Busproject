package park.event;

import java.awt.event.ActionEvent;

import park.frame.Pay;

public class HomeButtonEvent extends PayFrameAction{

	public HomeButtonEvent(Pay main) {
		super(main);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.homeButtonEvent();
		
	}

}
