package park.combobox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import park.ReservationInfo;

public class SelectSeatNumBox extends JComboBox<String>{ // 연령별 좌석개수를 고를 콤보박스
	
	ReservationInfo user;
	String[] ageGroup = {"성인", "청소년", "어린이"};
	String age;
	int seatCnt;
	Set<String> key;
	String[] keyArr ;
	
	public SelectSeatNumBox(ReservationInfo user, int seatCnt) { // 예매정보에 연령 좌석 추가해야해서 클래스 그대로 이끌어오고 어떤 좌석에 대한 콤보박스인지 확인해야해서 배열 인덱스로 쓸 seatnum 데려온다
		this.user = user;
		this.seatCnt = seatCnt;
		
		keyArr = new String[user.seatName.size()]; // 좌석수만큼 배열 길이 설정
		selectKey();
		
		addItem(keyArr[seatCnt]+"번 좌석"); // i번째 키 값에 해당하는 좌석 번호를 가장 위에 표시
		addItem("------");
		for(int i=0;i<ageGroup.length;i++) { // 성인 청소년 어린이 추가
			addItem(ageGroup[i]);
		}
		selectSeat();
	}

	
	void selectKey() {
		int i=0;
		key = user.seatName.keySet(); // 좌석 키 값들만 순서대로 추출
		for(String keys : key) {// 키 값들의 순서가 필요하기 때문에 순서대로 추출하고
			keyArr[i++] = keys; // 키 값만 넣을 배열에 넣어준다
		}
	}

	void selectSeat() {
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				age = (String) getSelectedItem().toString(); // 콤보박스에서 고른 값을 string으로 변환
				if(age.equals("------")||age.equals(keyArr[seatCnt]+"번 좌석")) {// 키 값을 고르거나 ---- 고르면 다시 선택하게
					new JOptionPane().showMessageDialog(null, "성인, 청소년, 어린이 중 선택하세요.","오류",JOptionPane.ERROR_MESSAGE); // 성인 어린이 청소년 제외 선택하면 오류창 뜨게
				}else {
					user.seatName.put(keyArr[seatCnt], age); // 해당 좌석번호 자리에 연령대를 넣는다
					System.out.println(user.seatName.get(keyArr[seatCnt])+" 저장 완료 " ); // 해쉬맵에 저장되는지 확인
				}
			}
		});
	}
}
