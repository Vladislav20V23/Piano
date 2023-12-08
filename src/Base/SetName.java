package Base;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SetName extends UserNameGUIclass implements ActionListener {						// действие присвоения имя и закрытие диалогового окна					
		public void actionPerformed(ActionEvent a) {
			use.dispose();
			userName = useNameArea.getText();
		}
	}