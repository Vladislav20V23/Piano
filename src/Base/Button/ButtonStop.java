package Base.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Base.PlayingThePiano;

public class ButtonStop extends PlayingThePiano implements ActionListener {							//реакция кнопки СТОП
		public void actionPerformed(ActionEvent e) {
			sequencer.stop();
			

		}
	}