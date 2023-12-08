package Base;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class UserNameGUI extends PlayingThePiano implements ActionListener {			// вызов диалогового окна из меню бара 		
		public void actionPerformed(ActionEvent a) {
			new UserNameGUIclass().userNameGUI();

		}
	}