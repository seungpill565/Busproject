package jang.Data;

public class Route_Read_Data {
	int bi_id;
	int rt_id;
	String  rt_depart_from,
    rt_arrive_at,
    rt_charge,
    bi_day,
    bi_time;
	public Route_Read_Data() {
		
	}
	
	public Route_Read_Data(int bi_id, int rt_id, String rt_depart_from, String rt_arrive_at, String rt_charge, 
						String bi_day, String bi_time) {
		this.bi_id = bi_id;
		this.rt_id = rt_id;
		this.rt_depart_from = rt_depart_from;
		this.rt_depart_from = rt_depart_from;
		this.rt_arrive_at = rt_arrive_at;
		this.rt_charge = rt_charge;
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
	public String getDepart() {
		return rt_depart_from;
	}
	public String getArrive() {
		return rt_arrive_at;
	}
	public String getCharge() {
		return rt_charge;
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
	public void setDepart(String rt_depart_from) {
		this.rt_depart_from = rt_depart_from;
	}
	public void setArrive(String rt_arrive_at) {
		this.rt_arrive_at = rt_arrive_at;
	}
	public void setCharge(String rt_charge) {
		this.rt_charge = rt_charge;
	}

}
