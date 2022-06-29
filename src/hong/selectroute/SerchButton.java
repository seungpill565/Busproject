package hong.selectroute;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class SerchButton extends JButton {
	
	//private LineBorder lb = new LineBorder(Color.BLACK);
	private Dimension dimension = new Dimension(300,50);
	
	public SerchButton() {
		super("조회하기");
		setOpaque(false);
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setFont(new Font("휴먼편지체", Font.BOLD, 23));
		setBorderPainted(false);
		//setBorder(lb);
		setPreferredSize(dimension);
	}
}
