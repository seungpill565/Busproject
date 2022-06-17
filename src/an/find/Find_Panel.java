package an.find;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;



public class Find_Panel extends JPanel{
	JLabel found = new Find_Label("아이디/비밀번호 찾기");
	public Find_Panel() {
		
		new JPanel(new FlowLayout(FlowLayout.RIGHT));
		add(found);
		
	}

}
