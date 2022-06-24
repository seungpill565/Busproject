package park;

import java.util.LinkedHashMap;
import java.util.Set;

public class ReservationInfo { // 인스턴스 예시 클래스

	static private String userId;
	static private Integer busId;
	static private Integer seatId;
	static private Integer reservationId;
	static private String depart;
	static private String arrive;
	static private String price;
	static private String date;
	static private String time;
	static private LinkedHashMap<String, Double> seatName = new LinkedHashMap<>(); // 할인율을 더블로 받는거랑
	//	static private LinkedHashMap<String, String> seatName = new LinkedHashMap<>(); // 스트링으로 받아서 파싱하는 방법 두개 있음
	static private String payWay;
	static private String age;
	static private double totalCharge=0; // 할인율 곱할 때 소수로 곱하기 때문에 double로

	public ReservationInfo() {
		seatName.put("1", 0.7);
		seatName.put("4", 0.85);
		depart = "동서울";
		arrive = "부산";
		price = "20000";
		date = "2022/06/20";
		time = "17:50";
	
	}
	
	public static Integer getBusId() {
		return busId;
	}
	
	public static Integer getReservationId() {
		return reservationId;
	}
	
	public static Integer getSeatId() {
		return seatId;
	}
	
	public static void setBusId(Integer busId) {
		ReservationInfo.busId = busId;
	}
	
	public static void setReservationId(Integer reservationId) {
		ReservationInfo.reservationId = reservationId;
	}
	
	public static void setSeatId(Integer seatId) {
		ReservationInfo.seatId = seatId;
	}
	
	public static String getAge() {
		return age;
	}

	public static void setAge(String age) {
		ReservationInfo.age = age;
	}

	public static String getUserId() {
		return userId;
	}




	public static void setUserId(String userId) {
		ReservationInfo.userId = userId;
	}




	public static String getDepart() {
		return depart;
	}




	public static void setDepart(String depart) {
		ReservationInfo.depart = depart;
	}




	public static String getArrive() {
		return arrive;
	}




	public static void setArrive(String arrive) {
		ReservationInfo.arrive = arrive;
	}




	public static String getPrice() {
		return price;
	}




	public static void setPrice(String price) {
		ReservationInfo.price = price;
	}




	public static String getDate() {
		return date;
	}




	public static void setDate(String date) {
		ReservationInfo.date = date;
	}




	public static String getTime() {
		return time;
	}




	public static void setTime(String time) {
		ReservationInfo.time = time;
	}




	public static LinkedHashMap<String, Double> getSeatName() {
		return seatName;
	}




	public static void setSeatName(LinkedHashMap<String, Double> seatName) {
		ReservationInfo.seatName = seatName;
	}




	public static String getPayWay() {
		return payWay;
	}




	public static void setPayWay(String payWay) {
		ReservationInfo.payWay = payWay;
	}




	public static void setTotalCharge(double totalCharge) {
		ReservationInfo.totalCharge = totalCharge;
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
//	private static void main(String[] args) {
//		System.out.println(new ReservationInfo().getTotalCharge());
//	}
}
