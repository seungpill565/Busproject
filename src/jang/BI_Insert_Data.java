package jang;

public class BI_Insert_Data {
	int bi_id;
	int rtfk_id;
	String bi_day, bi_time;
	
	public BI_Insert_Data() {
		
	}
	
	public BI_Insert_Data (String bi_day, String bi_time, int rtfk_id) {
		this.rtfk_id = rtfk_id;
		this.bi_day = bi_day;
		this.bi_time = bi_time;
	}
	
	public int getBI_ID() {
		return bi_id;
	}
	public int getRTFK_ID() {
		return rtfk_id;
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
	public void setRTFK_ID(int rtfk_id) {
		this.rtfk_id = rtfk_id;
	}
	public void setDay(String bi_day) {
		this.bi_day = bi_day;
	}
	public void setTime(String bi_time) {
		this.bi_time = bi_time;
	}


}
