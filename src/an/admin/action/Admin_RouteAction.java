package an.admin.action;

import java.awt.event.ActionEvent;

import an.admin.Admin_MainFrame;

public class Admin_RouteAction extends Admin_Action{

	public Admin_RouteAction(Admin_MainFrame main) {
		super(main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.routeModifyAction();
		
	}

}
