package kabasuji.views;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kabasuji.entities.MoveCounter;
import kabasuji.supers.Level;

/**
 * View class for the move counter in puzzle levels.
 * @author Chase St. Laurent
 *
 */
public class MoveCounterView extends JPanel {
	/** Move counter object. */
	private MoveCounter moveCount;
	/** Level that move counter is tied to. */
	Level level;

	/**
	 * Constructor for the Move count class.
	 * @param moveCounter 
	 */
	public MoveCounterView(MoveCounter moveCount) {
		super(); 
		this.moveCount = moveCount;
		setLayout(null); 

		if (moveCount.isPuzzle(level)) {
			JLabel timeCount = new JLabel("");
			timeCount.setIcon(new ImageIcon(""));
			timeCount.setBounds(0, 0, 75, 25);// x,y,w,h
			add(timeCount);
			this.setBounds(100, 300, 75, 25);
		}

	}

}
