package park;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import park.panel.HomeBeforeBtnPanel;
import park.scrollpane.PayInfoScrollpane;
import park.table.PayInfoTable;


public class PayInfo extends JFrame{
	// 레이아웃 널로 만들고 위에서부터 flow, table, label, combobox, button 
	static String[][] rowData = { // test용 배열
			{"20220616", "동서울", "부산", "1750", "01"},
			{"20220616", "동서울", "부산", "1750", "02"},
	};
	static String[] columnNames = {"날짜", "출발지", "도착지", "시간", "좌석번호"};
	
	static HomeBeforeBtnPanel panel1 = new HomeBeforeBtnPanel(); // 홈버튼, 이전버튼이 들어가는 판넬 
	//static PayInfoScrollpane piScrollPane = new PayInfoScrollpane(rowData, columnNames); // 테이블 출력할 스크롤패인
	static PayInfoTable table = new PayInfoTable(rowData, columnNames);	
	static JScrollPane scroll = new JScrollPane(table);
	
	public PayInfo() {
		super("결제 화면");
		//LayoutManager manager = new GridLayout(5,1);
		
		// jcombo.getSelectedItem().toString() // 콤보박스에서 고른 아이템을 스트링으로 뽑아줌
		//panel1.setBounds(50, 50, 100, 100);
		add(panel1, "South"); // 홈버튼, 이전버튼 판넬
		add(scroll, "Center"); // 좌석정보 출력하는 테이블
	
		//setLayout(manager);
		setResizable(false);
		setBounds(100,100,500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new PayInfo();
	}

}
