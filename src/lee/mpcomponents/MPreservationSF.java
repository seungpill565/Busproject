package lee.mpcomponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MPreservationSF extends JFrame implements ActionListener {
	
	JButton yesBtn = new JButton("예");
	
	public MPreservationSF() {
		super("예매취소");
		
		JLabel label = new JLabel("정말 취소하시겠습니까?");
		JButton noBtn = new JButton("아니오");
			
		
		//정말취소? 라벨 설정
		label.setBounds(100, 60, 300, 30);
		add(label);
		
		//예 버튼 설정
		yesBtn.setBounds(60, 130, 80, 30);
		add(yesBtn);
		
		//아니오 버튼 설정
		noBtn.setBounds(190, 130, 80, 30);
		add(noBtn);
		noBtn.addActionListener(this); //아니오 버튼 액션은 여기서 바로 넣음
		
		
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setBounds(200, 200, 350, 250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	
	//아니오버튼 액션
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
	
}
