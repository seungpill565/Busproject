package an.find;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pass_IdPanel extends JPanel{
	JLabel idLabel = new Find_Label("¾ÆÀÌµð : ");
	JTextField idText = new Find_TextField(10);
	
	 public Pass_IdPanel(JTextField j) {
		 
		 idText = j;
		 
		setLayout(new FlowLayout(FlowLayout.LEADING));
		
		add(idLabel); add(idText);
	}
	

}
