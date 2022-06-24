package an.login.action;

import java.awt.event.ActionEvent;

import an.login.Login_Mainframe;

public class Join_Action extends Allpanel_Action{

	public Join_Action(Login_Mainframe main) {
		super(main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.join();
	}

}
