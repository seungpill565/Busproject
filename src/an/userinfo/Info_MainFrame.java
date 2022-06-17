package an.userinfo;

import javax.swing.JFrame;

public class Info_MainFrame extends JFrame{
	
	public Info_MainFrame() {
		setBounds(500, 200, 800, 500);
		setResizable(false);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Info_MainFrame();
	}
}
