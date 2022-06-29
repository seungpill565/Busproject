package lee.mpcomponents;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import lee.RoundedButton;

public class MPleaveRealSF extends JFrame implements ActionListener{
	
	RoundedButton yesBtn = new RoundedButton("예");
	RoundedButton noBtn = new RoundedButton("아니오");
	
	public MPleaveRealSF() {
		
		JLabel label = new JLabel("정말 탈퇴하시겠습니까?");
		label.setBounds(100, 60, 300, 30);
		add(label);
		
		yesBtn.setBounds(60, 120, 90, 35);
		yesBtn.setFont(new Font("휴먼편지체", Font.BOLD, 17));
		add(yesBtn);
		
		//아니오 버튼 설정
		noBtn.setBounds(180, 120, 90, 35);
		noBtn.setFont(new Font("휴먼편지체", Font.BOLD, 17));
		add(noBtn);
		noBtn.addActionListener(this); //아니오 버튼 액션은 여기서 바로 넣음
		
		
		setTitle("계정 탈퇴");
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setSize(350,250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	}

	//아니오버튼 액션
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
}
