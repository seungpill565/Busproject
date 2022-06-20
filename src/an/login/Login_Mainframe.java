package an.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Login_Mainframe extends JFrame{
	JPanel title = new Mainpenal();
	JPanel allIdLabel = new All_Panel();
	JPanel image = new Login_ImgPanel();
	JPanel jp = new JPanel();
	
	public Login_Mainframe() {
		setTitle("버스 예약시스템");
		setLayout(new BorderLayout(0,0));

		jp.setLayout(new FlowLayout());
		jp.add(allIdLabel);
		
		setLayout(new BorderLayout());
		add(title, BorderLayout.NORTH);
		add(jp, BorderLayout.SOUTH);
		add(image,BorderLayout.CENTER);
		
		
		
		setBounds(500, 200, 800, 500);
		setResizable(false);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
			  try {

			  JFrame.setDefaultLookAndFeelDecorated(true);

			  }  catch (Exception e) { }

			  new Login_Mainframe();

			}
	

}
