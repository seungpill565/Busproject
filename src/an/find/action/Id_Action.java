package an.find.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import an.find.IdFind_Frame;

public abstract class Id_Action implements ActionListener{
	
	IdFind_Frame main;
	
	public Id_Action(IdFind_Frame main) {
		this.main = main;
	}

}
