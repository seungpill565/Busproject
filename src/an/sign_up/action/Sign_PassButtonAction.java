package an.sign_up.action;

import java.awt.event.ActionEvent;

import an.sign_up.Sign_Panel;

public class Sign_PassButtonAction extends Sign_Action{

	public Sign_PassButtonAction(Sign_Panel main) {
		super(main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.checkpass();
		
	}

}
