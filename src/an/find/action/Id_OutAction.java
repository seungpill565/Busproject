package an.find.action;

import java.awt.event.ActionEvent;

import an.find.IdFind_Frame;

public class Id_OutAction extends Id_Action{

	public Id_OutAction(IdFind_Frame main) {
		super(main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.idoutAction();
		
	}

}
