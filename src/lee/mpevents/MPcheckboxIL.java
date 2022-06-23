package lee.mpevents;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MPcheckboxIL implements ItemListener {

	public String br_id;
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(e.getStateChange()==ItemEvent.SELECTED) {
			Pattern br_id_pattern = Pattern.compile("(text=)(\\d+)");
			Matcher matchResult = br_id_pattern.matcher(e.getItem().toString());
			while(matchResult.find()) {		
				br_id = matchResult.group(2);
			} 
		
		} else if (e.getStateChange()!=ItemEvent.SELECTED) {
			br_id = "";
		}
	}
	
}
