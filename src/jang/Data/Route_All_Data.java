package jang.Data;

public class Route_All_Data {
	
	int bi_id;
	int rt_id;
	int bs_id;
	String bi_day, bi_time;
	String rt_depart_from, rt_arrive_at, rt_charge;
	String bs_name;
	
	public Route_All_Data() {
		
	}
	
	public Route_All_Data
	(int bi_id, int rt_id, int bs_id, 
	String bi_day, String bi_time, 
	String rt_depart_from, String rt_arrive_at, String rt_charge, 
	String bs_name) {
		this.bi_id = bi_id;
		this.rt_id = rt_id;
		this.bs_id = bs_id;
		this.bi_day = bi_day;
		this.bi_time = bi_time;
		this.rt_depart_from = rt_depart_from;
		this.rt_arrive_at = rt_arrive_at;
		this.rt_charge = rt_charge;
		this.bs_name = bs_name;
	}
	
	public int getBI_ID() {
		return bi_id;
	}
	public int getRT_ID() {
		return rt_id;
	}
	public int getBS_ID() {
		return bs_id;
	}
	public String getDay() {
		return bi_day;
	}
	public String getTime() {
		return bi_time;
	}
	public String getDepart() {
		return rt_depart_from;
	}
	public String getArrive() {
		return rt_arrive_at;
	}
	public String getCharge() {
		return rt_charge;
	}
	public String getBS_Name() {
		return bs_name;
	}
	
	public void setBI_ID(int bi_id) {
		this.bi_id = bi_id;
	}
	public void setRT_ID(int rt_id) {
		this.rt_id = rt_id;
	}
	public void setBS_ID(int bs_id) {
		this.bs_id = bs_id;
	}
	public void setDay(String bi_day) {
		this.bi_day = bi_day;
	}
	public void setTime(String bi_time) {
		this.bi_time = bi_time;
	}
	public void setDepart(String rt_depart_from) {
		this.rt_depart_from = rt_depart_from;
	}
	public void setArrive(String rt_arrive_at) {
		this.rt_arrive_at = rt_arrive_at;
	}
	public void setCharge(String rt_charge) {
		this.rt_charge = rt_charge;
	}
	public void setBS_Name(String bs_name) {
		this.bs_name = bs_name;
	}

}
