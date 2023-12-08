package Base;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

class GridLayoutCenter extends PlayingThePiano{			//центральная сетка с чеком
		
		public void GoGridLayoutCenter() {
			
			GridLayout grid = new GridLayout(6,16);  			
			grid.setVgap(5);									
			grid.setHgap(2);	
			mainPanelL = new JPanel();
			mainPanelL.setLayout(new BorderLayout());	
			mainPanelL.setOpaque(false);
			mainPanel = new JPanel(grid);				
			mainPanel.setOpaque(false);
			mainPanelL.add(BorderLayout.NORTH, mainPanel);
			backgroundLabel.add(BorderLayout.CENTER, mainPanelL);		
			
			for (int j = 0; j<96; j++) {
				JCheckBox v = new JCheckBox();
				v.setOpaque(false);
				musikJCheckBoxList.add(v);
				mainPanel.add(v);
				
			}
		}
	}