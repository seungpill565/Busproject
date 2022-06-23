package park.scrollpane;

import java.awt.Color;

import javax.swing.JScrollPane;

import park.panel.RouteInfoColumnNamePanel;

public class PayInfoScrollpane extends JScrollPane{ 

	public PayInfoScrollpane() {
		super(new RouteInfoColumnNamePanel());
		getViewport().setBackground(Color.white); // 스크롤패인 배경색 변경
		setBounds(10,100,465,200);
	}
}
