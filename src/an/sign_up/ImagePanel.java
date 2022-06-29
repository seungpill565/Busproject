package an.sign_up;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import an.login.IdPwd_Label;

public class ImagePanel extends JPanel{
	
	public ImagePanel() {
		JLabel label = new IdPwd_Label("¿ÃπÃ¡ˆ");
		ImageIcon image = new ImageIcon("image/sign.png");
		label.setText("");
		label.setIcon(image);
		
		add(label);
	}

}
