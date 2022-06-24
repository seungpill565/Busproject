package an.login.action;

import java.awt.event.ActionEvent;

import an.login.Login_Mainframe;


public class Allpanel_loginAction extends Allpanel_Action{

	public Allpanel_loginAction(Login_Mainframe main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.loginac();
		
	}

}
