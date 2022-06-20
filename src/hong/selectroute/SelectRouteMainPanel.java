package hong.selectroute;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import hong.selectroute.event.HomeButtonEvent;
import hong.selectroute.event.MonthComboBoxEvent;
import hong.selectroute.event.SelectArriveButtonEvent;
import hong.selectroute.event.SelectStartingButtonEvent;
import hong.selectroute.event.ShowArriveTerminalEvent;
import hong.selectroute.event.ShowStartingTerminalEvent;

public class SelectRouteMainPanel extends JPanel {
	
	GridBagLayout gbl = new GridBagLayout(); 
	GridBagConstraints gbc = new GridBagConstraints(); 
	HomeButton homeButton = new HomeButton();				// 홈버튼 생성
	StartingPointButton spButton = new StartingPointButton();			// 출발버튼 생성
	ArriveButton arvButton = new ArriveButton(); 	// 도착버튼 생성
	MonthComboBox monBox = new MonthComboBox();				// 달 선택 콤보박스
	DayComboBox dayBox = new DayComboBox();					// 일 선택 콤보박스
	SelectTerminalMainFrame stmFrame;
	SelectStartingButtonEvent ssbe = new SelectStartingButtonEvent(this); // 출발지 선택 버튼 이벤트
	SelectArriveButtonEvent sabe = new SelectArriveButtonEvent(this); // 도착지 선택 버튼 이벤트
	
	
	// 달에 따른 day들을 일 선택 콤보박스에 추가하는 메서드
	public void addDays(int month) {
		dayBox.addItems(month);
	}
	
	// 일 선택 콤보박스를 비워주는 메서드
	public void resetDays() {
		dayBox.reset();
	}
	
	// 선택한 날짜를 저장해둠
	public void inputDay(int day) {
		dayBox.setDay(day);
	}
	
	// 선택한 달을 저장해둠
	public void inputMonth(int month) {
		monBox.setMonth(month);
	}
	
	public void departFrom(String starting) {
		spButton.setStarting(starting);
	}
	
	public void arriveAt(String destination) {
		arvButton.setDestination(destination);
	}
	
	public void showStartingTerminals() {
		stmFrame = new SelectTerminalMainFrame();
		for (JButton btn : stmFrame.getAllBtns()) {
			btn.addActionListener(ssbe);
		}
	}
	
	public void showArriveTerminals() {
		stmFrame = new SelectTerminalMainFrame();
		for (JButton btn : stmFrame.getAllBtns()) {
			btn.addActionListener(sabe);
		}
	}
	
	public void flameClose() {
		stmFrame.dispose();
	}
	
