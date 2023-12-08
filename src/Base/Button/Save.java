package Base.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

import Base.PlayingThePiano;

public class Save extends PlayingThePiano implements ActionListener {					// кнопка действия сохранение шаблона
		public void actionPerformed(ActionEvent a) {
			try {
			JFileChooser fileSave = new JFileChooser();
			fileSave.showSaveDialog(frame);
			saveFile(fileSave.getSelectedFile());
			} catch (Exception ex) {
				
				// ex.printStackTrace();
			}
		}
		
		public void saveFile(File file) {														// процесс сохранения шаблона
			
			boolean [] checkBoxState = new boolean[96];					
			
			for (int i = 0; i<96; i++) {
				JCheckBox check = (JCheckBox) musikJCheckBoxList.get(i);
				if(check.isSelected()) {
					checkBoxState[i] = true;
				}
			}
			
			try {
				FileOutputStream fileStream = new FileOutputStream(file);
				
					ObjectOutputStream os = new ObjectOutputStream(fileStream);
					os.writeObject(checkBoxState);
					os.close();
				} catch (IOException ex) {
				
				// ex.printStackTrace();
			}
		}
		
	}