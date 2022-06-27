package an.sign_up.action;

import java.awt.event.ActionEvent;

import an.sign_up.Sign_Panel;

public class Sign_IdButtonAction extends Sign_Action{

	public Sign_IdButtonAction(Sign_Panel main) {
		super(main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.checkid();
		
	}

}
