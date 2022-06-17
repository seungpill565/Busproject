package an.find;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IdFind_Frame extends JFrame{
	JTextField nameText = new Find_TextField(10);
	JTextField pnText = new Find_TextField(10);
	
	JButton button = new Find_Button("찾기");
	JButton button2 = new Find_Button("비밀번호 찾기");
	JButton out = new Find_Button("나가기");
	
	public IdFind_Frame() {
		
		
		JPanel ipmain = new IdFind_Panel();
		
		
		JPanel idPn = new IdFind_ALLPanel(nameText,pnText);
		
		
		JPanel buttonPanel = new IdFind_ButtonPanel(button,button2,out);
		
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new PassFind_Frame();
				
			}
		});
		
		
		out.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		
		
		
		
		//////////////////////////////////////////////////////
		add(ipmain,BorderLayout.NORTH);
		add(idPn,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		
		
		
		setBounds(610, 200, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);  
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new IdFind_Frame();
		
		
	}

}
