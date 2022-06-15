package lee.mpcomponents;

import javax.swing.JFrame;

public class MPmainFrame extends JFrame {
	public MPmainFrame() {
		setTitle("큰창_이거 하나에 컴포넌트만 바꿀 것");
		setBounds(0, 0, 900, 650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MPmainFrame();
	}
}
