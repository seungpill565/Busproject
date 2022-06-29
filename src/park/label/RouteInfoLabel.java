package park.label;

import java.awt.Font;

import javax.swing.JLabel;

public class RouteInfoLabel extends JLabel{
	public RouteInfoLabel() {
		super("행선지 정보");
		setFont(new Font("휴먼 편지체", Font.BOLD, 20));
		setBounds(190,50,400,30);
	}
}
