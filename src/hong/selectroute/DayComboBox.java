package hong.selectroute;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;

public class DayComboBox extends JComboBox<Integer> {
	
	final private static int FIRST_DAY = 1; // 모든 달의 첫째날은 1일..
	private int lastDay;	// 1일부터 마지막날까지 콤보박스에 추가할 것이므로
	private Dimension dimension = new Dimension(110,30);
	
	public DayComboBox() {
		setBackground(Color.WHITE);
		addItem(null);
		setPreferredSize(dimension);
	}
	
	// 아이템(일)들을 추가하는 메서드 몇 월인지를 매개변수로 입력받는다.
	public void addItems(int month) {
		// 달에 따른 lastDay 변수 초기화
		switch (month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				lastDay = 31;
				break;
			case 2:
				lastDay = 28;
				break;
			case 4: case 6: case 9: case 11:
				lastDay = 30;
				break;
			default:
				break;
		}
		
		// 1일부터 마지막날까지 콤보박스에 추가
		for(int i = FIRST_DAY; i <= lastDay; ++i) {
			addItem(i);
		}	
	}
	
	// 콤보박스를 비워주는 메서드 (없으면 달을 바꿀때마다 계속 추가만됨..)
	public void reset() {
		removeAllItems();
	}

}
