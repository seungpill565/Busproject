package park.button;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import park.ReservationInfo;
import park.frame.Pay;

public class BeforePayInfoButton extends JButton{ // 이전 화면으로 가는 버튼

	public BeforePayInfoButton(ReservationInfo user) {
	super("Before");
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("before버튼 클릭"); // 테스트용
				new Pay(user);
			}
		});
		
		setSize(40, 40);
		setFont(new Font("궁서체", Font.BOLD,15));
		setForeground(new Color(0x000000));
		setBackground(new Color(0xffff00));		
	}
	
}
