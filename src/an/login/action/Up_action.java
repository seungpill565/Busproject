package an.login.action;

import java.awt.event.ActionEvent;

import an.login.Login_Mainframe;

public class Up_action extends Allpanel_Action{

	public Up_action(Login_Mainframe main) {
		super(main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.up();
	}

}
