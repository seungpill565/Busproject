package an.sign_up.action;

import java.awt.event.KeyListener;

import an.sign_up.Sign_Panel;

public abstract class Sign_KeyAction implements KeyListener{
	
	Sign_Panel main;
	
	public Sign_KeyAction(Sign_Panel main) {
		this.main = main;
	}

}
