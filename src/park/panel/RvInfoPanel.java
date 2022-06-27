package park.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import hong.SaveInfo;

public class RvInfoPanel extends JPanel {
	
	RvInfoColumnNamePanel panel = new RvInfoColumnNamePanel();
	RvInfoRowsPanel rowsPanel;
	
	public RvInfoPanel(SaveInfo user) {
		LayoutManager manager = new BorderLayout();
		setLayout(manager);
		rowsPanel = new RvInfoRowsPanel(user);
		add(panel,"North");
		add(rowsPanel,"Center");
		
		setBackground(Color.white);
		//setLayout(null);
		setBounds(10,100,465,200);
		
	}

}
