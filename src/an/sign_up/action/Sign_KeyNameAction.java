package an.sign_up.action;

import java.awt.event.KeyEvent;

import an.sign_up.Sign_Panel;

public class Sign_KeyNameAction extends Sign_KeyAction{

	public Sign_KeyNameAction(Sign_Panel main) {
		super(main);
		// TODO Auto-generated constructor stub
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
		main.nameerror();
		
	}

}
