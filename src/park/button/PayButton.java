package park.button;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PayButton extends JButton{

	CardLayout cardLayoutManager;
	
	public PayButton(CardLayout cl) {
		cardLayoutManager = cl;
	}
	
	public PayButton() {
		super("결제 하기");
		setBounds(190, 500, 100, 50);
		
		addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//cardLayoutManager.next(getParent());
				System.out.println("결제방식 고르는 화면으로 넘어가기");
				
			}
		});
	}
}
