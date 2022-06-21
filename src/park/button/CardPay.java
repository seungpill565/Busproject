package park.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import park.frame.CardPayFrame;

public class CardPay extends JButton {
	public CardPay() {
		super("카드 결제");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//JOptinopane
				new CardPayFrame();
			}
		});
		setBounds(50,10,50,50);
	}

}
