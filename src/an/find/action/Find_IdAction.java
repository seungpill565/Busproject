package an.find.action;

import java.awt.event.ActionEvent;

import an.find.Find_MainFrame;

public class Find_IdAction extends FindMain_Action{

	public Find_IdAction(Find_MainFrame main) {
		super(main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.Find_id();
		
	}

}
