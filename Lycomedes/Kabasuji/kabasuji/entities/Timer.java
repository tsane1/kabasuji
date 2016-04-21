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
		int count = 0;
		if(!isLightning(level)){
			count = 0; //OR infinity?
		}
		while(isLightning(level)){
			//count = setBuilderTime();
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
