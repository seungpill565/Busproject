package an.find.action;

import java.awt.event.ActionEvent;

import an.find.PassFind_Frame;

public class Pass_FindAction extends Pass_Action{

	public Pass_FindAction(PassFind_Frame main) {
		super(main);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.findAction();
		
	}

}
