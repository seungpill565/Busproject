package an.userinfo.action;

import java.awt.event.ActionEvent;

import an.userinfo.Info_MainFrame;

public class Info_ReservationAction extends Info_Action{

	public Info_ReservationAction(Info_MainFrame main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.ReservationAction();
	}

}
