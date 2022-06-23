package jang;

public class Route_Insert_Data {
	
	int rt_id;
	String rt_depart_from, rt_arrive_at, rt_charge;
	
	public Route_Insert_Data() {
		
	}
	
	public Route_Insert_Data (String rt_depart_from, String rt_arrive_at, String rt_charge) {
		this.rt_depart_from = rt_depart_from;
		this.rt_arrive_at = rt_arrive_at;
		this.rt_charge = rt_charge;
	}
	
	public int getRT_ID() {
		return rt_id;
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
	
	public void setRT_ID(int rt_id) {
		this.rt_id = rt_id;
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
