package park.scrollpane;

import java.awt.Color;

import javax.swing.JScrollPane;

import park.panel.RouteInfoColumnNamePanel;

public class PayInfoScrollpane extends JScrollPane{ // 이게 있어야되는지 판단해봐야됨

	public PayInfoScrollpane() {
		add(new RouteInfoColumnNamePanel());
		setBackground(Color.white);
		setBounds(10,100,465,200);
	}
}
