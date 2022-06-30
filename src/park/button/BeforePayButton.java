package park.button;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BeforePayButton extends JButton{
	
	public BeforePayButton(ImageIcon imageicon) {
		super(imageicon);
		
		setBounds(100,10,40,40);
		setBorderPainted(false);
		setOpaque(false);
		setFocusPainted(false);
		setFont(new Font("휴먼 편지체", Font.BOLD,15));
		setForeground(new Color(0x000000));
		setBackground(new Color(0xffff00));		
	}
}
