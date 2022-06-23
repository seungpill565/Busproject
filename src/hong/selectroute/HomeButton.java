package hong.selectroute;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class HomeButton extends JButton {
	
	//private LineBorder lb = new LineBorder(Color.BLACK);
	private Dimension dimension = new Dimension(180,70);
	private ImageIcon icon = new ImageIcon("image/reservationHome.png");
	
	public HomeButton() {
		super("Home");
		setOpaque(false);
		setIcon(icon);
		setBorderPainted(false);
		setBackground(Color.WHITE);
		//setBorder(lb);
		setPreferredSize(dimension);
	}
}
