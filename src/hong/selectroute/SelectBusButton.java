package hong.selectroute;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class SelectBusButton extends JButton {
	
	private LineBorder lb = new LineBorder(Color.BLACK);
	private Dimension dimension = new Dimension(105,20);
	
	public SelectBusButton() {
		super("예약하기");
		//setOpaque(true);
		//setBackground(Color.WHITE);
		//setHorizontalAlignment(CENTER);
		setBorder(lb);
		setPreferredSize(dimension);
	}	
}
