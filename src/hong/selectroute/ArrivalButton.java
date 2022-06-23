package hong.selectroute;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class ArrivalButton extends JButton {
	
	private LineBorder lb = new LineBorder(Color.BLACK);
	private Dimension dimension = new Dimension(240,200);
	
	public ArrivalButton() {
		super("도착지를 입력해주세요");
		setOpaque(true);
		setBackground(new Color(0xFFE5CC));
		setFont(new Font("맑은고딕", Font.BOLD, 20));
		setBorder(lb);
		setPreferredSize(dimension);
	}
	
	public void setTextArvBtn(String str) {
		setText(str);
	}
}
