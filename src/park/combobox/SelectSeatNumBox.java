package park.combobox;

import javax.swing.JComboBox;

public class SelectSeatNumBox extends JComboBox{ // 연령별 좌석개수를 고를 콤보박스
	
	String person;
	int num;
	
	public SelectSeatNumBox(String person, int num) {
		this.person = person;
		this.num = num;
	}

}
