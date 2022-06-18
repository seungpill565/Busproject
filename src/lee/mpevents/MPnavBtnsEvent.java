package lee.mpevents;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import lee.mpcomponents.MPmainFrame;

public class MPnavBtnsEvent extends MPmainFrameEvent {

	JButton btn;
	
	public MPnavBtnsEvent(MPmainFrame main, JButton btn) {
		super(main);
		this.btn = btn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.navBtnCtrl(btn);
	}

}
