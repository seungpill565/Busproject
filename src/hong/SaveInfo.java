package hong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class SaveInfo {
	
	private String userId;
	private Integer busId;
	private ArrayList<Integer> reservationId = new ArrayList<>(); // 좌석당 예매번호 1개고 여러좌석일 수 있으므로 배열로 저장
	private String depart;
	private String arrive;
	private String price;
	private String date;
	private String time;
	private int rt_id;
	private HashMap<Integer, Double> dcBySeat = new HashMap<>();// 좌석별 할인률
	private HashMap<Integer, String> ageBySeat = new HashMap<>(); // 좌석별 연령
	private HashMap<String, Integer> seatNameBySeatId = new HashMap<>();// 좌석이름에 해당하는 좌석 id
	private ArrayList<Integer> seatId = new ArrayList<>(); // 좌석 id들
	private ArrayList<String> seatNames = new ArrayList<>(); // 좌석이름 리스트 // 팀장님 넘겨주시는거
	private String payWay; // 이건 한번 결제할때 같은 수단으로 하니까 배열 x
	private double totalCharge=0; // 할인율 곱할 때 소수로 곱하기 때문에 double로
	private boolean totalChargeCheck = true;
	
	
//	public void set_seat_name(ArrayList<String> seat_name) {
//		this.seat_name = seat_name;
//	}
	
	public void setTotalChargeCheck(boolean totalChargeCheck) {
		this.totalChargeCheck = totalChargeCheck;
	}
	public boolean isTotalChargeCheck() {
		return totalChargeCheck;
	}
	public void set_price(Integer price) {
		this.price = price.toString();
	}
	
	public void set_bi_id(int bi_id) {
		this.busId = bi_id;
	}
	
	public void set_rt_id(int rt_id) {
		this.rt_id = rt_id;
	}
	
	public void set_depart_from(String depart_from) {
		this.depart = depart_from;
	}
	
	public void set_arrive_at(String arrive_at) {
		this.arrive = arrive_at;
	}
	
	public void set_user_id(String user_id) {
		this.userId = user_id;
	}
	
	public void set_date(int month, int day) {
		this.date = String.format("22/%02d/%02d", month, day);
	}
	
	public void set_time(String time) {
		this.time = time;
	}
	
	public int get_bi_id() {
		return busId;
	}
	
	public String get_user_id() {
		return userId;
	}
	
	public void put_bs_id(int bs_id) { 
		this.dcBySeat.put(bs_id, null);
	}
	
	public void remove_bs_map(ArrayList<Integer> seatId, ArrayList<String> seatName) {
		int size = seatId.size();
		System.out.println(seatId.size());
		System.out.println(dcBySeat.size());
		for(int i= 0 ; i < size; ++i) {
			dcBySeat.remove(seatId.get(i));
			seatNameBySeatId.remove(seatName.get(i));
			this.seatId.remove(i);
			this.seatNames.remove(i);
		}
	}
	
	public void removeIdMap(int bs_id) {
		this.dcBySeat.remove(bs_id);
		
	}
	
	public void removeNameMap(String bs_name) {
		this.seatNameBySeatId.remove(bs_name);
	}
	
	public void put_bs_name(String bs_name, int bs_id) {
		this.seatNameBySeatId.put(bs_name, bs_id);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setSeatNames() { 		// 
		Set<String> keys = seatNameBySeatId.keySet();
		for(String key : keys) {
			seatNames.add(key);
		}
		for(int i=0;i<seatNames.size();i++)
			System.out.println(i+"번째 좌석ID "+seatNames.get(i)+"저장");

	}
	public HashMap<String, Integer> getSeatNameBySeatId() {
		return seatNameBySeatId;
	}
	
	public ArrayList<String> getSeatNames(){
		return seatNames;
	}
	public void setSeatId() { 
		Set<Integer> keys = dcBySeat.keySet();
		for(Integer key : keys) {
			seatId.add(key);
		}
		for(int i=0;i<seatId.size();i++)
			System.out.println("좌석Id "+seatId.get(i)+"추가");
	}

	public ArrayList<Integer> getSeatId() {
		return seatId;
	}
	public int getSeatSize() {
		return dcBySeat.size();
	}
	
	
	public void setAgeBySeat(Integer seat, String age) {
		ageBySeat.put(seat, age);
	}
	public HashMap<Integer, String> getAgeBySeat() {
		return ageBySeat;
	}
	
	public HashMap<Integer, Double> getDcBySeat() {
		return dcBySeat;
	}
	
	public ArrayList<Integer> getReservationId() {
		return reservationId;
	}
	
	//---------------------------------------------
	public double getTotalCharge() { // price * dcBySeat.get(key) + price * dcBySeat.get(key)
		Set<Integer> keys = dcBySeat.keySet();
		for(Integer key : keys) { // 키 아니고 밸류 꺼내야됨
			//totalCharge += Integer.parseInt(price)*(Double.parseDouble(dcBySeat.get(key))); // 가격(정수화) * 키 값 한개씩 뽑아서 각 키의 밸류(실수화)
			totalCharge += Integer.parseInt(price)*dcBySeat.get(key);
		}
		return totalCharge;
	}
	
	public void setTotalCharge() {
		totalCharge = 0;
	}
	public void setTotalCharge2() {
		totalCharge = 1;
	}
	
	public double getTotalCharge2() {
		return totalCharge;
	}
	
	
	public void setReservationId(int rvid) {
		reservationId.add(rvid);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public   String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getArrive() {
		return arrive;
	}

	public void setArrive(String arrive) {
		this.arrive = arrive;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public   String getDate() {
		return date;
	}

	public   void setDate(String date) {
		this.date = date;
	}

	public   String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public HashMap<Integer, Double> getdcBySeat() {
		return dcBySeat;
	}

	public void setdcBySeat(LinkedHashMap<Integer, Double> dcBySeat) {
		this.dcBySeat = dcBySeat;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
	}

	
	
	
}
