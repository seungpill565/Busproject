package hong.selectroute;

import java.awt.Color;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

import an.OjdbcConnection;
import an.login.Login_Mainframe;
import an.userinfo.Info_MainFrame;
import hong.BackGroundLabel;
import hong.BeforeButton;
import hong.NextButton;
import hong.SaveInfo;
import hong.selectroute.event.BeforeButtonEvent;
import hong.selectroute.event.DayComboBoxEvent;
import hong.selectroute.event.HomeButtonEvent;
import hong.selectroute.event.MonthComboBoxEvent;
import hong.selectroute.event.NextButtonEvent;
import hong.selectroute.event.SelectArrivalButtonEvent;
import hong.selectroute.event.SelectBusButtonEvent;
import hong.selectroute.event.SelectStartingButtonEvent;
import hong.selectroute.event.SerchButtonEvent;
import hong.selectroute.event.ShowArriveTerminalEvent;
import hong.selectroute.event.ShowStartingTerminalEvent;
import hong.selectseat.SelectSeatMainFrame;

public class SelectRouteMainFrame extends JFrame {
	
	SaveInfo saveInfo;
	
	HomeButton homeButton = new HomeButton();				// 홈 버튼
	StartingPointButton startingPointButton = new StartingPointButton();	// 출발 버튼
	ArrivalButton arrivalButton = new ArrivalButton(); 	// 도착 버튼
	SerchButton serchButton = new SerchButton(); // 조회하기 버튼
	NextButton nextButton = new NextButton();	// 다음 버튼
	BeforeButton beforeButton = new BeforeButton();
	
	MonthComboBox monBox = new MonthComboBox();				// 달 선택 콤보박스
	DayComboBox dayBox = new DayComboBox();					// 일 선택 콤보박스
	
	SelectStartingButtonEvent startingBtnEvent = new SelectStartingButtonEvent(this); // 출발지 선택 버튼 이벤트
	SelectArrivalButtonEvent arrivalBtnEvent = new SelectArrivalButtonEvent(this); // 도착지 선택 버튼 이벤트
	HomeButtonEvent homeBtnEvent = new HomeButtonEvent(this); // 홈 버튼 이벤트
	ShowStartingTerminalEvent showStratingBtnEvent = new ShowStartingTerminalEvent(this); // 출발지들 보여주는 이벤트.
	ShowArriveTerminalEvent showArrivalBtnEvent = new ShowArriveTerminalEvent(this); // 도착지들 보여주는 이벤트.
	MonthComboBoxEvent monthBoxEvent = new MonthComboBoxEvent(this); // 달 선택 콤보박스 이벤트
	DayComboBoxEvent dayBoxEvent = new DayComboBoxEvent(this); // 일 선택 콤보박스 이벤트
	SerchButtonEvent serchBtnEvent = new SerchButtonEvent(this); // 조회하기 버튼 이벤트
	SelectBusButtonEvent selectBusBtnEvent = new SelectBusButtonEvent(this); // 버스 선택해서 예약하기 버튼 이벤트
	NextButtonEvent nextBtnEvent = new NextButtonEvent(this);	// 다음 버튼 이벤트
	BeforeButtonEvent beforeBtnEvent = new BeforeButtonEvent(this);
	
	SelectSeatMainFrame seatMainFrame; // 좌석선택 프레임
	SelectTerminalMainFrame stmFrame;	// 터미널 선택 프레임
	SelectBusFrame busFrame;	// 버스 선택 프레임
	
	private String startingPoint;
	private String arrivalPoint;
	private int month;
	private int day;
	private int rt_id;
	private int bi_id;
	private String bi_time;
	
	// 달에 따른 day들을 일 선택 콤보박스에 추가하는 메서드
	public void addDays(int month) {
		dayBox.addItems(month);
	}
	
	// 일 선택 콤보박스를 비워주는 메서드
	public void resetDays() {
		dayBox.reset();
	}
		
	// 출발지를 선택하면 버튼 이름을 출발지로(ex:동서울) 바꿔준다
	public void departFrom(String starting) {
		startingPointButton.setTextStpBtn(starting);
	}
		
