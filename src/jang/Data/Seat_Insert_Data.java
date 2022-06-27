package jang.Data;

public class Seat_Insert_Data {
	
	public int bifk_id;
	public int bs_id;
	public String bs_name;
	public String bu_is_reserved;
	
	public Seat_Insert_Data() {
		
	}
	
	public Seat_Insert_Data (String bs_name) {
		this.bifk_id = bifk_id;
		this.bs_name = bs_name;
	}
	
	public int getBI_ID() {
		return bifk_id;
	}
	public int getBS_ID() {
		return bs_id;
	}
	public String getBS_Name() {
		return bs_name;
	}
	public String getReserved() {
		return bu_is_reserved;
	}
	
	public void setBI_ID(int bifk_id) {
		this.bifk_id = bifk_id;
	}
	public void setBS_ID(int bs_id) {
		this.bs_id = bs_id;
	}
	public void setBS_Name(String bs_name) {
		this.bs_name = bs_name;
	}
	public void setReserved(String bu_is_reserved) {
		this.bu_is_reserved = bu_is_reserved;
	}
}
