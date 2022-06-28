package park.panel;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import park.label.RvInfoColumnNameLabel;

public class RvInfoColumnNamePanel extends JPanel{
	public RvInfoColumnNamePanel() {
	LayoutManager manager = new FlowLayout(FlowLayout.LEFT,0,0);
		
		setLayout(manager);
		
		add(new RvInfoColumnNameLabel("예매번호"));
		add(new RvInfoColumnNameLabel(" 날짜"));
		add(new RvInfoColumnNameLabel(" 시간"));
		add(new RvInfoColumnNameLabel("출발지"));
		add(new RvInfoColumnNameLabel("목적지"));
		add(new RvInfoColumnNameLabel("좌석번호"));
	}

}
