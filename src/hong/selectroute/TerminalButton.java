package hong.selectroute;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class TerminalButton extends JButton {
	
	public TerminalButton(String terminalName) {
		super(terminalName);
		setBackground(new Color(0xE0E0E0));
		setFont(new Font("±¼¸²Ã¼", Font.BOLD, 16));
		setPreferredSize(new Dimension(108, 70));
	}
	
}
