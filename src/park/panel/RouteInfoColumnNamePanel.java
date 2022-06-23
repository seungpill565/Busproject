package park.panel;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import park.label.RouteInfoColumnNameLabel;

public class RouteInfoColumnNamePanel extends JPanel {// 스크롤패인의 맨 윗부분에 들어갈 좌석정보 컬럼명 넣을 패널

	public RouteInfoColumnNamePanel() {
		LayoutManager manager = new FlowLayout(FlowLayout.LEFT,0,0);
		
		setLayout(manager);
		
		
		add(new RouteInfoColumnNameLabel("  날짜"));
		add(new RouteInfoColumnNameLabel("시간"));
		add(new RouteInfoColumnNameLabel("출발지"));
		add(new RouteInfoColumnNameLabel("목적지"));
		add(new RouteInfoColumnNameLabel("좌석번호"));
	}	
}
