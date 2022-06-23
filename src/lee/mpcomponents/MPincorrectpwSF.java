package lee.mpcomponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MPincorrectpwSF extends JFrame implements ActionListener{
	JButton closeBtn = new JButton("닫기");	
	
	public MPincorrectpwSF() {
		super("잘못된 비밀번호");
		
		JLabel label = new JLabel("<html>잘못된 비밀번호입니다.<br>다시 입력해주세요.</html>");

		// 라벨 설정
		label.setBounds(110, 60, 300, 30);
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

	public static void main(String[] args) {
		new MPincorrectpwSF();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
	
}
