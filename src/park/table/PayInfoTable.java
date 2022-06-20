package park.table;

import javax.swing.JTable;

import park.ReservationInfo;

public class PayInfoTable extends JTable {
	static ReservationInfo user;
	static String[][] rowData = {
			{user.date,user.depart,user.time,user.seatName}	// 이것도 클래스 하나 만들어줘야됨
	};
	static String[] columnNames = {"날짜", "출발지","도착지","시간","좌석번호","기본가격"};


	public PayInfoTable(ReservationInfo user) {
		this.user = user;
		super(setRowData(user.seatName.size()),columnNames ); // 이거 어떡하지
		getTableHeader().setReorderingAllowed(false); // 컬럼 이동 불가
		setEnabled(false); // 테이블 내용 수정 불가
	}

	public static String[][] setRowData(int size) {
		String[][] rowData;
		for(int i=0;i<size;i++) {
			//rowData = 

			return ;
		}

	}
}

//	static String[][] rowData = { // test용 배열
//			{"20220616", "동서울", "부산", "1750", "01"},
//			{"20220616", "동서울", "부산", "1750", "02"},
//	};
//	static String[] columnNames = {"날짜", "출발지", "도착지", "시간", "좌석번호"};