	// 출발지를 선택하면 출발지를 입력받는다.
	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}
	
	// 도착지를 선택하면 버튼 이름을 출발지로(ex:부산) 바꿔준다
	public void arriveAt(String destination) {
		arrivalButton.setTextArvBtn(destination);
		
	}
		
	// 도착지를 선택하면 도착지를 입력받는다.
	public void setArrivalPoint(String arrivalPoint) {
		this.arrivalPoint = arrivalPoint;
	}
	
	// 출발지 버튼을 누르면 터미널들을 보여주는 메서드. 각각의 터미널 버튼에 액션을 추가해준다.
	public void showStartingTerminals() {
		
		System.out.println(saveInfo.get_user_id());
		stmFrame = new SelectTerminalMainFrame();
		for (JButton btn : stmFrame.getAllBtns()) {
			btn.addActionListener(startingBtnEvent);
		}
	}
	
	// 도착지 버튼을 누르면 터미널들을 보여주는 메서드. 각각의 터미널 버튼에 액션을 추가해준다.
	public void showArriveTerminals() {
		//System.out.println(saveInfo.get_user_id());
		stmFrame = new SelectTerminalMainFrame();
		for (JButton btn : stmFrame.getAllBtns()) {
			btn.addActionListener(arrivalBtnEvent);
		}
	}
		
		
	// 달 입력 받기
	public void setMonth(int month) {
		this.month = month;
	}
		
	// 일 입력 받기
	public void setDay(int day) {
		this.day = day;
	}
		
	// 출발지나 도착지를 선택하면 그 창만 닫아준다.
	public void stmFlameClose() {
		stmFrame.dispose();
	}
	
	// 노선, 날짜에 맞는 버스들의 정보를 보여주는 메서드
	public void showBus() {
		busFrame = new SelectBusFrame();
		busFrame.showBusInfo(rt_id, month, day);
		busFrame.getCanReserve();
		busFrame.addInfo();
		
		for (JButton btn : busFrame.getAllBtns()) {
			btn.getName();
			btn.addActionListener(selectBusBtnEvent);
		}
	}
	
	public void setBusID(int bi_id) {
		this.bi_id = bi_id;
	}
	
	// 버스 선택 프레임 꺼주기
	public void busFrameClose() {
		busFrame.dispose();
	}
	
	// 좌석 선택 프레임을 보여줄 메서드
	public void showSeatFrame() {
		seatMainFrame = new SelectSeatMainFrame(saveInfo);	
	}
	
	public void before() {
		new Info_MainFrame(saveInfo);
	}
	
	// 이 프레임 꺼주기
	public void thisFrameClose() {
		this.dispose();
	}
	
	public void save() {
		saveInfo.set_bi_id(bi_id);
		saveInfo.set_rt_id(rt_id); 
		saveInfo.set_depart_from(startingPoint);
		saveInfo.set_arrive_at(arrivalPoint);
		saveInfo.set_date(month, day);
		saveInfo.set_time(bi_time);
	}
	
	
	// 생성자 SaveInfo saveInfo
	public SelectRouteMainFrame(SaveInfo saveInfo) {
		super("버스 예약 시스템");
		
		this.saveInfo = saveInfo;
		
		this.getContentPane().setBackground(new Color(0xFFFFCC));
		// FlowLayout으로 설정 / gap 10 , 30
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 30));
		
		// 홈버튼 액션달고 레이아웃에 붙이기
		homeButton.addActionListener(homeBtnEvent);
		add(homeButton);
		// 나중에 이미지넣을..?
		add(new BackGroundLabel("", 370, 100));
		
		// 출발지 버튼 액션달고 붙이기
		startingPointButton.addActionListener(showStratingBtnEvent);
		add(startingPointButton);
		add(new BackGroundLabel("=>", 60, 200));
		
		// 도착지 버튼
		arrivalButton.addActionListener(showArrivalBtnEvent);
		add(arrivalButton);
		//add(new BackGroundLabel("", 560, 10));
		add(new BackGroundLabel("출발 날짜 :",80, 30));
		
		// 월 선택 콤보박스
		monBox.addItemListener(monthBoxEvent);
		add(monBox);
		add(new BackGroundLabel("월", 60, 30));
		
		// 일 선택 콤보박스
		dayBox.addItemListener(dayBoxEvent);
		add(dayBox);
		add(new BackGroundLabel("일", 30, 30));
		//add(new BackGroundLabel("", 560, 10));
		
		// 조회하기 버튼
		serchButton.addActionListener(serchBtnEvent);
		add(serchButton);
		
		
		add(new BackGroundLabel("", 150, 30));
		
		// 다음 프레임으로 넘어가는 버튼
		nextButton.addActionListener(nextBtnEvent);
		add(nextButton);
		
		add(new BackGroundLabel("", 30, 30));
		
		beforeButton.addActionListener(beforeBtnEvent);
		add(beforeButton);
		
		setBounds(300, 100, 600, 650);
		//getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Login_Mainframe();
	}
	
	
	// 출발지 도착지에 따른 노선ID를...
	public void getRouteID() {
		String sql = "SELECT rt_id FROM bus_route WHERE rt_depart_from=? AND rt_arrive_at=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){	
			pstmt.setString(1, startingPoint);
			pstmt.setString(2, arrivalPoint);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				this.rt_id = rs.getInt("rt_id");			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 해당 bi_id 의 출발 시간은??
	public void getTime() {
		String sql = "SELECT bi_time FROM bus_info WHERE bi_id=?";
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){	
			pstmt.setInt(1, bi_id);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				this.bi_time = rs.getString("bi_time");				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
