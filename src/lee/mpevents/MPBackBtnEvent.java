package lee.mpevents;

import java.awt.event.ActionEvent;

import lee.mpcomponents.MPmainFrame;

public class MPBackBtnEvent extends MPmainFrameEvent {

	public MPBackBtnEvent (MPmainFrame main) {
		super(main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.backBtnCtrl();
	}

}
