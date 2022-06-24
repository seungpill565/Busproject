package an.find.action;

import java.awt.event.ActionEvent;

import an.find.IdFind_Frame;

public class Id_PassAction extends Id_Action{

	public Id_PassAction(IdFind_Frame main) {
		super(main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.idpassAction();
	}

}
