package lee.mpcomponents;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class MPinputpwSF extends JFrame {
	JButton completeBtn = new JButton("입력");	
	JPasswordField inputpwPf = new JPasswordField(25);
	
	public MPinputpwSF() {
		super("비밀번호 입력");
		
		JLabel label = new JLabel("비밀번호를 입력해주세요.");

		// 라벨 설정
		label.setBounds(90, 40, 300, 30);
		label.setFont(new Font("고딕", Font.BOLD, 13));
		add(label);
		
		//입력 버튼 설정
		completeBtn.setBounds(125, 130, 80, 30);
		add(completeBtn);	
		
		inputpwPf.setBounds(85, 80, 170, 30);
		inputpwPf.setEchoChar('●');
		add(inputpwPf);
		
		
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setBounds(200, 200, 350, 250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	

	
	
	public String MPgetPwd(JPasswordField MPnewpwTf) {
		StringBuilder pw = new StringBuilder();	
		char[] secret_pw = MPnewpwTf.getPassword(); 

	    for(char cha : secret_pw){         
	        Character.toString(cha); 
	        pw.append(cha);
	    }
		return pw.toString();
	}
}
