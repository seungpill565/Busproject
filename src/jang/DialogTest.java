package jang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DialogTest extends JFrame {
	
	ActionListener handler = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("추가")) {// 참조형은 == 비교가아닌
				JOptionPane.showMessageDialog(null, "추가되었습니다", "제목", JOptionPane.WARNING_MESSAGE);
			} else if (e.getActionCommand().equals("수정")) {// 참조형은 == 비교가아닌
				JOptionPane.showMessageDialog(null, "수정되었습니다", "제목", JOptionPane.WARNING_MESSAGE);
			} else if (e.getActionCommand().equals("삭제")) {// 참조형은 == 비교가아닌
				JOptionPane.showMessageDialog(null, "삭제되었습니다", "제목", JOptionPane.WARNING_MESSAGE);
			}
		}
	};

}
