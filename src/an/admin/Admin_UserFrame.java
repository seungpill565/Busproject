package an.admin;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Admin_UserFrame extends JFrame{
	
	JPanel infoPanel = new Admin_UserPanel();
	
	public Admin_UserFrame() {
		
		add(infoPanel,BorderLayout.NORTH);
		
		setBounds(500, 200, 800, 500);
		setResizable(false);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); 
		
	}
	
	public static void main(String[] args) {
		new Admin_UserFrame();
	}
	
	
}
