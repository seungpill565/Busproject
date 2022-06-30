package an.login;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IdPanel extends JPanel{
	JLabel id = new IdPwd_Label("¾ÆÀÌµð : ");
	ImageIcon image = new ImageIcon("image/id.png");
	
	public IdPanel() {
		new JPanel(new FlowLayout(FlowLayout.RIGHT));
		setBackground(new Color(0x77757B));
		id.setText("");
		id.setIcon(image);
		add(id);
		
	}

}
