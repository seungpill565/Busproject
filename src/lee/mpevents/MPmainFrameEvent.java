package lee.mpevents;

import java.awt.event.ActionListener;

import lee.mpcomponents.MPmainFrame;

abstract public class MPmainFrameEvent implements ActionListener {

	MPmainFrame main;
	
	public MPmainFrameEvent(MPmainFrame main) {
		this.main = main;
	}

}
