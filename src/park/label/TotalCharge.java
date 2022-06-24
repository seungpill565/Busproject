package park.label;

import javax.swing.JLabel;

import park.ReservationInfo;

public class TotalCharge extends JLabel{
	
	
	public TotalCharge(ReservationInfo user) {
		super("결제 금액 : "+user.getTotalCharge());
	}

}
