package jang;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class TextHint extends JTextField {
	
	Font gFont = new Font("휴먼편지체", Font.PLAIN, 15);
	Font lFont = new Font("휴먼편지체", Font.PLAIN, 15);
	
	public TextHint(String hint) {
		 setText(hint);
		 setFont(lFont);
		 setForeground(Color.GRAY);
		 
		 this.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				if(getText().equals(hint)) {
					setText("");
					setFont(gFont);
				} else {
					setText(getText());
					setFont(gFont);
				}
				
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if(getText().equals(hint) || getText().length() == 0) {
					setText(hint);
					setFont(lFont);
					setForeground(Color.GRAY);
				} else {
					setText(getText());
					setFont(gFont);
					setForeground(Color.BLACK);
				}
				
			}
		});
	}

}
