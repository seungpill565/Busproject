package lee.mpevents;

import java.awt.event.ActionEvent;

import lee.mpcomponents.MPmainFrame;

public class MPeditBtnEvent extends MPmainFrameEvent {

	public MPeditBtnEvent(MPmainFrame main) {
		super(main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.editBtnCtrl();
	}

}
