package hong.selectroute;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class SerchButton extends JButton {
	
	private Dimension dimension = new Dimension(560,50);
	
	public SerchButton() {
		super("조회하기");
		setOpaque(true);
		setBackground(Color.WHITE);
		setFont(new Font("HY헤드라인M", Font.PLAIN, 18));
		setPreferredSize(dimension);
	}
}
