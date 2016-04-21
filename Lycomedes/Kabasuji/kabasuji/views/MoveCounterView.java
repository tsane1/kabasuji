package kabasuji.views;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kabasuji.entities.MoveCounter;
import kabasuji.supers.Level;

/**
 * 
 * @author Chase St. Laurent
 *
 */
public class MoveCounterView extends JPanel {
	private MoveCounter moveCount;
	Level level;

	public MoveCounterView(MoveCounter moveCount) {
		super();
		this.moveCount = moveCount;
		setLayout(null);

		if (!moveCount.isLightning(level)) {
			// TODO: Make this receive an integer
			// JLabel timeCount = new JLabel(timer.timerCount());
			// timeCount.setBounds(0, 0, 75, 25);// x,y,w,h
			// add(timeCount);
			this.setBounds(100, 300, 75, 25);
		}
		if (moveCount.isLightning(level)) {
			JLabel timeCount = new JLabel("");
			timeCount.setIcon(new ImageIcon(""));
			timeCount.setBounds(0, 0, 75, 25);// x,y,w,h
			add(timeCount);
			this.setBounds(100, 300, 75, 25);
		}

	}
}
