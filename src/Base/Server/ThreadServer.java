package Base.Server;

public class ThreadServer implements Runnable	 {

	
	
	
		public void run()		//Этот метод будет выполняться в побочном потоке
		{
			new ServerPiano().go();
		}
	
}

