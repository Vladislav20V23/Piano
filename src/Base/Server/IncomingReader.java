package Base.Server;

import Base.PlayingThePiano;

public class IncomingReader extends PlayingThePiano implements Runnable {								// действия второго потока - вывод из сервера текста всем пользователям
	
	
	public void run() {
		String message;
		try {
			while((message = reader.readLine()) != null) {

				 tablo.append(message + "\n");
			}
		} catch (Exception ex) {   }	// ex.printStackTrace();
	}
	
}