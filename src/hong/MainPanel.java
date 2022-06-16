package hong;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	HomeButton homeButton = new HomeButton();
	ArrivalButton arvButton = new ArrivalButton();
	DestinationButton desButton = new DestinationButton();
	
	public MainPanel() {
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
		gbc.weighty = 0.1;
		gbInsert(homeButton, 1, 1, 5, 1);
		
		// 3열 시작
		gbc.weighty = 0.3;
		gbc.weightx = 0.5;
		gbInsert(new BackGroundLabel(), 0, 2, 1, 1);
		gbInsert(new BackGroundLabel(), 6, 2, 1, 1);
		
        // 3열 출발지
		gbc.weightx = 4.0;
		gbInsert(arvButton, 1, 2, 2, 1);
		
		gbc.weightx = 1.0;
		gbInsert(new BackGroundLabel(), 3, 2, 1, 1);
		
		// 3열 도착지
		gbc.weightx = 4.0;
		gbInsert(desButton, 4, 2, 2, 1);
		
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
		gbInsert(new MonthComboBox(), 2, 4, 1, 1);
		
		// 몇 월
		BackGroundLabel wol = new BackGroundLabel();
		wol.setText("월");
		gbInsert(wol, 3, 4, 1, 1);
		
		// 일 콤보박스
		gbInsert(new DayComboBox(), 4, 4, 1, 1);
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
	
	 public void gbInsert(Component c, int x, int y, int w, int h){
	        gbc.gridx = x;
	        gbc.gridy = y;
	        gbc.gridwidth = w;
	        gbc.gridheight = h;
	        gbl.setConstraints(c, gbc);
	        this.add(c);
	    }
}
