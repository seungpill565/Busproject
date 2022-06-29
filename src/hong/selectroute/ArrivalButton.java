package hong.selectroute;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class ArrivalButton extends JButton {
	
	//private LineBorder lb = new LineBorder(Color.BLACK);
	private Dimension dimension = new Dimension(100,80);
	
	public ArrivalButton() {
		super("선택");
		setOpaque(false);
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setFont(new Font("휴먼편지체", Font.BOLD, 25));
		setBorderPainted(false);
		//setBorder(lb);
		setPreferredSize(dimension);
	}
	
	public void setTextArvBtn(String str) {
		setText(str);
	}
}
