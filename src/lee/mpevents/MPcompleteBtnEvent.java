package lee.mpevents;

import java.awt.event.ActionEvent;

import lee.mpcomponents.MPmainFrame;

public class MPcompleteBtnEvent extends MPmainFrameEvent {

	public MPcompleteBtnEvent(MPmainFrame main) {
		super(main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.completeBtnCtrl();
	}

}
