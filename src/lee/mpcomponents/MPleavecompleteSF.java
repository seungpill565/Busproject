package lee.mpcomponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MPleavecompleteSF extends JFrame {

	JButton yesBtn = new JButton("예");
	
	public MPleavecompleteSF() {
		super("탈퇴 완료");
		
		JLabel label = new JLabel("탈퇴 완료. 홈화면으로 이동합니다.");
		
			
		
		//정말취소? 라벨 설정
		label.setBounds(80, 60, 300, 30);
		add(label);
		
		//예 버튼 설정
		yesBtn.setBounds(123, 130, 80, 30);
		add(yesBtn);
		
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setBounds(200, 200, 350, 250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	


}
