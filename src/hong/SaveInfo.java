package hong;

import java.util.HashMap;

public class SaveInfo {
	
	private int bi_id;
	private int rt_id;
	private HashMap<Integer, Double> bs_id_map = new HashMap<>();
	private String user_id;
	private String depart_from;
	private String arrive_at;
	private String bi_time;
	private String bi_day;
	
	public void set_bi_id(int bi_id) {
		this.bi_id = bi_id;
	}
	
	public void set_rt_id(int rt_id) {
		this.rt_id = rt_id;
	}
	
	public void set_depart_from(String depart_from) {
		this.depart_from = depart_from;
	}
	
	public void set_arrive_at(String arrive_at) {
		this.arrive_at = arrive_at;
	}
	
	public void set_user_id(String user_id) {
		this.user_id = user_id;
	}
	
	public void set_date(int month, int day) {
		this.bi_day = String.format("22/%02d/%02d", month, day);
	}
	
	public int get_bi_id() {
		return bi_id;
	}
	
	public String get_user_id() {
		return user_id;
	}
	
	public void put_bs_id(int bs_id) { 
		this.bs_id_map.put(bs_id, null);
	}
	
	public void remove_bs_id(int bs_id) {
		this.bs_id_map.remove(bs_id);
	}
}
