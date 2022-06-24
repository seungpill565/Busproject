package park.combobox;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import hong.SaveInfo;
import park.ReservationInfo;

public class SelectSeatAgeBox extends JComboBox<String>{ // 연령별 좌석개수를 고를 콤보박스
	
	SaveInfo user;
	String[] ageGroup = {"성인", "청소년", "아동"};
	String age;
	int seatCnt;
	double discountRate=0;
	String seatName;
	//Integer seatKey = user.getSeatKeys().get(seatCnt); // 체크박스 나오는 순서에 해당하는 자석번호
	
	public SelectSeatAgeBox(SaveInfo user, int seatCnt) { // 예매정보에 연령 좌석 추가해야해서 클래스 그대로 이끌어오고 어떤 좌석에 대한 콤보박스인지 확인해야해서 배열 인덱스로 쓸 seatnum 데려온다
		this.user = user;
		this.seatCnt = seatCnt;
		seatName = user.getSeatNames().get(seatCnt);
		
		addItem(String.format("%d번 좌석", (Integer.parseInt(user.getSeatNames().get(seatCnt))) + 1)); // i번째 키 값에 해당하는 좌석 번호를 가장 위에 표시
		addItem("------");
		for(int i=0;i<ageGroup.length;i++) { // 성인 청소년 어린이 추가
			addItem(ageGroup[i]);
		}
		setName(seatName);
		setBackground(Color.white);
		setSize(10, 10);
		selectSeat();
	}

	void selectSeat() {
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				age = (String) getSelectedItem().toString(); // 콤보박스에서 고른 값을 string으로 변환
				if(age.equals("------")||age.equals(String.format("%d번 좌석", (Integer.parseInt(user.getSeatNames().get(seatCnt))) + 1))) {// 키 값을 고르거나 ---- 고르면 다시 선택하게
					new JOptionPane().showMessageDialog(null, "성인, 청소년, 아동 중 선택하세요.","오류",JOptionPane.ERROR_MESSAGE); // 성인 어린이 청소년 제외 선택하면 오류창 뜨게
				}else {
					discount(age);
					user.getdcBySeat().put(user.getSeatNameBySeatId().get(seatName), discountRate);  // 해당 좌석번호 자리에 할인율 넣는다
					System.out.println(user.getdcBySeat().get(user.getSeatNameBySeatId().get(seatName))+" 저장 완료 " ); // 해쉬맵에 저장되는지 확인

				}
			}
		});
	}
	
	void discount(String age) {
		if(age.equals("성인")) {
			discountRate = 1;
			user.setAgeBySeat(user.getSeatNameBySeatId().get(seatName), age);
		}else if(age.equals("청소년")) {
			discountRate = 0.85;
			user.setAgeBySeat(user.getSeatNameBySeatId().get(seatName), age);
		}else if(age.equals("아동")){
			discountRate = 0.7;
			user.setAgeBySeat(user.getSeatNameBySeatId().get(seatName), age);
		}
	}
}
