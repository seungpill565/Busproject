package an.sign_up;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pass_CheckPanel extends JPanel{
	JLabel password = new Sign_Label("비밀번호 확인:");
	JTextField passCkText;
	
	public Pass_CheckPanel(JTextField passCkText) {
		this.passCkText = passCkText;
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBackground(new Color(0X4D7F86));
		add(password);add(passCkText);
	}

}
