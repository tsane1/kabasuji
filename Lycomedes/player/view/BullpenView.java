package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Bullpen;

public class BullpenView extends JPanel {
	private Bullpen bullpen;
	
	public BullpenView(Bullpen bullpen) {
		super();
		this.bullpen = bullpen;
		setLayout(null);
			
		this.setBounds(12, 522, 908, 218);
	}
}
