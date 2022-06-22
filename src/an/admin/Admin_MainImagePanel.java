package an.admin;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import an.login.IdPwd_Label;

public class Admin_MainImagePanel extends JPanel{
	
	public Admin_MainImagePanel() {
		JLabel label = new IdPwd_Label("¿ÃπÃ¡ˆ");
		ImageIcon image = new ImageIcon("image/Bus3.png");
		label.setText("");
		label.setIcon(image);
		
		add(label);
	}

}
