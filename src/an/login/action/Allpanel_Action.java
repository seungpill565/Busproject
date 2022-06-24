package an.login.action;

import java.awt.event.ActionListener;
import an.login.Login_Mainframe;

public abstract class Allpanel_Action implements ActionListener{
	
	Login_Mainframe main;
	
	public Allpanel_Action(Login_Mainframe main) {
		this.main = main;
	}
}
