package park.optionpane;

import javax.swing.JOptionPane;

import park.ReservationInfo;

public class PayCheckOP extends JOptionPane{
	
	public PayCheckOP(ReservationInfo user) {
		showConfirmDialog(null, String.format(" 결제 금액 : %d\n결제 하시겠습니까?", (int)(user.getTotalCharge())), "결제 확인", OK_CANCEL_OPTION, INFORMATION_MESSAGE );
	}
}
