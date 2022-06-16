package hong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class SelectRouteMainFrame extends JFrame {
	
	MainPanel mainPanel = new MainPanel();
	
	
	public SelectRouteMainFrame() {
		
		setTitle("버스 예약 시스템");
		
		add(mainPanel);
		
		setBounds(300, 100, 600, 650);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new SelectRouteMainFrame();
	}
}
