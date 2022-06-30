package lee.mpcomponents;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import lee.RoundedButton;

public class MPleavecompleteSF extends JFrame {

	RoundedButton yesBtn = new RoundedButton("예");
	
	public MPleavecompleteSF() {
		super("탈퇴 완료");
		
		JLabel label = new JLabel("<html><pre>     탈퇴 완료.<br>홈화면으로 이동합니다.</pre></html>");
		
		//탈퇴완료 라벨 설정
		label.setBounds(80, 40, 300, 30);
		add(label);
		
		//예 버튼 설정
		yesBtn.setBounds(95, 90, 90, 35);
		yesBtn.setFont(new Font("휴먼편지체", Font.BOLD, 17));
		add(yesBtn);
		
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setSize(300,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
