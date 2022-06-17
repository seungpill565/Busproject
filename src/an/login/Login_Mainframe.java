package an.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Login_Mainframe extends JFrame{
	
	JPanel title = new Mainpenal();
	JPanel allIdLabel = new All_Panel();
	JPanel jp = new JPanel();
	
	public Login_Mainframe() {
		setTitle("버스 예약시스템");
		
		jp.setLayout(new FlowLayout());
		jp.add(allIdLabel);
		
		setLayout(new BorderLayout());
		add(title, BorderLayout.NORTH);
		add(jp, BorderLayout.SOUTH);
		
		setBounds(500, 200, 800, 500);
		setResizable(false);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Login_Mainframe();
	}

}
