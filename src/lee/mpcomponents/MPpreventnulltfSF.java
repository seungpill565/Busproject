package lee.mpcomponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MPpreventnulltfSF extends JFrame implements ActionListener {
	
	JButton closeBtn = new JButton("닫기");
	
	public MPpreventnulltfSF() {
			
		super("잘못된 비밀번호");
		
		JLabel label = new JLabel("빈 칸을 모두 입력해주세요.");
		
			
		
		// 라벨 설정
		label.setBounds(95, 60, 300, 30);
		add(label);
		
		//닫기 버튼 설정
		closeBtn.setBounds(125, 130, 80, 30);
		
		closeBtn.addActionListener(this);
		add(closeBtn);	
		

		
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setBounds(200, 200, 350, 250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}

}
