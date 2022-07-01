package lee.mpcomponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import lee.RoundedButton;

public class MPwarningSF extends JFrame implements ActionListener{
	RoundedButton closeBtn = new RoundedButton("닫기");	
	
	public MPwarningSF(String title, String msg, int x, int y, int width, int height) {
		super(title);
		
		JLabel label = new JLabel(msg);

		// 라벨 설정
		label.setBounds(x, y, width, height);
		add(label);
		
		//닫기 버튼 설정
		closeBtn.setBounds(125, 130, 90, 35);
		closeBtn.setFont(new Font("휴먼편지체", Font.BOLD, 17));
		closeBtn.addActionListener(this);
		add(closeBtn);	
	
		
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setSize(350,250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}	
}
