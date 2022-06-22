package hong.selectroute;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class HomeButton extends JButton {
	
	private LineBorder lb = new LineBorder(Color.BLACK);
	private Dimension dimension = new Dimension(180,70);
	
	public HomeButton() {
		super("Home");
		setOpaque(true);
		setBackground(new Color(0xFFE5CC));
		setBorder(lb);
		setPreferredSize(dimension);
	}
}
