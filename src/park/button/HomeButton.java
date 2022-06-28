package park.button;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import an.userinfo.Info_MainFrame;
import hong.SaveInfo;
import park.database.LoadRVID;
import park.database.SaveDB;
import park.frame.PayInfo;

public class HomeButton extends JButton{ // 홈 화면으로 가는 버튼

	public HomeButton(SaveInfo user) {
		super("Home");
			
		setSize(40, 40);
		setFont(new Font("궁서체", Font.BOLD,15));
		setForeground(new Color(0x000000));
		setBackground(new Color(0xffff00));
	}
	
	public void removeSeatMap(SaveInfo user) {
		String str = "메인 화면으로 돌아가시겠습니까?";
		int ok =JOptionPane.showConfirmDialog(null, str, "메인 화면", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if(ok==JOptionPane.OK_OPTION) { // ok를 누르면
			try {
				user.remove_bs_map(user.getSeatId(), user.getSeatNames());
			}catch(IndexOutOfBoundsException e1){
				user.remove_bs_map(user.getSeatId(), user.getSeatNames());
			}
			new Info_MainFrame(user);
		}
	}
}
