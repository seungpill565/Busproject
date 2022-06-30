package lee.mpcomponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MPnamelengthrestrictSF extends JFrame implements ActionListener{

	public MPnamelengthrestrictSF() {
		
		super("입력 오류");
		JButton closeBtn = new JButton("닫기");
		
		JLabel label = new JLabel("이름과 비밀번호는 최대 10글자까지 입력 가능합니다.");
		

		
		// 라벨 설정
		label.setBounds(25, 60, 300, 30);
		add(label);
		
		//닫기 버튼 설정
		closeBtn.setBounds(125, 130, 80, 30);
		
		closeBtn.addActionListener(this);
		add(closeBtn);	
		

		
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setSize(350,250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}	


	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}

}
