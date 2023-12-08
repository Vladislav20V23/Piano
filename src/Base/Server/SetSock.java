package Base.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Base.PlayingThePiano;

public class SetSock extends PlayingThePiano{

public void setSock() {											// создает сокеты
		
		try {	
			 sock = new Socket("127.0.0.1", 9900);						
			 InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());	
			 reader = new BufferedReader(streamReader);						
			 writer = new PrintWriter(sock.getOutputStream());	
			 System.out.println("networking established ");
			} catch(IOException ex) { }   // ex.printStackTrace();
		}
}
