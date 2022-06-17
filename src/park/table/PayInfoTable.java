package park.table;

import javax.swing.JTable;

public class PayInfoTable extends JTable {
	
	public PayInfoTable(String[][] rowData, String[] columnNames) {
		super(rowData, columnNames);
		setEnabled(false); // 테이블 내용 수정 불가
	}
	
//	static String[][] rowData = { // test용 배열
//			{"20220616", "동서울", "부산", "1750", "01"},
//			{"20220616", "동서울", "부산", "1750", "02"},
//	};
//	static String[] columnNames = {"날짜", "출발지", "도착지", "시간", "좌석번호"};
}
