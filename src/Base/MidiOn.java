package Base;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;

class MidiOn extends PlayingThePiano{					//создание, открытие, установка темпа сизтезатора
		public void midiOn() {
			try {
				sequencer = MidiSystem.getSequencer();
				sequencer.open();
				sequence = new Sequence(Sequence.PPQ,4);
				track = sequence.createTrack();
				sequencer.setTempoInBPM(60);
			} catch(Exception e) { e.printStackTrace();}
			
		}
	}