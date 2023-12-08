package Base.Server;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Base.PlayingThePiano;

public class Out extends PlayingThePiano implements ActionListener {							//отправляем на сервер, очищаем строку и ползунок ставим в начало строки
		public void actionPerformed(ActionEvent a) {
			
			try {

			writer.println(userName + ": " + outGo.getText());				
			writer.flush();

				} catch(Exception ex) { ex.printStackTrace();}
		

			outGo.setText("");
			outGo.requestFocus(true);
		}
	}