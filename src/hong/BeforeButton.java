package hong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class BeforeButton extends JButton{
	
	private LineBorder lb = new LineBorder(Color.GRAY, 3);
	private Dimension dimension = new Dimension(100,40);
	
	public BeforeButton() {
		super("이전으로");
		setOpaque(false);
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setFont(new Font("휴먼편지체", Font.BOLD, 17));
		setBorder(lb);
		setPreferredSize(dimension);
	} 
}
