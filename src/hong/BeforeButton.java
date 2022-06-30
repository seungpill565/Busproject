package hong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BeforeButton extends JButton{
	
	//private LineBorder lb = new LineBorder(Color.GRAY, 3);
	private Dimension dimension = new Dimension(110,40);
	private ImageIcon img = new ImageIcon("image/beforeButton.png");
	private ImageIcon img2 = new ImageIcon("image/beforeButton2.png");
	private ImageIcon img3 = new ImageIcon("image/beforeButton3.png");
	
	public BeforeButton() {
		//super("이전으로");
		setOpaque(false);
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setIcon(img);
		setRolloverIcon(img2);
		setPressedIcon(img3);
		
		setFont(new Font("휴먼편지체", Font.BOLD, 17));
		setBorderPainted(false);
		//setBorder(lb);
		setPreferredSize(dimension);
	} 
}
