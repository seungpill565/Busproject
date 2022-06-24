package an.admin.action;

import java.awt.event.ActionListener;

import an.admin.Admin_MainFrame;

public abstract class Admin_Action implements ActionListener{
	
	Admin_MainFrame main;
	
	public Admin_Action(Admin_MainFrame main) {
		
		this.main = main;
		
	}

}
