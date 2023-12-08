package Base.Server;

import java.io.*;
import java.net.*;
import java.util.*;


public class ServerPiano {

	ArrayList clientStream;
	

	public class ClientHalder implements Runnable{											// действия для последующих потоков
		
		BufferedReader reader;
		Socket sock;
		
		public ClientHalder (Socket clientSocket) {											// конструктор, получаем поток от пользователя
			try {
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(isReader);
			} catch (Exception ex) { ex.printStackTrace();}
		
		}
		public void run() {																	//<a> сообщение пользователям
			String message;
			try {
				while((message = reader.readLine()) != null) {
					System.out.println("read_______________ " + message);
					tellEveryone(message);
				}
			} catch (Exception ex) { ex.printStackTrace();}
		}
	}
	
	
	public void go() {																	// ловим сокеты клиентов, налаживаем двухсторонюю связь
		
		clientStream = new ArrayList();
		try {
			ServerSocket serverSocket = new ServerSocket(9900);
			
			while(true) {
				Socket clientSocket = serverSocket.accept();
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				clientStream.add(writer);
				
				Thread t = new Thread(new ClientHalder(clientSocket)); 
				t.start();
				System.out.println("got a connection");
			}
			
		} catch (Exception ex) { ex.printStackTrace();}
	}
		
	public void tellEveryone(String message) {											//описываем метод отправки сообщения
		Iterator it = clientStream.iterator();
		while(it.hasNext()) {
			try {
				PrintWriter writer = (PrintWriter) it.next();
				writer.println(message);
				writer.flush();
			} catch (Exception ex) { ex.printStackTrace();}
		}
	}
	
}
	
	
