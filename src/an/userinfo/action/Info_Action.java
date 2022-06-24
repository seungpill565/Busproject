package an.userinfo.action;

import java.awt.event.ActionListener;

import an.userinfo.Info_MainFrame;

public abstract class Info_Action implements ActionListener{

	Info_MainFrame main;
	
	public Info_Action(Info_MainFrame main) {
		this.main = main;
	}
}
