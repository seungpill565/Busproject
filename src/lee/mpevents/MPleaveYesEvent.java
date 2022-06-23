package lee.mpevents;

import java.awt.event.ActionEvent;

import lee.mpcomponents.MPmainFrame;

public class MPleaveYesEvent extends MPmainFrameEvent {

	public MPleaveYesEvent(MPmainFrame main) {
		super(main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.leaveBtnCtrl();
	}

}
