package park.frame;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CardPayFrame extends JFrame{
	public CardPayFrame() {
		super("결제 창");
		JLabel card = new JLabel("카드 번호 ");
		JLabel cvc = new JLabel("CVC ");
		JLabel date = new JLabel("유효 기간 ");
		JLabel password = new JLabel("비밀번호 ");
		card.setBounds(40,40,60,30);
		cvc.setBounds(40,100,60,30);
		date.setBounds(40,160,60,30);
		password.setBounds(40,220,60,30);
		
		add(card);
		add(cvc);
		add(date);
		add(password);
		
		
		setLayout(null);
		setResizable(false);
		setBounds(100,100,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CardPayFrame();
	}
}
