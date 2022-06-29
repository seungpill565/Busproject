package jang.Data;

public class Seat_Data {
	int rt_id, bi_id;
	
	public Seat_Data(int rt_id, int bi_id) {
		this.rt_id = rt_id;
		this.bi_id = bi_id;
	}
	
	public int getRT_ID() {
		return rt_id;
	}
	public int getBI_ID() {
		return bi_id;
	}
	public void setRT_ID(int rt_id) {
		this.rt_id = rt_id;
	}
	public void setBI_ID(int bi_id) {
		this.bi_id = bi_id;
	}

}
