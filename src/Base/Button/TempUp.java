package Base.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Base.PlayingThePiano;

public class TempUp extends PlayingThePiano implements ActionListener {									//кнопка - ускорить ритм синтезатора
		public void actionPerformed(ActionEvent e) {
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor * 1.20));
		}
	}