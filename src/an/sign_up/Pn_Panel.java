package an.sign_up;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pn_Panel extends JPanel{
	
	JLabel pn = new Sign_Label("전화번호 :");
	JLabel label = new Sign_Label("-");
	JLabel label2 = new Sign_Label("-");
	JTextField pntext;
	JTextField pntext2;
	JTextField pntext3;
	
public Pn_Panel(JTextField pntext,JTextField pntext2,JTextField pntext3) {
	this.pntext = pntext;
	this.pntext2 = pntext2;
	this.pntext3 = pntext3;
	setLayout(new FlowLayout(FlowLayout.LEFT));
	add(pn);add(pntext);add(label2);add(pntext2);add(label);add(pntext3);
	
}

}
