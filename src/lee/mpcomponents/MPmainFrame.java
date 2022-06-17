package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MPmainFrame extends JFrame {
	
	JButton MPhomeBtn = new JButton();
	
	MPnavPanel MPnav = new MPnavPanel();
	MPcontentsPanel MPcontents = new MPcontentsPanel();
	
	
	public MPmainFrame() {
		
		setLayout(null);
		
		JLabel MPcategoryLb = new JLabel("카테고리마다 제목 바뀌어야 함");
		MPcategoryLb.setBounds(270, 30, 700, 100);
		MPcategoryLb.setFont(new Font("궁서체", Font.PLAIN, 25));
		
		MPhomeBtn.setBounds(10, 10, 50, 50);
		MPhomeBtn.setBorderPainted(false);
		MPhomeBtn.setBackground(Color.cyan);
		
		
		
		
		
		add(MPcategoryLb);
		add(MPnav);
		add(MPcontents);	
		add(MPhomeBtn);
				
		//프레임 설정
		setTitle("마이페이지");
		getContentPane().setBackground(Color.WHITE);//배경색 나중에 맞추기		
		setBounds(0, 0, 900, 650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MPmainFrame();
	}
}
