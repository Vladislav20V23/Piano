package Base;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class UserNameGUIclass extends PlayingThePiano {											// диалоговое окно - присвоение игрового ника
		public void userNameGUI() {
		
			use = new JDialog ();
		
			JPanel nikPanel = new JPanel();
			nikPanel.setOpaque(false);
			JLabel nikLabel = new JLabel("Введите свое имя ");
			nikLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));	
			useNameArea = new JTextArea (1,15);
			Font font = new Font("Palatino Linotype Bold Italic", Font.PLAIN, 14);
			nikLabel.setFont(font);
			useNameArea.setFont(font);
		
			JButton ok = new JButton("Ok");
			ok.setBorderPainted(false);
			ok.addActionListener(new SetName());
		
			use.add(nikPanel);
			nikPanel.add(nikLabel);
			nikPanel.add(useNameArea);
			nikPanel.add(ok);
		
			use.setSize(400,120);				
			use.setAlwaysOnTop(true);
			use.setLocationRelativeTo(null);
			use.setResizable(false);
			use.setVisible(true);
		
		}
	}