package hong.selectroute;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class StartingPointButton extends JButton {
	
	private LineBorder lb = new LineBorder(Color.BLACK);
	private Dimension dimension = new Dimension(240,200);
	
	public StartingPointButton() {
		super("출발지를 선택해주세요");
		setBackground(new Color(0xFFE5CC));
		setFont(new Font("맑은고딕", Font.BOLD, 20));
		setBorder(lb);
		setPreferredSize(dimension);
	}
	
	public void setTextStpBtn(String str) {
		setText(str);
	}
}
