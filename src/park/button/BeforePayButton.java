package park.button;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import hong.SaveInfo;
import hong.selectseat.SelectSeatMainFrame;

public class BeforePayButton extends JButton{
	
	public BeforePayButton(SaveInfo user) {
		super("Before");
		

		setBounds(100,10,85,30);
		setFont(new Font("±Ã¼­Ã¼", Font.BOLD,15));
		setForeground(new Color(0x000000));
		setBackground(new Color(0xffff00));		
	}
}
