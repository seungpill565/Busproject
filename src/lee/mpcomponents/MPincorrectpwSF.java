package lee.mpcomponents;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import lee.RoundedButton;

public class MPincorrectpwSF extends JFrame implements ActionListener{
	RoundedButton closeBtn = new RoundedButton("닫기");	
	
	public MPincorrectpwSF() {
		super("잘못된 비밀번호");
		
		JLabel label = new JLabel("<html><pre>잘못된 비밀번호입니다.<br> 다시 입력해주세요.</pre></html>");

		// 라벨 설정
		label.setBounds(110, 60, 300, 30);
		add(label);
		
		//닫기 버튼 설정
		closeBtn.setBounds(125, 130, 90, 35);
		closeBtn.setFont(new Font("휴먼편지체", Font.BOLD, 17));
		closeBtn.addActionListener(this);
		add(closeBtn);	
		
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setSize(350,250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}	
}
