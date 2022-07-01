package hong.selectseat;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class SeatButton extends JButton {
	
	private int bs_id;
	private Dimension dimension = new Dimension(90,69);
	private int is_reserved;
	private boolean is_selected = false;
	
	public SeatButton() {
		setBackground(Color.WHITE);
		setPreferredSize(dimension);
	}
	
	public void set_seat_id(int bs_id) {
		this.bs_id = bs_id;
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
	
	public int get_bs_id() {
		return bs_id;
	}
	
	public boolean get_is_selected() {
		return is_selected;
	}
	
	public void btn_break() {
		setBackground(Color.BLACK);
		setEnabled(false);
		setText("");
	}
	
	public void selectedCheck() {
		
		if(!is_selected) {
			setBackground(new Color(0x95C695));
			is_selected = true;
		} else {
			setBackground(Color.WHITE);
			is_selected = false;
		}
		
	}
	
}
