package an.sign_up.action;

import java.awt.event.KeyEvent;

import an.sign_up.Sign_Panel;

public class Sign_KeyIdAction extends Sign_KeyAction{

	public Sign_KeyIdAction(Sign_Panel main) {
		super(main);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		main.iderror();
		
	}

}
