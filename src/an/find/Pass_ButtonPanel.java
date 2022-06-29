package an.find;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Pass_ButtonPanel extends JPanel{
	
	JButton button = new Find_Button("찾기");
	JButton button2 = new Find_Button("아이디 찾기");
	JButton out = new Find_Button("나가기");
	
	public Pass_ButtonPanel(JButton b, JButton b2,JButton b3) {
		button = b;
		button2 = b2;
		out =b3;
		setBackground(new Color(0X4D7F86));
		setLayout(new FlowLayout());
		
		add(button); add(button2);
		add(out);
		
	}
}
