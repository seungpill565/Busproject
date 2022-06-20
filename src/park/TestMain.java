package park;

import park.frame.PayInfo;

public class TestMain { // 모든 프레임 다 돌릴 메인 테스트용
	
	public static void main(String[] args) {
		ReservationInfo test1 = new ReservationInfo();
//		test1.setArrive("부산");
//		test1.setDate("2022/06/20");
//		test1.setDepart("동서울");
//		test1.setPrice(20000);
//		test1.setSeat("21");
//		test1.setTime("1750");
		
		PayInfo payinfo = new PayInfo(test1);
		
		
	}

}
