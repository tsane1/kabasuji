package kabasuji.entities;

import kabasuji.supers.Level;

/**
 * Subclass of level and entity class for lightning level.
 * @author 
 *
 */
public class LightningLevel extends Level {
	/**
	 * serial id.
	 */
	private static final long serialVersionUID = 1L;
	
	/** int storing the time left. */
	private int timeLeft;
	
	/**
	 * Constructor for the lightning level class.
	 * @param String name
	 */
	public LightningLevel(String name) {
		super(name, "Lightning");
	}
	
	/**
	 * Methodto check how many seconds are left for the level.
	 * @return int seconds left
	 */
	public int getTimeLeft() {
		return this.timeLeft;
	}
	
	/**
	 * Used for setting the initial timer time.
	 * @param int setTime
	 */
	public void setTimeLeft(int setTime) {
		this.timeLeft = setTime;
	}
}
