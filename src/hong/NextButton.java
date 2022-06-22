package hong;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class NextButton extends JButton {
	
	private LineBorder lb = new LineBorder(Color.BLACK);
	private Dimension dimension = new Dimension(100,40);
	
	public NextButton() {
		
		super("»Æ¿Œ");
		setBackground(new Color(0xFFE5CC));
		setBorder(lb);
		setPreferredSize(dimension);
	}

}
