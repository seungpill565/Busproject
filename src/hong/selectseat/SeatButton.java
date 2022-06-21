package hong.selectseat;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class SeatButton extends JButton {
	
	private int seat_id;
	private Dimension dimension = new Dimension(90,69);
	private int is_reserved;
	
	public SeatButton() {
		setPreferredSize(dimension);
	}
	
	public void set_seat_id(int seat_id) {
		this.seat_id = seat_id;
	}
	
	public void set_is_reserved(int is_reserved) {
		this.is_reserved = is_reserved;
	}
	
	public void setSeatName(String seatName) {
		setText(seatName);
	}
	
	public int get_is_reserved() {
		return is_reserved;
	}
	
	public void btn_break() {
		setBackground(Color.BLACK);
		setEnabled(false);
		setText("");
	}
	
}
