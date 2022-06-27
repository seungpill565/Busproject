package park.button;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import hong.SaveInfo;
import park.database.LoadRVID;
import park.database.SaveDB;
import park.frame.PayInfo;

public class PayButton extends JButton{

	public PayButton(SaveInfo user) {
		super("결제 하기");
		setBackground(Color.cyan);
		setBounds(190, 500, 100, 50);
	}
}
