package kabasuji.entities;

import kabasuji.supers.Level;

/** 
 * 
 * @author Chase St. Laurent
 *
 */
public class Timer {
	Level level;

	public Timer(){
		super();
	}
	
	public int timerCount(){
		int count = 1;
		
		while(isLightning(level) && count > 0){
			//need this functon for getting time
			//count = getTime();
			count--;
		}
		return count;
	}

	public boolean isLightning(Level level){
		boolean isLightning = false;
		//TODO: Checks if game mode is lightning
		if(level.getLevelName() == "Lightning"){
			isLightning = true;
		}
		return isLightning;
	}
}
