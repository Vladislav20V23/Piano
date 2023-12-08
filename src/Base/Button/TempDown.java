package Base.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Base.PlayingThePiano;

public class TempDown extends PlayingThePiano implements ActionListener {									//кнопка - замедлить ритм синтезатора
		public void actionPerformed(ActionEvent e) {
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor * .80));
		}
		
	}