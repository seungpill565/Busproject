package hong;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class CenterPanel extends JPanel {
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	BackGroundLabel backGroundLabel = new BackGroundLabel();
	HomeButton homeButton = new HomeButton();
	ArrivalButton arvButton = new ArrivalButton();
	DestinationButton desButton = new DestinationButton();
	
	final private Color backGroundColor = Color.WHITE;
	//final private double weightx = 1.0;
	//final private double weighty = 1.0;
	
	public CenterPanel() {
		// layout을 GridBagLayout으로 설정
		
		setLayout(gbl);
		
		gbc.fill= GridBagConstraints.BOTH;
		
		ArrivalButton arvButton1 = new ArrivalButton();
		ArrivalButton arvButton2 = new ArrivalButton();
		ArrivalButton arvButton3 = new ArrivalButton();
		arvButton3.setText("버튼3");
		ArrivalButton arvButton4 = new ArrivalButton();
		ArrivalButton arvButton5 = new ArrivalButton();
		ArrivalButton arvButton6 = new ArrivalButton();
		ArrivalButton arvButton7 = new ArrivalButton();
		ArrivalButton arvButton8 = new ArrivalButton();
		
		// GridBagLayout 활용하기
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbInsert(homeButton, 0, 0, 1, 1);
		gbInsert(arvButton8, 1, 0, 4, 1);
        gbc.weighty = 2.0;
		gbInsert(arvButton1, 0, 1, 2, 1);
		gbInsert(arvButton2, 2, 1, 1, 1);
		gbInsert(arvButton3, 3, 1, 2, 1);
		gbc.weighty = 0.1;
		gbInsert(arvButton4, 0, 2, 2, 1);
		gbInsert(arvButton5, 2, 2, 1, 1);
		gbInsert(arvButton6, 3, 2, 2, 1);
		gbc.weightx = 1.0;
        gbc.weighty = 4.0;
		gbInsert(arvButton7, 0, 4, 5, 4);
	}
	
	 public void gbInsert(Component c, int x, int y, int w, int h){
	        gbc.gridx = x;
	        gbc.gridy = y;
	        gbc.gridwidth = w;
	        gbc.gridheight = h;
	        gbl.setConstraints(c, gbc);
	        this.add(c);
	    }
}
