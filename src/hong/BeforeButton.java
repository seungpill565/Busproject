package hong;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class BeforeButton extends JButton{
	
	private LineBorder lb = new LineBorder(Color.BLACK);
	private Dimension dimension = new Dimension(100,40);
	
	public BeforeButton() {
		super("이전으로");
		setBorder(lb);
		setPreferredSize(dimension);
	} 
}
