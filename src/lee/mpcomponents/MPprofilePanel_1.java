package lee.mpcomponents;

import javax.swing.JButton;
import javax.swing.JPanel;

import hong.SaveInfo;

public class MPprofilePanel_1 extends JPanel {
	
	JButton MPeditBtn = new JButton("수정하기");
	
	public MPprofilePanel_1() {

		setLayout(null);
		
		//수정하기 버튼 설정
		MPeditBtn.setBounds(400, 400, 90, 38);
		MPeditBtn.setBorderPainted(false);
		
		add(MPeditBtn);		
	}
	
}
