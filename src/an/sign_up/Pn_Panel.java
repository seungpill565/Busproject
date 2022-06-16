package an.sign_up;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pn_Panel extends JPanel{
	
	JLabel pn = new Sign_Label("전화번호 :");
	JTextField pntext;
	
public Pn_Panel(JTextField pntext) {
	this.pntext = pntext;
	setLayout(new FlowLayout(FlowLayout.RIGHT));
	add(pn);add(pntext);
	
}

}
