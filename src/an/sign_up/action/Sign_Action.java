package an.sign_up.action;

import java.awt.event.ActionListener;

import an.sign_up.Sign_Panel;

public abstract class Sign_Action implements ActionListener{
	
	Sign_Panel main;
	
	public Sign_Action(Sign_Panel main) {
		this.main = main;
	}

}
