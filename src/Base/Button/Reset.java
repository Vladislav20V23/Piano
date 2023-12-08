package Base.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import Base.PlayingThePiano;

public class Reset extends ButtonStart implements ActionListener {									//кнопка действия - сброс мелодии
		public void actionPerformed(ActionEvent e) {
			resetMusic();
		}
		
		
		public void resetMusic() {				//сброс мелодии
			sequencer.stop();	
			
			int [] ListTracks = null;
			
			for (int i = 0; i<6; i++) {
				ListTracks = new int[16];
				
				
				for(int j = 0; j<16;j++) {
					JCheckBox x = (JCheckBox) (musikJCheckBoxList.get(j+(16*i)));
					if(x.isSelected()) {
						x.setSelected(false);
					} 
				}
				makeTracks(ListTracks);	
				
			}
		}
		
	}