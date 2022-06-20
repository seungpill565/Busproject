package hong.selectroute;

import java.awt.Font;

import javax.swing.JButton;

public class ArriveButton extends JButton {
	
	public ArriveButton() {
		setText("도착지를 입력해주세요");
		setFont(new Font("맑은고딕", Font.BOLD, 20));
	}
	
	public void setDestination(String str) {
		setText(str);
	}
}
