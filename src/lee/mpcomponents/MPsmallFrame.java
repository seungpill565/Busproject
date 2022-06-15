package lee.mpcomponents;

import javax.swing.JFrame;

public class MPsmallFrame extends JFrame{
	
	public MPsmallFrame() {
		setTitle("작은창_설명용");
		setBounds(0, 0, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MPsmallFrame();
	}
}
