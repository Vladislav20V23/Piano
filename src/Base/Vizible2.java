package Base;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Vizible2 extends PlayingThePiano implements ActionListener {									//закрыть чат - невидимый
		public void actionPerformed(ActionEvent e) {
		
				outGo.setVisible(false);
				out.setVisible(false);
				panelChat.setVisible(false);
				qScroller.setVisible(false);
			
			
		}
	}