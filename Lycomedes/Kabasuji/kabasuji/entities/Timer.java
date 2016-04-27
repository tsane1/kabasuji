package kabasuji.entities;

import kabasuji.supers.Level;

/** 
 * Timer entity class.
 * @author Chase St. Laurent
 *
 */
public class Timer {
	/** Current level */
	Level level;
	LightningLevel lightningLevel;
	/**
	 * generic constructor for timer.
	 */
	public Timer(){
		//super();
	}
	
	/**
	 * Keeps track of the seconds left on the timer.
	 * @return int
	 */
	public int timerCount(){
		int count = lightningLevel.getTimeLeft();
		
		while(isLightning(level) && count > 0){
			//need this function for getting time
			count--;
			break;
		} 
		return count;
	}

	/**
	 * determines if the current level is a lightning level.
	 * @param level
	 * @return boolean
	 */
	public boolean isLightning(Level level){
		boolean isLightning = false;
		//TODO: Checks if game mode is lightning
		if(level.getLevelName() == "Lightning"){
			isLightning = true;
		}
		return isLightning;
	}
}
