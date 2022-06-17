package hong.selectroute;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SelectTerminalMainFrame extends JFrame {
	
	SelectTerminalPanel stPanel = new SelectTerminalPanel(); 
	
	public SelectTerminalMainFrame() {
		
		setTitle("터미널 선택");
		
		add(stPanel);
		
		setBounds(300, 100, 500, 400);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SelectTerminalMainFrame();
	}
	
}