	public SelectRouteMainPanel() {
		// layout을 GridBagLayout으로 설정
		setLayout(gbl);
		
		gbc.fill= GridBagConstraints.BOTH;

		// GridBagLayout 활용하기
		// 1열 시작
		gbc.weighty = 0.07;
		gbInsert(new BackGroundLabel(), 0, 0, 7, 1);
		
		// 2열 시작
		gbc.weighty = 0.2;
		gbc.weightx = 0.5;
		gbInsert(new BackGroundLabel(), 0, 1, 1, 1);
		gbInsert(new BackGroundLabel(), 6, 1, 1, 1);
		
		// 2열 홈버튼
		HomeButtonEvent hbe = new HomeButtonEvent(this);
		homeButton.addActionListener(hbe);
		gbc.weighty = 0.1;
		gbInsert(homeButton, 1, 1, 5, 1);
		
		// 3열 시작
		gbc.weighty = 0.3;
		gbc.weightx = 0.5;
		gbInsert(new BackGroundLabel(), 0, 2, 1, 1);
		gbInsert(new BackGroundLabel(), 6, 2, 1, 1);
		
        // 3열 출발지버튼
		gbc.weightx = 4.0;
		ShowStartingTerminalEvent sste = new ShowStartingTerminalEvent(this);
		spButton.addActionListener(sste);
		gbInsert(spButton, 1, 2, 2, 1);
		
		gbc.weightx = 1.0;
		gbInsert(new BackGroundLabel(), 3, 2, 1, 1);
		
		// 3열 도착지버튼
		gbc.weightx = 4.0;
		ShowArriveTerminalEvent sate = new ShowArriveTerminalEvent(this);
		arvButton.addActionListener(sate);
		gbInsert(arvButton, 4, 2, 2, 1);
		
		// 4열 시작
		gbc.weighty = 0.03;
		gbInsert(new BackGroundLabel(), 0, 3, 7, 1);
		
		// 5열 시작
		gbc.weightx = 0.5;
		gbc.weighty = 0.03;
		gbInsert(new BackGroundLabel(), 0, 4, 1, 1);
		gbInsert(new BackGroundLabel(), 6, 4, 1, 1);
		
		// 출발날짜?
		gbc.weightx = 1.0;
		BackGroundLabel chulbal = new BackGroundLabel();
		chulbal.setText("출발 날짜 : ");
		gbInsert(chulbal, 1, 4, 1, 1);
		
		// 월 콤보박스
		MonthComboBoxEvent mcbe = new MonthComboBoxEvent(this);
		monBox.addItemListener(mcbe);
		gbInsert(monBox, 2, 4, 1, 1);
		
		// 몇 월
		BackGroundLabel wol = new BackGroundLabel();
		wol.setText("월");
		gbInsert(wol, 3, 4, 1, 1);
		
		// 일 콤보박스
		gbInsert(dayBox, 4, 4, 1, 1);
		gbc.weightx = 1.0;
		// 몇 일
		BackGroundLabel il = new BackGroundLabel();
		il.setText(" 일");
		il.leftSort();
		gbInsert(il, 5, 4, 1, 1);
		
		// 6열 시작
		gbc.weighty = 0.03;
		gbInsert(new BackGroundLabel(), 0, 5, 7, 1);
		
		// 7열 시작
		gbc.weighty = 0.04;
		gbc.weightx = 0.5;
		gbInsert(new BackGroundLabel(), 0, 6, 1, 1);
		gbInsert(new BackGroundLabel(), 6, 6, 1, 1);
		
		// 조회하기 버튼
		gbc.weightx = 1.0;
		gbInsert(new SerchButton(), 1, 6, 5, 1);
		
		// 8열 시작
		gbc.weightx = 0.5;
		gbInsert(new BackGroundLabel(), 0, 7, 1, 1);
		gbInsert(new BackGroundLabel(), 6, 7, 1, 1);
		
		gbc.weightx = 1.0;
		gbInsert(new BackGroundLabel(), 1, 7, 1, 1);
		gbInsert(new BackGroundLabel(), 2, 7, 4, 1);
			
		// 9열 시작
		gbc.weightx = 0.5;
		gbInsert(new BackGroundLabel(), 0, 8, 1, 1);
		gbInsert(new BackGroundLabel(), 6, 8, 1, 1);
		
		gbc.weightx = 1.0;
		gbInsert(new BackGroundLabel(), 1, 8, 1, 1);
		gbInsert(new JButton(), 2, 8, 1, 1);
		gbInsert(new BackGroundLabel(), 3, 8, 1, 1);
		gbInsert(new JButton(), 4, 8, 1, 1);
		gbInsert(new BackGroundLabel(), 5, 8, 1, 1);
		
		// 10열
		gbc.weighty = 0.07;
		gbInsert(new BackGroundLabel(), 0, 9, 7, 1);
	}
	
	// 컴포넌트, 시작좌표, 너비, 높이를 입력하면 레이아웃에 컴포넌트를 추가하는 메서드
	public void gbInsert(Component c, int x, int y, int w, int h){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbl.setConstraints(c, gbc);
		this.add(c);
	}
}
