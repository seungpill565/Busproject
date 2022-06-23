package park.panel;

import javax.swing.JPanel;

public class RouteInfoPanel extends JPanel{
	RouteInfoColumnNamePanel panel = new RouteInfoColumnNamePanel();
	public RouteInfoPanel() {
		
		panel.setLocation(10, 300);
		add(panel);
		
		setLayout(null);
		setBounds(10,100,465,200);
	}

}
