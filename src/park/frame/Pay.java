package park.frame;

import java.awt.Color;

import javax.swing.JFrame;

import park.ReservationInfo;
import park.button.PayButton;
import park.combobox.SelectPayWayBox;
import park.label.RouteInfoLabel;
import park.panel.HomeBeforeBtnPanel;
import park.panel.RouteInfoPanel;
import park.panel.SelectSeatAgePanel;
import park.scrollpane.PayInfoScrollpane;


public class Pay extends JFrame{
	// 레이아웃 널로 만들고 위에서부터 flow, table, label, combobox, button 
	static ReservationInfo user;
//	static String[][] rowData ; // 예매 정보들
//	static String[] columnNames = {"날짜", "출발지", "도착지", "시간", "좌석번호"};
	static HomeBeforeBtnPanel panel1 = new HomeBeforeBtnPanel(user); // 홈버튼, 이전버튼이 들어가는 판넬 (플로우레이아웃)
	//static PayInfoTable table = new PayInfoTable(user);	// 좌석정보 테이블
	//static JScrollPane scroll = new JScrollPane(table); // 좌석정보 테이블 담는 스크롤
	static SelectSeatAgePanel seatPanel ; // 좌석별 연령대 고를 콤보박스 들어있는 판넬
	static PayButton payBtn = new PayButton(user); // 결제하기 버튼
	static SelectPayWayBox payWayBox = new SelectPayWayBox(user); // 결제 방식 고르는 콤보박스
	static RouteInfoLabel route = new RouteInfoLabel(); // 행선지 정보 
	static RouteInfoPanel routePanel = new RouteInfoPanel(user); // 행선지 정보 표 형태로 보여줄 패널
	static PayInfoScrollpane scroll = new PayInfoScrollpane(); 
	
	
	public Pay(ReservationInfo user) {
		super("결제 화면");
		user.setSeatId(); // 해쉬맵에 있는 좌석이름 어레이리스트에 넣기
		user.setSeatNames();
		this.user = user;
		
		// 접속 상태 유지하기위해서 다 매개변수로 받아온 user로 초기화 해줌
		seatPanel = new SelectSeatAgePanel(user); // 패널 초기화 해주면서 user 정보 계속 유지해야해서 매개변수로 넘겨준다
		panel1 = new HomeBeforeBtnPanel(user);
		payBtn = new PayButton(user);
		payWayBox = new SelectPayWayBox(user);
			
		//scroll.setViewportView(route);
	
		add(panel1); // 홈버튼, 이전버튼 판넬
		add(route); // 행선지 정보
		add(scroll);
		//add(routePanel); // 행선지 정보 표 표시할 판넬
		add(seatPanel); // 좌석별 연령 고르는 콤보박스
		add(payWayBox); // 결제 수단 고를 콤보 박스
		add(payBtn); // 결제하기 버튼
	
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setResizable(false);
		setBounds(100,100,500,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Pay(new ReservationInfo());
	}

}
