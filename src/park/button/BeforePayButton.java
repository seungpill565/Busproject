package park.button;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import hong.SaveInfo;
import hong.selectseat.SelectSeatMainFrame;

public class BeforePayButton extends JButton{
	
	public BeforePayButton(SaveInfo user) {
		super("Before");
		
//		addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//System.out.println("before버튼 클릭"); // 테스트용
//				try {
//					user.remove_bs_map(user.getSeatId(), user.getSeatNames());		
//				}catch(IndexOutOfBoundsException a) {
//					user.remove_bs_map(user.getSeatId(), user.getSeatNames());
//				}
//				new SelectSeatMainFrame(user);
//			}
//		});
		
		setSize(40, 40);
		setFont(new Font("궁서체", Font.BOLD,15));
		setForeground(new Color(0x000000));
		setBackground(new Color(0xffff00));		
	}
}
