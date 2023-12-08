package Base;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

class NameInst extends PlayingThePiano   {		// Создаем коробку для названия(лейбла) нот. Определим шрифт и размер текста, цвет. С помощью цыкла расширяем на 16 значений массива String[] nota.
	
    public void TestPane() {
    	
    	Box nameInst = new Box(BoxLayout.Y_AXIS);
		for(int i = 0; i < 6; i++) {
			setLayout(new GridBagLayout());																											
			JLabel a = new JLabel();	
			a.setText(notaName[i]);
			a.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));										
			a.setFont(new Font("Palatino Linotype Bold Italic", Font.PLAIN, 20));									
			a.setForeground(Color.LIGHT_GRAY);
			
			a.setOpaque(false);
			nameInst.add(a);
			
		}
		backgroundLabel.add(BorderLayout.WEST,nameInst);
    }
    
    
}