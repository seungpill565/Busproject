package an.find.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import an.find.Find_MainFrame;

public abstract class FindMain_Action implements ActionListener{

	Find_MainFrame main;
	
	public FindMain_Action (Find_MainFrame main) {
		this.main = main;
		
	}
	
}
