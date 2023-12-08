package Base.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import Base.PlayingThePiano;

public class Rand extends ButtonStart implements ActionListener {									//кнопка действия - рандомная мелодия
		public void actionPerformed(ActionEvent e) {
			randMusic();
		}
		
		public void randMusic() {				//рандомная мелодия  
			sequencer.stop();	
			
			int [] ListTracks = null;
			
			for (int i = 0; i<6; i++) {
				ListTracks = new int[16];
				
				
				for(int j = 0; j<16;j++) {
					JCheckBox x = (JCheckBox) (musikJCheckBoxList.get(j+(16*i)));
					if(x.isSelected()) {
						boolean a = getRandomBoolean();
						x.setSelected(a);
					
					} else {
						boolean a = getRandomBoolean();
						x.setSelected(a);
						
					}
				}
				makeTracks(ListTracks);	
				
			}
		}
		
		public static boolean getRandomBoolean() {								//метод рандомного boolean
		       return Math.random() < 0.2;
		      
		   }
		
	}