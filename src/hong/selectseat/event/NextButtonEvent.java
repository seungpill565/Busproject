package hong.selectseat.event;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import hong.selectseat.SelectSeatMainFrame;

public class NextButtonEvent extends SeatMainFramAction{
	
	public NextButtonEvent(SelectSeatMainFrame main) {
		super(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		main.putSeat();
		if (main.getSelectCnt() == 0) {
			JOptionPane.showMessageDialog(null, "좌석을 한자리 이상 선택해주세요!", "좌석 확인", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		main.nextFrame();
		main.thisClose();
	}
}
