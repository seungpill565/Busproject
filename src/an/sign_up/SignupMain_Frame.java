package an.sign_up;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;



	
public class SignupMain_Frame extends JFrame {

		String choice = null;

		
		JPanel signupPanel = new Main_penel();
		JPanel allPanel = new ALL_panel();
		
	public SignupMain_Frame() {
		setTitle("회원관리 화면");
			
		add(signupPanel, BorderLayout.NORTH);
		add(allPanel, BorderLayout.CENTER);
		//add(pass_explan, BorderLayout.SOUTH);
		
		
		
		
		setSize(390, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);  
		setVisible(true);
	}
	
}
