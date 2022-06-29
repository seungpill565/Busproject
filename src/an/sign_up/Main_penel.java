package an.sign_up;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;



public class Main_penel extends JPanel{
	
	JLabel signup = new Main_Label("버스 회원 회원가입");
	
	public Main_penel() {
		new JPanel(new FlowLayout(FlowLayout.RIGHT));
		setBackground(new Color(0X4D7F86));
		add(signup);
	}

}
