package park.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import hong.SaveInfo;

public class RvInfoPanel extends JPanel {
	
	RvInfoColumnNamePanel panel = new RvInfoColumnNamePanel();
	JScrollPane scroll;
	ScrollPanePanel2 scrollPanel;
	Dimension size = new Dimension();
	
	public RvInfoPanel(SaveInfo user) {
		LayoutManager manager = new BorderLayout();
		setLayout(manager);
		scrollPanel = new ScrollPanePanel2(user);
		size.setSize(450, 30*user.getSeatSize());
		scrollPanel.setPreferredSize(size);
		scroll = new JScrollPane(scrollPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.getViewport().setBackground(Color.white);
		
		add(panel,"North");
		add(scroll,"Center");
		
		scroll.setViewportView(scrollPanel);
		setBackground(Color.white);
		setBounds(10,100,465,300);
	}
}
