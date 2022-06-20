package an.find;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class IdFind_Panel extends JPanel{
	JLabel findLabel = new Find_Label("아이디 찾기");
	public IdFind_Panel() {
		
		setLayout(new FlowLayout());
		setForeground(new Color(0X000000));
		add(findLabel);
		
	}

}
