package kabasuji.entities;

import kabasuji.supers.Level;

/**
 * Subclass of level and entity class for lightning level.
 * 
 * @author
 *@author Chase St. Laurent
 */
public class LightningLevel extends Level {
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
	
	public int getMinsLeft() {
		return this.minsLeft;
	}
	
	public void setMinsLeft(int setMins) {
		this.minsLeft = setMins;
	}
	
	public int getSecsLeft() {
		return this.secsLeft;
	}
	
	public void setSecsLeft(int setSecs) {
		this.secsLeft = setSecs;
	}
	
	@Override
	public void setNumStars() {
		this.numStars = 3;
	}

	@Override
	public boolean hasEnded() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasWon() {
		// TODO Auto-generated method stub
		return false;
	}
}
