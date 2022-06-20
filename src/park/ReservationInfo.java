package park;

import java.util.LinkedHashMap;
import java.util.Set;

public class ReservationInfo { // 인스턴스 예시 클래스

	static public String userId;
	static public String depart;
	static public String arrive;
	static public String price;
	static public String date;
	static public String time;
	static public LinkedHashMap<String, String> seatName = new LinkedHashMap<>();
	static public String payWay;
	static public int totalCharge=0;
	
	public ReservationInfo() {
		seatName.put("1", "0");
		seatName.put("4", "0");
		depart = "동서울";
		arrive = "부산";
		price = "20000";
		date = "2022/06/20";
		time = "17:50";
	}
	
	public static int getTotalCharge() { // price * seatName.get(key) + price * seatName.get(key)
		Set<String> keys = seatName.keySet();
		
		for(String key : keys) { // 키 아니고 밸류 꺼내야됨
			totalCharge += price*key;
		}
		
		return 
	}
}
