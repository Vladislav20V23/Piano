package Base;

import Base.Server.ThreadServer;

public class Main {

	static private ThreadServer threadServer;
	
	public static void main(String[] args) {
		
		threadServer = new ThreadServer();
		Thread myThready = new Thread(threadServer);	//Создание потока "myThready"
		myThready.start();				//Запуск потока
		
		new PlayingThePiano().go();

	}

}
