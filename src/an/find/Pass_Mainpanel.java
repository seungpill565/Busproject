package an.find;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pass_Mainpanel extends JPanel{
	
	JLabel findLabel = new Find_Label("비밀번호 찾기");
	public Pass_Mainpanel() {
		
		setLayout(new FlowLayout());
		setForeground(new Color(0X000000));
		
		add(findLabel);
		
	}

}
