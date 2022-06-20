package an.admin;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class User_ButtonPanel extends JPanel{
	JButton input = new JButton("입력");
	JButton modify = new JButton("수정");
	JButton output = new JButton("출력");
	JButton delete = new JButton("삭제");
	public User_ButtonPanel(JButton j1,JButton j2,JButton j3,JButton j4) {
		input = j1;
		modify = j2;
		output = j3;
		delete = j4;
		
		setLayout(new FlowLayout());
		add(input);add(modify);add(output);add(delete);
		
	}

}
