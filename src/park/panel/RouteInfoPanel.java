package park.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import hong.SaveInfo;

public class RouteInfoPanel extends JPanel{
	RouteInfoColumnNamePanel panel = new RouteInfoColumnNamePanel();
	RouteInfoRowsPanel rowsPanel ;
	public RouteInfoPanel(SaveInfo user) {
		LayoutManager manager = new BorderLayout();
		setLayout(manager);
		//panel.setLocation(10, 200);
		rowsPanel = new RouteInfoRowsPanel(user);
		add(panel,"North");
		add(rowsPanel,"Center");
		
		
		setBackground(Color.white);
		//setLayout(null);
		setBounds(10,100,465,200);
	}

}
