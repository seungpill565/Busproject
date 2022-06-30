package lee.mpcomponents;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MPnavPanel extends JPanel {
	
	ImageIcon img1 = new ImageIcon("image/내정보1.png");
	ImageIcon img2 = new ImageIcon("image/내정보2.png");
	ImageIcon img3 = new ImageIcon("image/예매내역1.png");
	ImageIcon img4 = new ImageIcon("image/예매내역2.png");
	ImageIcon img5 = new ImageIcon("image/계정탈퇴1.png");
	ImageIcon img6 = new ImageIcon("image/계정탈퇴2.png");
	
	
	// 나머지 버튼은 누르면 각 버튼에 해당하는 패널들이 MP메인프레임에 뜨도록
	JButton MPprofileBtn = new JButton("내 정보", img1);
	JButton MPreservationBtn = new JButton("예매 확인", img3);
	JButton MPleaveBtn = new JButton("계정 탈퇴", img5);
	
	GridLayout gl = new GridLayout(3, 1);
	
	public MPnavPanel() {
	
		setLayout(gl);
		
		//버튼 테두리 없애기
		MPprofileBtn.setBorderPainted(false);
		MPreservationBtn.setBorderPainted(false);
		MPleaveBtn.setBorderPainted(false);
		
		//버튼 배경색 투명하게
		MPprofileBtn.setContentAreaFilled(false);
		MPreservationBtn.setContentAreaFilled(false);
		MPleaveBtn.setContentAreaFilled(false);
		
		//클릭했을 때 네모 모양 생기는 거 없애기 
		MPprofileBtn.setFocusPainted(false);
		MPreservationBtn.setFocusPainted(false);
		MPleaveBtn.setFocusPainted(false);
		
		//마우스 올렸을 때 버튼 이미지 바꾸기 
		MPprofileBtn.setRolloverIcon(img2);
		MPreservationBtn.setRolloverIcon(img4);
		MPleaveBtn.setRolloverIcon(img6);
		
		add(MPprofileBtn);
		add(MPreservationBtn);
		add(MPleaveBtn);
		
		//버튼둘 이미지 크기는 150 * 40 픽셀
		setBounds(0, 120, 150, 120);
		setVisible(true);
		setOpaque(false);
	}
	
}
