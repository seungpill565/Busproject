package hong.selectroute;

import java.awt.Font;

import javax.swing.JButton;

public class StartingPointButton extends JButton {
	
	public StartingPointButton() {
		super("출발지를 선택해주세요");
		setFont(new Font("맑은고딕", Font.BOLD, 20));
	}
	
	public void setStarting(String str) {
		setText(str);
	}
}
