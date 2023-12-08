package Base.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.swing.JCheckBox;

import Base.PlayingThePiano;

public class ButtonStart extends PlayingThePiano implements ActionListener {							//реакция кнопки  СТАРТ
		public void actionPerformed(ActionEvent e) {
			startTrack(); 
		}
		
		public void startTrack() {									// запуск дорожки звука
			int [] ListTracks = null;
			
			sequence.deleteTrack(track);
			track = sequence.createTrack();

			
			for (int i = 0; i<6; i++) {
				ListTracks = new int[16];
				
				
				
				int key = notaKey[i];
				
				for(int j = 0; j<16;j++) {
					JCheckBox x = (JCheckBox) (musikJCheckBoxList.get(j+(16*i)));
					if(x.isSelected()) {
						ListTracks[j] = key;
					} else { 
						ListTracks[j] = 0;
					}

				}
				makeTracks(ListTracks);	
				track.add(makeEvent(176,1,127,0,16));

			}
			
			 track.add(makeEvent(192,9,1,0,15));
			try {
				sequencer.setSequence(sequence);
				sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);	
				sequencer.start();
				sequencer.setTempoInBPM(60);
			} catch(Exception e) {e.printStackTrace(); }
		}
		
		
		public void makeTracks(int [] list) {										//переводим с чека по ряду каждой ноты1,2,3.. в команду для воспроизводства этой ноты синтезатору 
			for(int o = 0; o<16;o++) {
				int key = list[o];
				
				if(key != 0) {
					track.add(makeEvent(144,1,key, 100, o));		
					track.add(makeEvent(128,1,key, 100, o+2));
				}
			}
		}
		
		public MidiEvent makeEvent(int a, int b, int c, int v, int tick) {			//создаем сообщение и событие используя параметры метода  
			MidiEvent event = null;
			try {											
				ShortMessage r = new ShortMessage();
				r.setMessage(a, b, c, v);
				event = new MidiEvent(r, tick);
				
			} catch(Exception e) {e.printStackTrace();}
			return event;	
		}
		
		
		
	} 