package jang;

public class Businfo_Data {
	int bi_id;
	int rt_id;
	String bi_day, bi_time;
	
	public Businfo_Data() {
		
	}
	
	public Businfo_Data
	(int bi_id, String bi_day, String bi_time, int rt_id) {
		this.bi_id = bi_id;
		this.rt_id = rt_id;
		this.bi_day = bi_day;
		this.bi_time = bi_time;
	}
	
	public int getBI_ID() {
		return bi_id;
	}
	public int getRT_ID() {
		return rt_id;
	}
	public String getDay() {
		return bi_day;
	}
	public String getTime() {
		return bi_time;
	}
	
	public void setBI_ID(int bi_id) {
		this.bi_id = bi_id;
	}
	public void setRT_ID(int rt_id) {
		this.rt_id = rt_id;
	}
	public void setDay(String bi_day) {
		this.bi_day = bi_day;
	}
	public void setTime(String bi_time) {
		this.bi_time = bi_time;
	}


}
