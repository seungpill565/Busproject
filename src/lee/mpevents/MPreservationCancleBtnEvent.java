package lee.mpevents;

import java.awt.event.ActionEvent;

import lee.mpcomponents.MPmainFrame;

public class MPreservationCancleBtnEvent extends MPmainFrameEvent {

	public MPreservationCancleBtnEvent(MPmainFrame main) {
		super(main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.reservationcancleBtnCtrl();
	}

}
