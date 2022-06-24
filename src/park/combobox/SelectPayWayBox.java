package park.combobox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import park.ReservationInfo;

public class SelectPayWayBox extends JComboBox{ // 결제 방법 선택할 콤보박스
	
	ReservationInfo user;
	public SelectPayWayBox(ReservationInfo user) {
		
		this.user = user;
		
		addItem("결제 방식");
		addItem("------");
		addItem("신용카드");
		addItem("삼성페이");
		addItem("페이코");
		
		selectPayWay();
		setBounds(190, 440, 100, 50);
	}

	void selectPayWay() {
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String way = (String) getSelectedItem().toString();
				if(way.equals("------")||way.equals("결제 방식")) {// 키 값을 고르거나 ---- 고르면 다시 선택하게
					new JOptionPane().showMessageDialog(null, "결제 방식울 선택하세요.","오류",JOptionPane.ERROR_MESSAGE); 
				}else {
					user.setPayWay((String) getSelectedItem().toString()) ;
					System.out.println(user.getPayWay());
				}
			}
		});
	}
}
