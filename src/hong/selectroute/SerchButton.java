package hong.selectroute;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class SerchButton extends JButton {
	
	//private LineBorder lb = new LineBorder(Color.BLACK);
	private Dimension dimension = new Dimension(300,50);
	private ImageIcon img = new ImageIcon("image/serchButton.png");
	private ImageIcon img2 = new ImageIcon("image/serchButton2.png");
	private ImageIcon img3 = new ImageIcon("image/serchButton3.png");
	
	public SerchButton() {
		super("조회하기");
		setOpaque(false);
		setIcon(img);
		setRolloverIcon(img2);
		setPressedIcon(img3);
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setFont(new Font("휴먼편지체", Font.BOLD, 23));
		setBorderPainted(false);
		//setBorder(lb);
		setPreferredSize(dimension);
	}
}
