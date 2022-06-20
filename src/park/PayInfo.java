package park;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import park.button.PayButton;
import park.panel.HomeBeforeBtnPanel;
import park.panel.SelectSeatNumPanel;
import park.table.PayInfoTable;


public class PayInfo extends JFrame{
	// 레이아웃 널로 만들고 위에서부터 flow, table, label, combobox, button 
	static String[][] rowData ; // 예매 정보들
	static String[] columnNames = {"날짜", "출발지", "도착지", "시간", "좌석번호"};
	static HomeBeforeBtnPanel panel1 = new HomeBeforeBtnPanel(); // 홈버튼, 이전버튼이 들어가는 판넬 (플로우레이아웃)
	//static PayInfoTable table = new PayInfoTable(user);	// 좌석정보 테이블
	//static JScrollPane scroll = new JScrollPane(table); // 좌석정보 테이블 담는 스크롤
	static SelectSeatNumPanel seatPanel ; // 좌석별 연령대 고를 콤보박스 들어있는 판넬
	static PayButton payBtn = new PayButton(); // 결제하기 버튼
	static ReservationInfo user;
	
	
	public PayInfo(ReservationInfo user) {
		super("결제 화면");
		this.user = user;
		seatPanel = new SelectSeatNumPanel(user);
		
		//panel1.setBounds(10, 10, 80, 80); // 판넬(플로우레이아웃) 쓸지 버튼 위치 따로 정해줄지 생각해야됨
		//scroll.setBounds(10, 100 , 450, 100);
		
		add(panel1, "South"); // 홈버튼, 이전버튼 판넬
		//add(scroll, "Center"); // 좌석정보 출력하는 테이블
		add(seatPanel);
		add(payBtn);
	
		setLayout(null);
		setResizable(false);
		setBounds(100,100,500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new PayInfo(new ReservationInfo());
	}

}
