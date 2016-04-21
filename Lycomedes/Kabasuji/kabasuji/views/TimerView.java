package kabasuji.views;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kabasuji.entities.Timer;
import kabasuji.supers.Level;

/** 
 * 
 * @author Chase St. Laurent
 *
 */

public class TimerView extends JPanel {
	private Timer timer;
	Level level;

	public TimerView(Timer timer) {
		super();
		this.timer = timer;
		setLayout(null);
		if(timer.isLightning(level)){
			//TODO: Make this receive an integer
			//JLabel timeCount = new JLabel(timer.timerCount());
//			timeCount.setBounds(0, 0, 75, 25);// x,y,w,h
//			add(timeCount);
			this.setBounds(100, 100, 75, 25);
		}
		if(!timer.isLightning(level)){
			JLabel timeCount = new JLabel("");
			timeCount.setIcon(new ImageIcon(""));
			timeCount.setBounds(0, 0, 75, 25);// x,y,w,h
			add(timeCount);
			this.setBounds(100, 100, 75, 25);
		}
		
	}
}
