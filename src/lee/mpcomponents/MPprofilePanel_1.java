package lee.mpcomponents;

import java.awt.Font;

import javax.swing.JPanel;

import lee.RoundedButton;

public class MPprofilePanel_1 extends JPanel {
	
	RoundedButton MPeditBtn = new RoundedButton("수정하기");
	
	public MPprofilePanel_1() {

		setLayout(null);
		
		//수정하기 버튼 설정
		MPeditBtn.setBounds(350, 200, 90, 35);
		MPeditBtn.setFont(new Font("휴먼편지체", Font.BOLD, 17));
		
		add(MPeditBtn);		
	}
	
}
