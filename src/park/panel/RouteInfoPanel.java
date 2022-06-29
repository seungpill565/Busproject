package park.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import hong.SaveInfo;

public class RouteInfoPanel extends JPanel{
	RouteInfoColumnNamePanel panel = new RouteInfoColumnNamePanel();
	JScrollPane scroll;
	ScrollPanePanel scrollPanel;
	Dimension size = new Dimension();
	
	public RouteInfoPanel(SaveInfo user) {
		LayoutManager manager = new BorderLayout();
		setLayout(manager);
		scrollPanel = new ScrollPanePanel(user);
		size.setSize(450, 35*user.getSeatSize());
		scrollPanel.setPreferredSize(size);
		scroll = new JScrollPane(scrollPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.getViewport().setBackground(Color.white);
		
		add(panel,"North");
		add(scroll,"Center");
		
		//scroll.setViewportView(scrollPanel);
		setBackground(Color.white);
		setBounds(10,100,465,250);
	}

}
