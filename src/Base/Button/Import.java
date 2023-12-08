package Base.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

import Base.PlayingThePiano;

public class Import extends PlayingThePiano implements ActionListener {					//кнопка действия - загрузка шаблона
		public void actionPerformed(ActionEvent a) {
			try {
			JFileChooser fileOpen = new JFileChooser();
			fileOpen.showOpenDialog(frame);
			loadFile(fileOpen.getSelectedFile());
			} catch (Exception ex) {
				//ex.printStackTrace();
			}
		}
		
		public void loadFile(File file) {													// процесс загрузки шаблона			
			boolean [] checkBoxState = null;
			
			try {
				FileInputStream fileIn = new FileInputStream((file));					
				ObjectInputStream is = new ObjectInputStream(fileIn);
				checkBoxState = (boolean[]) is.readObject();
				is.close();
				} catch (Exception ex) {
				//ex.printStackTrace();
			}
			
			for (int i = 0; i<96; i++) {							
				check = (JCheckBox) musikJCheckBoxList.get(i);
				if(checkBoxState[i]) {
					check.setSelected(true);
				} else {
					check.setSelected(false);
				}
			}
			
			sequencer.stop();						
			
		}

		
	}