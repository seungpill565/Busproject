package an.sign_up;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Id_Panel extends JPanel{
	
	JLabel id = new Sign_Label("¾ÆÀÌµð :");
	JTextField idtext ;
	
public Id_Panel(JTextField idtext) {
	this.idtext = idtext;
	setLayout(new FlowLayout(FlowLayout.RIGHT));
	add(id);add(idtext);
	
}

}
