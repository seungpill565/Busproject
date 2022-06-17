package an.find;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import an.sign_up.Password_Panel;

public class PassFind_Frame extends JFrame{
	JTextField nameText = new Find_TextField(10);
	JTextField idText = new Find_TextField(10);
	
	public PassFind_Frame() {
		JPanel passMain = new Pass_Mainpanel();
		JPanel all = new Pass_AllPanel(idText,nameText);
		
		JButton button = new Find_Button("찾기");
		JButton button2 = new Find_Button("아이디 찾기");
		JButton out = new Find_Button("나가기");
		
		JPanel buttonPanel = new Pass_ButtonPanel(button, button2,out);
		
		
		add(passMain,BorderLayout.NORTH);
		add(all,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		//////////////////////////////////////////////////////////////////////////
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new IdFind_Frame();
				
			}
		});
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		out.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		
		
		setBounds(610, 200, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);  
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PassFind_Frame();
	}

}
