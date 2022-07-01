package park.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import hong.SaveInfo;

public class SelectSeatAgePanel extends JPanel {

	JScrollPane scroll;
	Dimension size = new Dimension();
	SeatBoxScrollPanePanel scrollPanel;

	public SelectSeatAgePanel(SaveInfo user) {
		LayoutManager manager = new BorderLayout();
		setLayout(manager);
		scrollPanel = new SeatBoxScrollPanePanel(user);
		size.setSize(450,30*(user.getSeatSize()/5+1));
		scrollPanel.setPreferredSize(size);
		scroll = new JScrollPane(scrollPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.getViewport().setBackground(Color.white);
		
		add(scroll,"Center");
		
		setBackground(Color.white);
		setBounds(10,350,465,70);
	}
}
