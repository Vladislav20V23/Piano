package Base.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Base.PlayingThePiano;

public class SystemExit extends PlayingThePiano implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		exit();
	}
	
	
	public void exit() {				//выход из программы
		
		try {
	        sock.close();
	        
	        System.out.println("The server is shut down!");
	    } catch (Exception e) { /* failed */ }
		
		System.exit(0);
		
	}
	
}
