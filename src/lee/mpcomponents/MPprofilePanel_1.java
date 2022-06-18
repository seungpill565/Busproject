package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MPprofilePanel_1 extends JPanel {

	JLabel MPprofileLb = new JLabel("내 정보들 좌라락 (디비에서 긁어오기) "); //구구단 HTML로 줄바꿈했던 거 참고
	
	JButton MPeditBtn = new JButton("수정하기");
	
	public MPprofilePanel_1() {	 
		
		setLayout(null);
		 
		
		
		
		//프로필라벨 설정
		MPprofileLb.setOpaque(true);//나중에 삭제 
		MPprofileLb.setBackground(Color.PINK);
		MPprofileLb.setFont(new Font("궁서체", Font.PLAIN, 20)); //나중에 통일
		MPprofileLb.setBounds(65, 30, 390, 350);
		
		
		//수정하기 버튼 설정
		MPeditBtn.setBounds(400, 400, 90, 38);
		MPeditBtn.setBorderPainted(false);
		
		
		add(MPprofileLb);
		add(MPeditBtn);		
	}
	
}
