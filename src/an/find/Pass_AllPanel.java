package an.find;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pass_AllPanel extends JPanel{
	JTextField nameText = new Find_TextField(10);
	JTextField idText = new Find_TextField(10);
	
	JPanel name = new Pass_NamePanel(nameText);
	JPanel id = new Pass_IdPanel(idText);	
	
	public Pass_AllPanel(JTextField j ,JTextField j2) {
		nameText = j2;
		idText = j;
		
		setLayout(new FlowLayout());
		
		add(name);add(id);
		
		
		
	}

}
