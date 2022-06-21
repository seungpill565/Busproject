package an.userinfo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import an.login.IdPwd_Label;

public class Info_ImagePanel extends JPanel{
	
	public Info_ImagePanel() {
		JLabel label = new IdPwd_Label("¿ÃπÃ¡ˆ");
		ImageIcon image = new ImageIcon("C:\\javaAWS\\repository\\project\\MyTeamProject\\src\\an\\Bus2.png");
		label.setText("");
		label.setIcon(image);
		
		add(label);
	}

}
