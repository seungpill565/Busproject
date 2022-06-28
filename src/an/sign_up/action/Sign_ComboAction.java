package an.sign_up.action;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import an.sign_up.Sign_Panel;

public class Sign_ComboAction extends Sign_Action{

	public Sign_ComboAction(Sign_Panel main) {
		super(main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		main.checkerror();
	}

	

}
