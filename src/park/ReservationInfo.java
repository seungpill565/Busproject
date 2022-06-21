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
	static public LinkedHashMap<String, Double> seatName = new LinkedHashMap<>(); // 할인율을 더블로 받는거랑
//	static public LinkedHashMap<String, String> seatName = new LinkedHashMap<>(); // 스트링으로 받아서 파싱하는 방법 두개 있음
	static public String payWay;
	static public double totalCharge=0; // 할인율 곱할 때 소수로 곱하기 때문에 double로

	public ReservationInfo() {
		seatName.put("1", 0.7);
		seatName.put("4", 0.85);
		depart = "동서울";
		arrive = "부산";
		price = "20000";
		date = "2022/06/20";
		time = "17:50";
	
	}

	public static double getTotalCharge() { // price * seatName.get(key) + price * seatName.get(key)
		Set<String> keys = seatName.keySet();

		for(String key : keys) { // 키 아니고 밸류 꺼내야됨
			//totalCharge += Integer.parseInt(price)*(Double.parseDouble(seatName.get(key))); // 가격(정수화) * 키 값 한개씩 뽑아서 각 키의 밸류(실수화)
			totalCharge += Integer.parseInt(price)*seatName.get(key);
		}
		return totalCharge;
	}
	
	public static void setTotalCharge() {
		totalCharge = 0;
	}
//	public static void main(String[] args) {
//		System.out.println(new ReservationInfo().getTotalCharge());
//	}
}
