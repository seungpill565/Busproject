package an.find.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import an.find.PassFind_Frame;

public abstract class Pass_Action implements ActionListener{

	PassFind_Frame main;
	
	public Pass_Action(PassFind_Frame main) {
		this.main = main;
		
	}

}
