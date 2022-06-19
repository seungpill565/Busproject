package an.login;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Login_ImgPanel extends JPanel{
	
	public Login_ImgPanel() {
		JLabel label = new IdPwd_Label("¿ÃπÃ¡ˆ");
		ImageIcon image = new ImageIcon("MyTeamProject\\src\\an\\Bus.png");
		label.setText("");
		label.setIcon(image);
		
		add(label);
		
	
	}
}
