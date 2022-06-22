package park.label;

import java.awt.Font;

import javax.swing.JLabel;

public class RouteInfo extends JLabel{
	public RouteInfo() {
		super("행선지 정보");
		setFont(new Font("HY견고딕 보통", Font.BOLD, 20));
		setBounds(190,50,400,30);
	}
}
