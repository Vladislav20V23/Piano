package Base;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Vizible extends PlayingThePiano implements ActionListener {									//открыть чат - видимый
		public void actionPerformed(ActionEvent e) {
		
				outGo.setVisible(true);
				out.setVisible(true);
				panelChat.setVisible(true);
				qScroller.setVisible(true);
		
		}
	}