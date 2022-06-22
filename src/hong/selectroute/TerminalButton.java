package hong.selectroute;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class TerminalButton extends JButton {
	
	public TerminalButton(String terminalName) {
		super(terminalName);
		setFont(new Font("±¼¸²Ã¼", Font.BOLD, 16));
		setPreferredSize(new Dimension(108, 70));
	}
	
}
