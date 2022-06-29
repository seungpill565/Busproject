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
		//setSize(user);
		scrollPanel.setPreferredSize(size);
		scroll = new JScrollPane(scrollPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.getViewport().setBackground(Color.white);
		
		add(scroll,"Center");
		
		//scroll.setViewportView(scrollPanel);
		
		setBackground(Color.white);
		setBounds(10,350,465,70);
	}
	void setSize(SaveInfo user) {
		if(user.getSeatSize()>5)
			size.setSize(450,30);
		else if(user.getSeatSize()>10)
			size.setSize(450,60);
		else if(user.getSeatSize()>15)
			size.setSize(450,90);
		else if(user.getSeatSize()>20)
			size.setSize(450,120);
	}
}
