package an.find;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class IdFind_Panel extends JPanel{
	JLabel findLabel = new Find_Label("아이디 찾기");
	public IdFind_Panel() {
		
		setLayout(new FlowLayout());
		
		add(findLabel);
		
	}

}
