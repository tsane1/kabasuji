package kabasuji.views;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kabasuji.entities.Timer;
import kabasuji.supers.Level;

/** 
 * View for the timer on lightning levels.
 * @author Chase St. Laurent
 *
 */
public class TimerView extends JPanel {
	/** Timer instance being drawn. */
	private Timer timer;
	/** Level timer is running on. */
	Level level;

	/**
	 * View class that displays the timer.
	 * @param timer
	 */
	public TimerView(Timer timer) {
		super();
		this.timer = timer; 
		setLayout(null);
		if(timer.isLightning(level)){
			JLabel timeCount = new JLabel("");
			timeCount.setIcon(new ImageIcon(""));
			timeCount.setBounds(0, 0, 75, 25);// x,y,w,h
			add(timeCount);
			this.setBounds(100, 300, 75, 25);
		}
		
	}
}
