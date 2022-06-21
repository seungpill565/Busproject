package hong;

public class SaveInfo {
	
	private int bi_id;
	private int bs_id;
	private int rt_id;
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
	
	public void set_bi_time(String time) {
		
	}
	
	public int get_bi_id() {
		return bi_id;
	}
	
}
