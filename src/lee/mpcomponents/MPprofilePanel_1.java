package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MPprofilePanel_1 extends JPanel {

	String MPprofile = "<html><pre style=\"font-family:고딕;\">아이디    : banana123<br><br>이름       : 바나나<br><br>연락처    : 010-1234-1234</pre><html/>";	
	
	JLabel MPprofileLb = new JLabel(MPprofile); //구구단 HTML로 줄바꿈했던 거 참고
	
	JButton MPeditBtn = new JButton("수정하기");
	
	public MPprofilePanel_1() {	 
		
		setLayout(null);
		 

		
		//프로필라벨 설정
		MPprofileLb.setOpaque(true);//나중에 삭제 
		//MPprofileLb.setBackground(Color.PINK);
		MPprofileLb.setFont(new Font("고딕", Font.BOLD, 18)); 
		MPprofileLb.setBounds(50, 50, 390, 200);
		MPprofileLb.setVerticalAlignment(JLabel.TOP);
		
		//수정하기 버튼 설정
		MPeditBtn.setBounds(400, 400, 90, 38);
		MPeditBtn.setBorderPainted(false);
		
		
		add(MPprofileLb);
		add(MPeditBtn);		
	}
	
}
