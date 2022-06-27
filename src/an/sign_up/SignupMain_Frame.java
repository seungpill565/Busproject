package an.sign_up;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import an.sign_up.ALL_panel.new_panel;



	
public class SignupMain_Frame extends JFrame {

		String choice = null;

		
		JPanel signupPanel = new Main_penel();
		JPanel allPanel = new ALL_panel();
		JPanel pass_explan = new Pass_Explanation();
		
	public SignupMain_Frame() {
		setTitle("회원관리 화면");
			
		add(signupPanel, BorderLayout.NORTH);
		add(allPanel, BorderLayout.CENTER);
		add(pass_explan, BorderLayout.SOUTH);
		
		
		
		
		setBounds(610, 200, 500, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);  
		setVisible(true);
	}
	
}
