package park;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class ReservationInfo { // 인스턴스 예시 클래스

	static private String userId;
	static private Integer busId;
	
	static private ArrayList<Integer> reservationId = new ArrayList<>();; // 좌석당 예매번호 1개고 여러좌석일 수 있으므로 배열로 저장
	static private String depart;
	static private String arrive;
	static private String price;
	static private String date;
	static private String time;
//	static private HashMap<Integer, Double> dcBySeat = new HashMap<>(); // 좌석별 할인률 여기 키값이 좌석 id //팀장님 넘겨주시는거
//	static private HashMap<Integer, String> ageBySeat = new HashMap<>(); // 좌석별 연령
	static private HashMap<Integer, Double> dcBySeat = new HashMap<>(); // 좌석별 할인률 여기 키값이 좌석 id //팀장님 넘겨주시는거
	static private HashMap<Integer, String> ageBySeat = new HashMap<>(); // 좌석별 연령
	static private HashMap<String, Integer> seatNameBySeatId = new HashMap<>();// 좌석이름에 해당하는 좌석 id
	static private ArrayList<Integer> seatId = new ArrayList<>(); // 좌석 id들
	static private ArrayList<String> seatNames = new ArrayList<>(); // 좌석이름 리스트 // 팀장님 넘겨주시는거
	static private String payWay; // 이건 한번 결제할때 같은 수단으로 하니까 배열 x
	//static private String[] age; // 좌석 별 연령이므로 이것도 배열
	static private double totalCharge=0; // 할인율 곱할 때 소수로 곱하기 때문에 double로

	public ReservationInfo() {
		dcBySeat.put(1, null);
		dcBySeat.put(2, null);
		seatNameBySeatId.put("a-21",1);
		seatNameBySeatId.put("a-04",2 );

		depart = "동서울";
		arrive = "부산";
		price = "20000";
		date = "2022/06/20";
		time = "17:50";
		userId = "1";
		payWay = "선택안함";
		busId = 1000;
		
	}
	
//	public static void setSeatNamesBySeatId() { // 좌석 id들 뽑아서 그걸 키 값으로 하고 좌석이름을 리스트에서 불러와서 밸류로 넣는다
//		Set<Integer> keys = dcBySeat.keySet();
//		int i=0;
//		for(Integer key : keys) {
//			seatNameBySeatId.put(key, seatNames.get(i++));
//		}
//		for(int j=0;j<seatNameBySeatId.size();j++)
//			System.out.println(seatNameBySeatId.get(j));
//	}
	
	
	public static void setSeatNames() { 		// 
		Set<String> keys = seatNameBySeatId.keySet();
		for(String key : keys) {
			seatNames.add(key);
		}
			for(int i=0;i<seatNames.size();i++)
				System.out.println(i+"번째 좌석ID "+seatNames.get(i)+"저장");
		
	}
	public static HashMap<String, Integer> getSeatNameBySeatId() {
		return seatNameBySeatId;
	}
	
	public static ArrayList<String> getSeatNames(){
		return seatNames;
	}
	public static void setSeatId() { 
		Set<Integer> keys = dcBySeat.keySet();
		for(Integer key : keys) {
			seatId.add(key);
		}
		for(int i=0;i<seatId.size();i++)
			System.out.println("좌석Id "+seatId.get(i)+"추가");
	}

	public static ArrayList<Integer> getSeatId() {
		return seatId;
	}
	public static int getSeatSize() {
		return dcBySeat.size();
	}
	
	
	public static void setAgeBySeat(Integer seat, String age) {
		ageBySeat.put(seat, age);
	}
	public static HashMap<Integer, String> getAgeBySeat() {
		return ageBySeat;
	}
	
	public static HashMap<Integer, Double> getDcBySeat() {
		return dcBySeat;
	}
	
	
	
	//---------------------------------------------
	public static double getTotalCharge() { // price * dcBySeat.get(key) + price * dcBySeat.get(key)
		Set<Integer> keys = dcBySeat.keySet();
		for(Integer key : keys) { // 키 아니고 밸류 꺼내야됨
			//totalCharge += Integer.parseInt(price)*(Double.parseDouble(dcBySeat.get(key))); // 가격(정수화) * 키 값 한개씩 뽑아서 각 키의 밸류(실수화)
			totalCharge += Integer.parseInt(price)*dcBySeat.get(key);
		}
		return totalCharge;
	}
	
	public static void setTotalCharge() {
		totalCharge = 0;
	}
	
	
	
	
	public static void setReservationId(int rvid) {
		reservationId.add(rvid);
	}

	public static String getUserId() {
		return userId;
	}

	public static void setUserId(String userId) {
		ReservationInfo.userId = userId;
	}

	public static Integer getBusId() {
		return busId;
	}

	public static void setBusId(Integer busId) {
		ReservationInfo.busId = busId;
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

	public static HashMap<Integer, Double> getdcBySeat() {
		return dcBySeat;
	}

	public static void setdcBySeat(LinkedHashMap<Integer, Double> dcBySeat) {
		ReservationInfo.dcBySeat = dcBySeat;
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
	
	
	
	private static void main(String[] args) {
		//new ReservationInfo().setseatNames();
	}
}
