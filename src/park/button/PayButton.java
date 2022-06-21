package park.button;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import park.ReservationInfo;
import park.frame.PayInfo;

public class PayButton extends JButton{

	CardLayout cardLayoutManager;

	
	public PayButton(CardLayout cl) {
		cardLayoutManager = cl;
	}
	
	public PayButton(ReservationInfo user) {
		super("결제 하기");
		setBounds(190, 500, 100, 50);
		
		addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//cardLayoutManager.next(getParent());
				String str =String.format("결제 금액 : %d\n결제 수단 : %s\n결제 하시겠습니까?", (int)(user.getTotalCharge()), user.payWay);
				int ok =JOptionPane.showConfirmDialog(null, str, "결제 확인", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(ok==JOptionPane.OK_OPTION) { // ok를 누르면
					new PayInfo(user);
				}else { // ok 이외의 것을 누르면
					user.setTotalCharge(); // 결제 팝업에서 취소한 것이므로 총요금을 초기화 해준다
					
				}
				
			}
		});
	}
}
