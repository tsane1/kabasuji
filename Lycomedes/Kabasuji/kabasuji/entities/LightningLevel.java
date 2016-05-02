package kabasuji.entities;

import kabasuji.supers.Level;

/**
 * Subclass of level and entity class for lightning level.
 * 
 *@author Chase St. Laurent
 */
public class LightningLevel extends Level {
	/** variables set to the minutes and seconds on the lightning level timer. */
	private int minsLeft, secsLeft;

	/**
	 * Constructor for the lightning level class.
	 * 
	 * @param String
	 *            name
	 */
	public LightningLevel(String name) {
		super(name, "Lightning");
	}
	
	/**
	 * returns the minutes left on the timer.
	 * @return int
	 */
	public int getMinsLeft() {
		return this.minsLeft;
	}
	
	/**
	 * sets the minutes left on the timer.
	 * @param setMins
	 */
	public void setMinsLeft(int setMins) {
		this.minsLeft = setMins;
	}
	
	/**
	 * gets the number of seconds left on the timer.
	 * @return int
	 */
	public int getSecsLeft() {
		return this.secsLeft;
	}
	
	/**
	 * sets the seconds left for the timer.
	 * @param setSecs
	 */
	public void setSecsLeft(int setSecs) {
		this.secsLeft = setSecs;
	}
	
	/**
	 * Determines the number of stars for achievements based on the numbers collected.
	 */
	@Override
	public void setNumStars() {
		this.numStars = 3;
	}

	/**
	 * Determines whether or not the level has ended based on the progress.
	 */
	@Override
	public boolean hasEnded() {
		return getMinsLeft() + getSecsLeft() == 0;
	}

	/**
	 * Determines if the player has gotten the highest achievement on the level. 
	 */
	@Override
	public boolean hasWon() {
		updateAchievement();
		return (hasEnded() && progress.updateProgressLightning() >= 50) || progress.updateProgressLightning() == 100;
	}
}
